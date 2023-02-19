package com.spring.todo.model.args;

import com.spring.todo.model.entities.BaseEntity;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.io.Serializable;

@Getter
public abstract class BaseArg implements Serializable {
    private String id;

    private ModelMapper initModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }
}
