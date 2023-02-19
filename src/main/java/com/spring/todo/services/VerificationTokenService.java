package com.spring.todo.services;

import com.spring.todo.model.entities.VerificationTokenEntity;
import org.springframework.stereotype.Service;

@Service
public class VerificationTokenService extends BaseService {
    public VerificationTokenEntity generateNewVerificationToken(String existingToken) {
        return null;
    }

    public VerificationTokenEntity getVerificationToken(String token) {
        return null;
    }
}
