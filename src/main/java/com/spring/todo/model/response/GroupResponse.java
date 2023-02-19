package com.spring.todo.model.response;

import lombok.Data;

import java.util.Set;

@Data
public class GroupResponse extends BaseResponse {
    private String name;
    private String bio;
    private Set<UserResponse> members;
    private UserResponse owner;
    private Set<TaskResponse> tasks;
}
