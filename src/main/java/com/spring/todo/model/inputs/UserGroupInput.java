package com.spring.todo.model.inputs;

import com.spring.todo.model.entities.UserGroupEntity;
import lombok.Data;
import lombok.Getter;

@Getter
public class UserGroupInput extends BaseInput<UserGroupInput, UserGroupEntity> {
    @Override
    public Object toEntity() {
        return null;
    }
}
