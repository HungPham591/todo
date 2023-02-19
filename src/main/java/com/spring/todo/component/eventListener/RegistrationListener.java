package com.spring.todo.component.eventListener;

import com.spring.todo.common.events.OnRegistrationCompleteEvent;
import com.spring.todo.model.inputs.AccountInput;
import com.spring.todo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {
    @Autowired
    private UserService userService;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void onApplicationEvent(OnRegistrationCompleteEvent event) {
        confirmRegistration(event);
    }

    //send email to user when user register successfully
    private void confirmRegistration(OnRegistrationCompleteEvent event) {
        try {
            AccountInput accountInput = event.getAccountInput();
            String token = UUID.randomUUID().toString();
            userService.createVerificationToken(accountInput, token);

            String recipientAddress = accountInput.getEmail();
            String subject = "Registration Confirmation";
            String confirmationUrl = event.getAppUrl() + "/regitrationConfirm?token=" + token;
//            String message = messageSource.getMessage("message.regSucc", null, event.getLocale());

            SimpleMailMessage email = new SimpleMailMessage();
//            email.setFrom(gmail);
            email.setTo(recipientAddress);
            email.setSubject(subject);
            email.setText("http://localhost:8080" + confirmationUrl);
            mailSender.send(email);
        } catch (Exception e) {
            System.out.println("send email error:::" + e);
        }
    }
}
