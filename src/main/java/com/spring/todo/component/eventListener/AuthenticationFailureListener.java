package com.spring.todo.component.eventListener;

import com.spring.todo.services.LoginAttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.http.HttpServletRequest;

public class AuthenticationFailureListener extends SimpleUrlAuthenticationFailureHandler implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private LoginAttemptService loginAttemptService;

    @Autowired
    private MessageSource messages;

    @Override
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) {
        final String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader == null || xfHeader.isEmpty() || !xfHeader.contains(request.getRemoteAddr())) {
            loginAttemptService.loginFailed(request.getRemoteAddr());
        } else {
            loginAttemptService.loginFailed(xfHeader.split(",")[0]);
        }
    }

}
