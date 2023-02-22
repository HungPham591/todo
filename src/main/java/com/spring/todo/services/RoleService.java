package com.spring.todo.services;

import com.spring.todo.model.entities.RoleEntity;
import com.spring.todo.model.inputs.RoleInput;
import com.spring.todo.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService extends BaseService {

    @Autowired
    private RoleRepository roleRepository;

    public RoleEntity getRole(String id) {
        Optional<RoleEntity> role = roleRepository.findById(id);
        return role.get();
    }

    public List<RoleEntity> getRoles() {
        List<RoleEntity> listRole = roleRepository.findAll();
        return listRole;
    }

    public RoleEntity createRole(RoleInput roleInput) {
        RoleEntity role = roleRepository.save(roleInput.toEntity());
        return role;
    }

    public RoleEntity updateRole(String id, RoleInput roleInput) {
        RoleEntity role = roleInput.toEntity();
        role.setId(id);
        role = roleRepository.save(role);
        return role;
    }

    public RoleEntity setRole() {
        return null;
    }

    public RoleEntity deleteRole(String id) {
        RoleEntity role = new RoleEntity();
        role.setId(id);
        roleRepository.deleteById(id);
        return role;
    }
}
