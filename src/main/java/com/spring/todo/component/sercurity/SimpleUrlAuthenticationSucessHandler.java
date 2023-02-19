package com.spring.todo.component.sercurity;

import com.spring.todo.model.inputs.AccountInput;
import com.spring.todo.services.DeviceMetaDataService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SimpleUrlAuthenticationSucessHandler implements AuthenticationSuccessHandler {
    private static final Logger logger = LogManager.getLogger(SimpleUrlAuthenticationSucessHandler.class);
    @Autowired
    private DeviceMetaDataService deviceMetaDataService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        AuthenticationSuccessHandler.super.onAuthenticationSuccess(request, response, chain, authentication);
        loginNotification(authentication, request);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

    }

    private void loginNotification(Authentication authentication, HttpServletRequest request) {
        try {
            if (authentication.getPrincipal() instanceof AccountInput) {
                deviceMetaDataService.verifyDevice(((AccountInput) authentication.getPrincipal()), request);
            }
        } catch (Exception e) {
            logger.error("An error occurred verifying device or location");
            throw new RuntimeException(e);
        }
    }
}
