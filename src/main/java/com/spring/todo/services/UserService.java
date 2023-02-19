package com.spring.todo.services;

import com.spring.todo.model.response.UserResponse;
import com.spring.todo.model.inputs.AccountInput;
import com.spring.todo.model.inputs.UserInput;
import com.spring.todo.repositories.UserRepository;
import com.spring.todo.repositories.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    public void createVerificationToken(AccountInput accountInput, String token) {

    }

    public ResponseEntity<UserResponse> getInfo(Authentication authentication) {
        authentication.getName();
        return null;
    }

    public ResponseEntity<UserResponse> getUser(String id) {
        return null;
    }

    public ResponseEntity<UserResponse> getSuggestUser(String name, Integer skip, Integer limit) {
        return null;
    }

    public ResponseEntity<UserResponse> getMyContacts(String name, Integer skip, Integer limit) {
        return null;
    }

    public ResponseEntity<UserResponse> getRequestUser(String name, Integer skip, Integer limit) {
        return null;
    }

    public ResponseEntity<UserResponse> updateUser(String id, UserInput userInput) {
        return null;
    }

    public ResponseEntity<UserResponse> updatePassword(Authentication authentication, String password, String oldPassword
    ) {
        return null;
    }

    public ResponseEntity<UserResponse> deleteUser(String id) {
        return null;
    }
}
