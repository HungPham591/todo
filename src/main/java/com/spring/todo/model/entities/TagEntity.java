package com.spring.todo.model.entities;

import com.spring.todo.model.response.TagResponse;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "Tag")
public class TagEntity extends BaseEntity<TagEntity, TagResponse> {
    private String name;
    private String icon;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private UserEntity owner;
    @OneToMany(mappedBy = "tag", fetch = FetchType.LAZY)
    private List<TaskEntity> tasks;

    @Override
    public TagResponse toReponse() {
        return super.mapToResponse(this, new TagResponse());
    }
}
