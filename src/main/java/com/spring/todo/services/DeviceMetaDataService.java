package com.spring.todo.services;

import com.google.common.base.Strings;
import com.maxmind.geoip2.model.CityResponse;
import com.spring.todo.model.entities.DeviceMetaDataEntity;
import com.spring.todo.model.inputs.AccountInput;
import com.spring.todo.repositories.DeviceMetaDataRepository;
import net.sf.uadetector.UserAgentStringParser;
import net.sf.uadetector.service.UADetectorServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua_parser.Client;
import ua_parser.UserAgentParser;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.util.*;

@Service
public class DeviceMetaDataService extends BaseService {
    @Autowired
    private DeviceMetaDataRepository deviceMetaDataRepository;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private GeoService geoService;

    public void verifyDevice(AccountInput account, HttpServletRequest request) throws Exception {
        String ip = extractIp(request);
        String location = getIpLocation(ip);

        String deviceDetails = getDeviceDetails(request.getHeader("user-agent"));

        DeviceMetaDataEntity existingDevice
                = findExistingDevice(account.getId(), deviceDetails, location);

        if (Objects.isNull(existingDevice)) {
            unknownDeviceNotification(deviceDetails, location, ip, account.getEmail(), request.getLocale());

            DeviceMetaDataEntity deviceMetadata = new DeviceMetaDataEntity();
            deviceMetadata.setAccount(account.toEntity());
            deviceMetadata.setLocation(location);
            deviceMetadata.setDeviceDetails(deviceDetails);
            deviceMetadata.setLastLoggedIn(new Date());
            deviceMetaDataRepository.save(deviceMetadata);
        } else {
            existingDevice.setLastLoggedIn(new Date());
            deviceMetaDataRepository.save(existingDevice);
        }
    }

    private String extractIp(HttpServletRequest request) throws Exception {
        String clientIp;
        String clientXForwardedForIp = request
                .getHeader("x-forwarded-for");
        if (clientXForwardedForIp != null) {
            clientIp = parseXForwardedHeader(clientXForwardedForIp);
        } else {
            clientIp = request.getRemoteAddr();
        }
        return clientIp;
    }

    private String parseXForwardedHeader(String ip){
        return null;
    }

    private String getIpLocation(String ip) throws Exception {
        String location = "UNKNOWN";
        InetAddress ipAddress = InetAddress.getByName(ip);
        CityResponse cityResponse = geoService.getGeoDatabase().city(ipAddress);

        if (Objects.nonNull(cityResponse) &&
                Objects.nonNull(cityResponse.getCity()) &&
                !Strings.isNullOrEmpty(cityResponse.getCity().getName())) {
            location = cityResponse.getCity().getName();
        }
        return location;
    }

    private String getDeviceDetails(String userAgent) throws Exception {
        try {
            String deviceDetails = "UNKNOWN";
            UserAgentStringParser parser = UADetectorServiceFactory.getResourceModuleParser();
            Client client = (Client) parser.parse(userAgent);
            if (Objects.nonNull(client)) {
                deviceDetails = client.userAgent.family
                        + " " + client.userAgent.major + "."
                        + client.userAgent.minor + " - "
                        + client.os.family + " " + client.os.major
                        + "." + client.os.minor;
            }
            return deviceDetails;
        } catch (Exception e) {
            System.out.println("getDeviceDetails");
            return "";
        }
    }

    private DeviceMetaDataEntity findExistingDevice(String accountId, String deviceDetails, String location) throws Exception {
        List<DeviceMetaDataEntity> knownDevices = deviceMetaDataRepository.findByAccountId(accountId);

        for (DeviceMetaDataEntity existingDevice : knownDevices) {
            if (existingDevice.getDeviceDetails().equals(deviceDetails) && existingDevice.getLocation().equals(location)) {
                return existingDevice;
            }
        }
        return null;
    }

    private void unknownDeviceNotification(String deviceDetails, String location, String ip, String email, Locale locale) throws Exception {

    }
}
