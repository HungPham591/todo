package com.spring.todo.services;

import com.spring.todo.model.inputs.AdminInput;
import com.spring.todo.model.inputs.UserInput;
import org.springframework.stereotype.Service;

@Service
public class AuthService extends BaseService {
    public boolean validateAdminAccount(AdminInput adminInput) throws Exception {
        return false;
    }

    public boolean validateUserAccount(UserInput userInput) throws Exception {
        return false;
    }

    public boolean validateGoogleAccount(String id, String tokenId) throws Exception {
        return false;
    }

    public boolean validateFacebookAccount(String id, String tokenId) throws Exception {
        return false;
    }

    public boolean compareId(String id, String storedId) throws Exception {
        return false;
    }
}
