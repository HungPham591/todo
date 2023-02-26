package com.spring.todo.model.inputs;

import com.spring.todo.model.entities.TypeRelationshipEntity;
import lombok.Data;
import lombok.Getter;

@Getter
public class TypeRelationshipInput extends BaseInput<TypeRelationshipInput, TypeRelationshipEntity> {
    @Override
    public TypeRelationshipEntity toEntity() {
        return null;
    }
}
