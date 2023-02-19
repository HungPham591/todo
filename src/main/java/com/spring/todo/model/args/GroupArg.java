package com.spring.todo.model.args;

import com.spring.todo.model.entities.GroupEntity;
import lombok.Getter;

@Getter
public class GroupArg extends BaseArg {
    private String name;
    private String bio;
}
