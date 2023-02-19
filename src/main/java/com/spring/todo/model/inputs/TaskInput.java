package com.spring.todo.model.inputs;

import com.spring.todo.model.entities.TaskEntity;
import lombok.Getter;

@Getter
public class TaskInput extends BaseInput<TaskInput, TaskEntity> {
    private String title;
    private String content;
    private String img;
    private String assignee;
    private String group;
    private boolean done;

    @Override
    public Object toEntity() {
        return null;
    }
}
