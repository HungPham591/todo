package com.spring.todo.services;

import com.spring.todo.model.entities.UserEntity;
import com.spring.todo.model.inputs.AccountInput;
import com.spring.todo.model.inputs.UserInput;
import com.spring.todo.repositories.UserRepository;
import com.spring.todo.repositories.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    public void createVerificationToken(AccountInput accountInput, String token) throws Exception {

    }

    public UserEntity getInfo(Authentication authentication) throws Exception {
        authentication.getName();
        return null;
    }

    public UserEntity getUser(String id) throws Exception {
        return null;
    }

    public UserEntity updateUser(String user, String id, UserInput userInput) throws Exception {
        return null;
    }

    public UserEntity updatePassword(String user, String password, String oldPassword) throws Exception {
        return null;
    }

    public UserEntity deleteUser(String user, String id) throws Exception {
        return null;
    }
}
