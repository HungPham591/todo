package com.spring.todo.model.inputs;

import com.spring.todo.model.entities.GenderEntity;

public class GenderInput extends BaseInput<GenderInput, GenderEntity> {
    private String code;
    private String name;

    @Override
    public Object toEntity() {
        return null;
    }
}
