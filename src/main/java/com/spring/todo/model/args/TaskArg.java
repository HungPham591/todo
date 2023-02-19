package com.spring.todo.model.args;

import com.spring.todo.model.entities.TaskEntity;
import lombok.Getter;

@Getter
public class TaskArg extends BaseArg{
    private String title;
    private String content;
    private String img;
    private String assignee;
    private String group;
    private boolean done;
}
