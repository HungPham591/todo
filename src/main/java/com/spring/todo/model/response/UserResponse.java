package com.spring.todo.model.response;

import com.spring.todo.common.enums.Gender;
import com.spring.todo.model.entities.GroupEntity;
import lombok.Data;

import java.util.Set;

@Data
public class UserResponse extends BaseResponse {
    private String name;
    private int birthday;
    private String avatar;
    private String bio;
    private boolean status;
    private Gender gender;
    private Set<GroupResponse> groupsHas;
    private Set<GroupEntity> groupsJoin;
    private Set<TaskResponse> tasksJoin;
    private Set<TaskResponse> tasksHas;
}
