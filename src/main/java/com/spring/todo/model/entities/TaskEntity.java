package com.spring.todo.model.entities;

import com.spring.todo.model.response.TaskResponse;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity(name = "Task")
public class TaskEntity extends BaseEntity<TaskEntity, TaskResponse> {
    @Size(max = 200)
    @NotBlank
    private String title;
    @Size(max = 2000)
    @NotBlank
    private String content;
    @NotBlank
    private String img;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assigner")
    private UserEntity assigner;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignee")
    private UserEntity assignee;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group")
    private GroupEntity group;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag")
    private TagEntity tag;
    @NotNull
    private String state;

    @Override
    public TaskResponse toReponse() {
        return super.mapToResponse(this, new TaskResponse());
    }
}
