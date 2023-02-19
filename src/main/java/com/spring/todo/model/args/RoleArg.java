package com.spring.todo.model.args;

import com.spring.todo.model.entities.RoleEntity;
import lombok.Getter;

@Getter
public class RoleArg extends BaseArg{
    private String name;
    private String description;
    private String code;
}
