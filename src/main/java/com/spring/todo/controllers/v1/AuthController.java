package com.spring.todo.controllers.v1;

import com.spring.todo.common.events.OnRegistrationCompleteEvent;
import com.spring.todo.controllers.BaseController;
import com.spring.todo.model.response.AccountResponse;
import com.spring.todo.model.entities.AccountEntity;
import com.spring.todo.model.entities.VerificationTokenEntity;
import com.spring.todo.model.inputs.AccountInput;
import com.spring.todo.services.AccountService;
import com.spring.todo.services.MailService;
import com.spring.todo.services.VerificationTokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@RestController
@RequestMapping(value = "/v1/auth")
public class AuthController extends BaseController {
    private final static Logger logger = LoggerFactory.getLogger(AuthController.class);
    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    private AccountService accountService;

    @Autowired
    private VerificationTokenService verificationTokenService;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private MailService mailService;

    @PostMapping("/registration")
    public ResponseEntity<String> registerUserAccount(
            @RequestBody @Valid AccountResponse accountResponse,
            HttpServletRequest request, Errors errors) throws Exception {
        try {
            AccountInput registered = accountService.registerNewUserAccount(accountResponse);


            String appUrl = request.getContextPath();
            eventPublisher.publishEvent(new OnRegistrationCompleteEvent(registered, request.getLocale(), appUrl));
//        } catch (UserAlreadyExistException uaeEx) {
            //An account for that username/email already exists.
        } catch (RuntimeException ex) {
            //emailError
        } catch (Exception e) {
            logger.error("[AuthController][registerUserAccount] error {}", e);
        }
        //successRegister
        return ResponseEntity.ok("successRegister");
    }

    //gui lai refresh token
    @GetMapping("/resendRegistrationToken")
    public ResponseEntity<String> resendRegistrationToken(
            HttpServletRequest request,
            @RequestParam("token") String existingToken) throws Exception {
        VerificationTokenEntity newToken = verificationTokenService.generateNewVerificationToken(existingToken);

        AccountEntity account = newToken.getAccount();
        String appUrl = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
        SimpleMailMessage email = mailService.constructResendVerificationTokenEmail(appUrl, request.getLocale(), newToken, account);
        mailSender.send(email);

        return ResponseEntity.ok("ok");
    }

    //duong link tren email ma user duoc nhan khi tao tai khoan
    @GetMapping("/registrationConfirm")
    public ResponseEntity<String> confirmRegistration(Locale locale, Model model, @RequestParam("token") String token) throws Exception {
        VerificationTokenEntity verificationToken = verificationTokenService.getVerificationToken(token);
        if (verificationToken == null) {
            //khong co token
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("token not found");
        }

        Calendar cal = Calendar.getInstance();
        if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
            //token het han
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("token invalid");
        }

        accountService.confirmRegistration(token);

        //redirect
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/password")
    @PreAuthorize("hasRole('READ_PRIVILEGE')")
    public ResponseEntity<String> changeUserPassword(Authentication authentication,
                                                     @RequestParam("password") String password,
                                                     @RequestParam("oldpassword") String oldPassword) throws Exception {
        Map<String, Object> filter = new HashMap<>();
        filter.put("user_id", authentication.getName());

        AccountInput accountInput = accountService.getAccountByFilter(filter);

        if (!accountService.checkIfValidOldPassword(accountInput, oldPassword)) {
//            throw new InvalidOldPasswordException();
        }
        accountService.changeUserPassword(accountInput, password);
        return ResponseEntity.ok("ok");
    }

}
