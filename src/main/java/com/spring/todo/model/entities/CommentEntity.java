package com.spring.todo.model.entities;

import com.spring.todo.model.response.CommentResponse;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity(name = "Comment")
public class CommentEntity extends BaseEntity<CommentEntity, CommentResponse> {
    private String title;
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private UserEntity owner;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    private TaskEntity task;

    @Override
    public CommentResponse toReponse() {
        return super.mapToResponse(this, new CommentResponse());
    }
}
