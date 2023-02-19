package com.spring.todo.model.inputs;

import com.spring.todo.model.entities.CommentEntity;
import lombok.Getter;

@Getter
public class CommentInput extends BaseInput<CommentInput, CommentEntity> {
    @Override
    public Object toEntity() {
        return null;
    }
}
