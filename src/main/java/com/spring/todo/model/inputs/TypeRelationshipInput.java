package com.spring.todo.model.inputs;

import com.spring.todo.model.entities.TypeRelationshipEntity;
import lombok.Getter;

@Getter
public class TypeRelationshipInput extends BaseInput<TypeRelationshipInput, TypeRelationshipEntity> {
    @Override
    public Object toEntity() {
        return null;
    }
}
