package com.spring.todo.model.inputs;

import com.spring.todo.model.entities.TagEntity;
import lombok.Getter;

@Getter
public class TagInput extends BaseInput<TagInput, TagEntity> {
    @Override
    public TagEntity toEntity() {
        return null;
    }
}
