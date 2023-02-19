package com.spring.todo.services;

import com.spring.todo.model.response.RoleResponse;
import com.spring.todo.model.entities.RoleEntity;
import com.spring.todo.model.inputs.RoleInput;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class TagService extends BaseService {
    public ResponseEntity<RoleResponse> getRole(String id) {
        return null;
    }

    public ResponseEntity<RoleResponse> getRoles(String name, Integer skip, Integer limit) {
        return null;
    }

    public ResponseEntity<RoleResponse> getMyRole(Authentication authentication, String group) {
        return null;
    }

    public ResponseEntity<RoleResponse> createRole(RoleInput roleInput) {
        return null;
    }

    public ResponseEntity<RoleEntity> updateRole(String id, RoleInput roleInput) {
        return null;
    }

    public ResponseEntity<RoleEntity> deleteRole(String id) {
        return null;
    }
}
