package com.spring.todo.model.entities;

import com.spring.todo.model.response.UserGroupResponse;
import com.spring.todo.model.response.UserResponse;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity(name = "UserGroup")
public class UserGroupEntity extends BaseEntity<UserGroupEntity, UserGroupResponse> {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private RoleEntity role;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private GroupEntity group;
    @Override
    public UserGroupResponse toReponse() {
        return null;
    }
}
