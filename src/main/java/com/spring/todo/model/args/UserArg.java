package com.spring.todo.model.args;

import com.spring.todo.common.enums.Gender;
import com.spring.todo.model.entities.UserEntity;
import lombok.Getter;

@Getter
public class UserArg extends BaseArg{
    private String name;
    private int birthday;
    private String avatar;
    private String bio;
    private boolean status;
    private Gender gender;
}
