package com.spring.todo.model.inputs;

import com.spring.todo.model.entities.GroupEntity;
import lombok.Getter;

@Getter
public class GroupInput extends BaseInput<GroupInput, GroupEntity> {
    private String name;
    private String bio;

    @Override
    public GroupEntity toEntity() {
        return null;
    }
}
