package com.spring.todo.model.entities;

import com.spring.todo.model.response.GroupResponse;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity(name = "GroupTask")
public class GroupEntity extends BaseEntity<GroupEntity, GroupResponse> {
    @Size(max = 200)
    @NotBlank
    private String name;
    @Size(max = 200)
    @NotBlank
    private String bio;

    @ManyToMany(mappedBy = "groupsJoin", fetch = FetchType.LAZY)
    private List<UserEntity> members;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private UserEntity owner;
    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
    private List<TaskEntity> tasks;

    @Override
    public GroupResponse toReponse() {
        return super.mapToResponse(this, new GroupResponse());
    }
}
