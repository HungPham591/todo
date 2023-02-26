package com.spring.todo.services;

import com.spring.todo.model.entities.RoleEntity;
import com.spring.todo.model.inputs.RoleInput;
import com.spring.todo.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService extends BaseService {

    @Autowired
    private RoleRepository roleRepository;

    public RoleEntity getRole(String id) throws Exception {
        Optional<RoleEntity> role = roleRepository.findById(id);
        if (role.isEmpty()) {
            throw new Exception();
        }
        return role.get();
    }

    public List<RoleEntity> getRoles() throws Exception {
        List<RoleEntity> listRole = roleRepository.findAll();
        if (listRole.isEmpty()) {
            throw new Exception();
        }
        return listRole;
    }

    public RoleEntity createRole(RoleInput roleInput) throws Exception {
        RoleEntity role = roleRepository.save(roleInput.toEntity());
        if (ObjectUtils.isEmpty(role)) {
            throw new Exception();
        }
        return role;
    }

    public RoleEntity updateRole(String id, RoleInput roleInput) throws Exception {
        RoleEntity role = roleInput.toEntity();
        role.setId(id);
        role = roleRepository.save(role);
        if (ObjectUtils.isEmpty(role)) {
            throw new Exception();
        }
        return role;
    }

    public RoleEntity deleteRole(String id) throws Exception {
        RoleEntity role = new RoleEntity();
        role.setId(id);
        roleRepository.deleteById(id);
        if (ObjectUtils.isEmpty(role)) {
            throw new Exception();
        }
        return role;
    }
}
