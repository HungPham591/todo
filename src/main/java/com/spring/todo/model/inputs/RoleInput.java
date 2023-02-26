package com.spring.todo.model.inputs;

import com.spring.todo.model.entities.RoleEntity;
import lombok.Data;
import lombok.Getter;

@Getter
public class RoleInput extends BaseInput<RoleInput, RoleEntity> {
    private String name;
    private String description;
    private String code;

    @Override
    public RoleEntity toEntity() {
        return null;
    }
}
