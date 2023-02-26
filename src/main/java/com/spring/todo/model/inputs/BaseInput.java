package com.spring.todo.model.inputs;

import com.spring.todo.model.entities.BaseEntity;
import lombok.Data;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.io.Serializable;

@Data
public abstract class BaseInput<M extends BaseInput, E extends BaseEntity> implements Serializable {
    private String id;

    private ModelMapper initModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

    public abstract Object toEntity();

    protected E mapToEntity(M model, E entity) {
        ModelMapper modelMapper = initModelMapper();
        modelMapper.map(model, entity);
        return entity;
    }
}
