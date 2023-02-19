package com.spring.todo.model.entities;

import com.spring.todo.model.response.UserResponse;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity(name = "UserGroup")
public class UserGroupEntity extends BaseEntity<UserGroupEntity, UserResponse> {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role")
    private RoleEntity role;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user")
    private UserEntity user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group")
    private GroupEntity group;
    @Override
    public Object toReponse() {
        return null;
    }
}
