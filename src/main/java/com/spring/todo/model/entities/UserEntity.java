package com.spring.todo.model.entities;

import com.spring.todo.common.enums.Gender;
import com.spring.todo.model.response.UserResponse;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity(name = "User")
public class UserEntity extends ProfileEntity<UserEntity, UserResponse> {
    @Size(max = 50)
    @NotBlank
    private String name;
    @NotNull
    private int birthday;
    @NotBlank
    private String avatar;
    @Size(max = 200)
    @NotBlank
    private String bio;
    @NotNull
    private String status;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @OneToOne(mappedBy = "profile", fetch = FetchType.LAZY)
    private AccountEntity account;
    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
    private List<GroupEntity> groupsHas;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "User_Group",
            joinColumns = {@JoinColumn(name = "member_id")},
            inverseJoinColumns = {@JoinColumn(name = "group_id")}
    )
    private List<GroupEntity> groupsJoin;
    @OneToMany(mappedBy = "assignee", fetch = FetchType.LAZY)
    private List<TaskEntity> tasksJoin;
    @OneToMany(mappedBy = "assigner", fetch = FetchType.LAZY)
    private List<TaskEntity> tasksHas;
    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
    private List<TagEntity> tags;
    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
    private List<CommentEntity> comments;

    @Override
    public UserResponse toReponse() {
        return super.mapToResponse(this, new UserResponse());
    }
}
