package com.spring.todo.model.response;

import lombok.Data;

@Data
public class TaskResponse extends BaseResponse {
    private String title;
    private String content;
    private String img;
    private UserResponse assigner;
    private UserResponse assignee;
    private GroupResponse group;
    private boolean done;
}
