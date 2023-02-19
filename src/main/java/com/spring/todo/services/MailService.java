package com.spring.todo.services;

import com.spring.todo.model.entities.AccountEntity;
import com.spring.todo.model.entities.VerificationTokenEntity;
import com.spring.todo.model.inputs.AccountInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class MailService extends BaseService {

    @Autowired
    private MessageSource messages;

    @Autowired
    private Environment env;

    public SimpleMailMessage constructResendVerificationTokenEmail(String contextPath, Locale locale, VerificationTokenEntity newToken, AccountEntity user) {
        String confirmationUrl = contextPath + "/regitrationConfirm.html?token=" + newToken.getToken();
        String message = messages.getMessage("message.resendToken", null, locale);
        SimpleMailMessage email = new SimpleMailMessage();
        email.setSubject("Resend Registration Token");
        email.setText(message + " rn" + confirmationUrl);
        email.setFrom(env.getProperty("support.email"));
        email.setTo(user.getEmail());
        return email;
    }
    public SimpleMailMessage constructResetTokenEmail(String contextPath, Locale locale, String token, AccountInput accountInput) {
        String url = contextPath + "/user/changePassword?token=" + token;
        String message = messages.getMessage("message.resetPassword", null, locale);
        return constructEmail("Reset Password", message + " \r\n" + url, accountInput);
    }

    public SimpleMailMessage constructEmail(String subject, String body, AccountInput accountInput) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setSubject(subject);
        email.setText(body);
        email.setTo(accountInput.getEmail());
        email.setFrom(env.getProperty("support.email"));
        return email;
    }
}
