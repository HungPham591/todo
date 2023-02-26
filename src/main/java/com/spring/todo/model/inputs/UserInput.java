package com.spring.todo.model.inputs;

import com.spring.todo.common.enums.Gender;
import com.spring.todo.model.entities.UserEntity;
import lombok.Data;
import lombok.Getter;

@Getter
public class UserInput extends BaseInput<UserInput, UserEntity> {
    private String name;
    private int birthday;
    private String avatar;
    private String bio;
    private boolean status;
    private Gender gender;

    @Override
    public Object toEntity() {
        return null;
    }
}
