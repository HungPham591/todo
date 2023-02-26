package com.spring.todo.services;

import com.spring.todo.model.entities.AccountEntity;
import com.spring.todo.model.entities.PasswordResetTokenEntity;
import com.spring.todo.repositories.PasswordResetTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class PasswordResetTokenService extends BaseService {
    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;

    public void createPasswordResetTokenForUser(AccountEntity account, String token) throws Exception {
        PasswordResetTokenEntity myToken = new PasswordResetTokenEntity();
        myToken.setToken(token);
        myToken.setAccount(account);
        passwordResetTokenRepository.save(myToken);
    }

    private boolean isTokenFound(PasswordResetTokenEntity passToken) throws Exception {
        return passToken != null;
    }

    private boolean isTokenExpired(PasswordResetTokenEntity passToken) throws Exception {
        final Calendar cal = Calendar.getInstance();
        return passToken.getExpiryDate().before(cal.getTime());
    }

    public String validatePasswordResetToken(String token) throws Exception {
        final PasswordResetTokenEntity passToken = passwordResetTokenRepository.findByToken(token);

        return !isTokenFound(passToken) ? "invalidToken" : isTokenExpired(passToken) ? "expired" : null;
    }
}
