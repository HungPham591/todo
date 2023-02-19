package com.spring.todo.services;

import com.spring.todo.model.entities.DeviceMetaDataEntity;
import com.spring.todo.model.inputs.AccountInput;
import com.spring.todo.repositories.DeviceMetaDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Service
public class DeviceMetaDataService extends BaseService {
    @Autowired
    private DeviceMetaDataRepository deviceMetaDataRepository;

    @Autowired
    private HttpServletRequest request;

    public void verifyDevice(AccountInput accountInput, HttpServletRequest request) {
//        String ip = extractIp(request);
//        String location = getIpLocation(ip);
//
//        String deviceDetails = getDeviceDetails(request.getHeader("user-agent"));
//
//        DeviceMetaDataEntity existingDevice
//                = findExistingDevice(account.getId(), deviceDetails, location);
//
//        if (Objects.isNull(existingDevice)) {
//            unknownDeviceNotification(deviceDetails, location, ip, user.getEmail(), request.getLocale());
//
//            DeviceMetadata deviceMetadata = new DeviceMetadata();
//            deviceMetadata.setUserId(user.getId());
//            deviceMetadata.setLocation(location);
//            deviceMetadata.setDeviceDetails(deviceDetails);
//            deviceMetadata.setLastLoggedIn(new Date());
//            deviceMetadataRepository.save(deviceMetadata);
//        } else {
//            existingDevice.setLastLoggedIn(new Date());
//            deviceMetadataRepository.save(existingDevice);
//        }
    }

    private String extractIp(HttpServletRequest request) {
//        String clientIp;
//        String clientXForwardedForIp = request
//                .getHeader("x-forwarded-for");
//        if (clientXForwardedForIp != null) {
//            clientIp = parseXForwardedHeader(clientXForwardedForIp);
//        } else {
//            clientIp = request.getRemoteAddr();
//        }
//        return clientIp;
        return null;
    }
    private String getIpLocation(String ip) {
//        String location = "UNKNOWN";
//        InetAddress ipAddress = InetAddress.getByName(ip);
//        CityResponse cityResponse = databaseReader
//                .city(ipAddress);
//
//        if (Objects.nonNull(cityResponse) &&
//                Objects.nonNull(cityResponse.getCity()) &&
//                !Strings.isNullOrEmpty(cityResponse.getCity().getName())) {
//            location = cityResponse.getCity().getName();
//        }
//        return location;
        return null;
    }
    private String getDeviceDetails(String userAgent) {
//        String deviceDetails = "UNKNOWN";
//
//        Client client = parser.parse(userAgent);
//        if (Objects.nonNull(client)) {
//            deviceDetails = client.userAgent.family
//                    + " " + client.userAgent.major + "."
//                    + client.userAgent.minor + " - "
//                    + client.os.family + " " + client.os.major
//                    + "." + client.os.minor;
//        }
//        return deviceDetails;
        return null;
    }

    private DeviceMetaDataEntity findExistingDevice(String accountId, String deviceDetails, String location) {
//        List<DeviceMetaDataEntity> knownDevices = deviceMetaDataRepository.findByAccountId(accountId);
//
//        for (DeviceMetaDataEntity existingDevice : knownDevices) {
//            if (existingDevice.getDeviceDetails().equals(deviceDetails) && existingDevice.getLocation().equals(location)) {
//                return existingDevice;
//            }
//        }
        return null;
    }

    private void unknownDeviceNotification(String deviceDetails,String location, String ip, String email, Locale locale){

    }
}
