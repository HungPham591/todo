package com.spring.todo.model.entities;

import com.spring.todo.model.response.UserRelationshipResponse;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity(name = "UserRelationship")
public class UserRelationshipEntity extends BaseEntity<UserRelationshipEntity, UserRelationshipResponse> {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dst")
    private UserEntity dst;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "target")
    private UserEntity target;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type")
    private TypeRelationshipEntity type;

    @Override
    public UserRelationshipResponse toReponse() {
        return super.mapToResponse(this, new UserRelationshipResponse());
    }
}
