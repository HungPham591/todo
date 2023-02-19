package com.spring.todo.repositories.custom;

import com.spring.todo.model.entities.AdminEntity;

import java.util.List;

public interface AdminRepositoryCustom {
    public List<AdminEntity> findAdminByLikeEmail(String email);
    public List<AdminEntity> findAdminByLikeId(String id);
}
