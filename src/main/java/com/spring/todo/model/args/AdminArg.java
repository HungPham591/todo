package com.spring.todo.model.args;

import com.spring.todo.model.entities.AdminEntity;
import lombok.Getter;

@Getter
public class AdminArg extends BaseArg{
    private String email;
    private String password;

}
