package com.spring.todo.services;

import com.spring.todo.model.entities.AdminEntity;
import com.spring.todo.model.inputs.AdminInput;
import com.spring.todo.repositories.AdminRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService extends BaseService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ModelMapper modelMapper;

    public AdminEntity getInfo(Authentication authentication) throws Exception {
        String adminId = authentication.getName();
        return this.getAdmin(adminId);
    }

    public AdminEntity getAdmin(String id) throws Exception {
        Optional<AdminEntity> adminEntity = adminRepository.findById(id);
        if (adminEntity.isEmpty()) {
            throw new Exception();
        }
        return adminEntity.get();
    }

    public List<AdminEntity> getAdmins(String email, String id, Integer skip, Integer limit) throws Exception {
        List<AdminEntity> listAdminEntity = new ArrayList<>();

        if (!ObjectUtils.isEmpty(id)) {
            listAdminEntity = adminRepository.findAdminByLikeId(id);
        } else if (!ObjectUtils.isEmpty(email)) {
            listAdminEntity = adminRepository.findAdminByLikeEmail(email);
        }

        if (ObjectUtils.isEmpty(listAdminEntity)) {
            throw new Exception();
        }

        return listAdminEntity;
    }

    public AdminEntity updateAdmin(String user, AdminInput adminInput, String id) throws Exception {
        AdminEntity admin = this.getAdmin(id);
        if (admin.getId().equals(user)) {
            throw new Exception();
        }
        AdminEntity adminEntity = adminInput.toEntity();
        adminEntity.setId(id);
        adminEntity.setPassword(passwordEncoder.encode(adminEntity.getPassword()));
        adminEntity = adminRepository.save(adminEntity);
        if (ObjectUtils.isEmpty(adminEntity)) {
            throw new Exception();
        }
        return adminEntity;
    }

    public AdminEntity updatePassword(String user, String password, String oldPassword) throws Exception {
        oldPassword = passwordEncoder.encode(oldPassword);
        password = passwordEncoder.encode(password);
        AdminEntity adminEntity = getAdmin(user);
        if (adminEntity.getPassword().equals(oldPassword)) {
            throw new Exception();
        }
        adminEntity.setPassword(password);
        adminEntity = adminRepository.save(adminEntity);
        if (ObjectUtils.isEmpty(adminEntity)) {
            throw new Exception();
        }
        return adminEntity;
    }
}
