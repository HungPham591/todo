package com.spring.todo.model.inputs;

import com.spring.todo.model.entities.AdminEntity;
import lombok.Getter;

@Getter
public class AdminInput extends BaseInput<AdminInput, AdminEntity> {
    private String email;
    private String password;

    @Override
    public AdminEntity toEntity() {
        return null;
    }
}
