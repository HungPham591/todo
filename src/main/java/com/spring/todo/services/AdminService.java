package com.spring.todo.services;

import com.spring.todo.model.entities.AdminEntity;
import com.spring.todo.model.inputs.AdminInput;
import com.spring.todo.repositories.AdminRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService extends BaseService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ModelMapper modelMapper;

    public AdminEntity getInfo(Authentication authentication) {
        String adminId = authentication.getName();
        Optional<AdminEntity> adminEntity = adminRepository.findById(adminId);
        return adminEntity.get();
    }

    public AdminEntity getAdmin(String id) {
        Optional<AdminEntity> adminEntity = adminRepository.findById(id);
        return adminEntity.get();
    }

    public List<AdminEntity> getAdmins(String email, String id, Integer skip, Integer limit) {
        List<AdminEntity> listAdminEntity = new ArrayList<>();

        if (!ObjectUtils.isEmpty(id)) {
            listAdminEntity = adminRepository.findAdminByLikeId(id);
        } else if (!ObjectUtils.isEmpty(email)) {
            listAdminEntity = adminRepository.findAdminByLikeEmail(email);
        }

        return listAdminEntity;
    }

    public AdminEntity updateAdmin(AdminInput adminInput, String id) {
        AdminEntity adminEntity = adminInput.toEntity();
        adminEntity.setId(id);
        adminEntity = adminRepository.save(adminEntity);
        return adminEntity;
    }

    public AdminEntity updatePassword(Authentication authentication, String password, String oldPassword) {
        return null;
    }
}
