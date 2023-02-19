package com.spring.todo.model.inputs;

import com.spring.todo.model.entities.UserRelationshipEntity;
import lombok.Getter;

@Getter
public class UserRelationshipInput extends BaseInput<UserRelationshipInput, UserRelationshipEntity> {
    @Override
    public Object toEntity() {
        return null;
    }
}
