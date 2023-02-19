package com.spring.todo.services;

import com.spring.todo.model.response.AdminResponse;
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
import java.util.stream.Collectors;

@Service
public class AdminService extends BaseService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ModelMapper modelMapper;

    public AdminResponse getInfo(Authentication authentication) {
        String adminId = authentication.getName();
        Optional<AdminEntity> adminEntity = adminRepository.findById(adminId);
        return adminEntity.get().toReponse();
    }

    public AdminResponse getAdmin(String id) {
        AdminEntity adminEntity = adminRepository.getReferenceById(id);
        return adminEntity.toReponse();
    }

    public List<AdminResponse> getAdmins(String email, String id, Integer skip, Integer limit) {
        List<AdminEntity> listAdminEntity = new ArrayList<>();

        if (!ObjectUtils.isEmpty(id)) {
            listAdminEntity = adminRepository.findAdminByLikeId(id);
        } else if (!ObjectUtils.isEmpty(email)) {
            listAdminEntity = adminRepository.findAdminByLikeEmail(email);
        }

        return listAdminEntity.stream().map(adminEntity -> adminEntity.toReponse()).collect(Collectors.toList());
    }

    public AdminResponse updateAdmin(AdminInput adminInput, String id) {
        AdminEntity adminEntity = new AdminEntity();
        modelMapper.map(adminInput, adminEntity);
        adminEntity.setId(id);
        adminEntity = adminRepository.save(adminEntity);
        AdminResponse adminResponse = new AdminResponse();
        modelMapper.map(adminEntity, adminResponse);
        return adminResponse;
    }

    public AdminResponse updatePassword(Authentication authentication, String password, String oldPassword) {
        return null;
    }
}
