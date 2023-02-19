package com.spring.todo.model.entities;

import com.spring.todo.model.response.TypeRelationshipResponse;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Collection;

@Data
@Entity(name = "TypeRelationship")
public class TypeRelationshipEntity extends BaseEntity<TypeRelationshipEntity, TypeRelationshipResponse> {
    private String name;
    private String code;
    @OneToMany(mappedBy = "type",fetch = FetchType.LAZY)
    private Collection<UserRelationshipEntity> userRelationships;

    @Override
    public TypeRelationshipResponse toReponse() {
        return super.mapToResponse(this, new TypeRelationshipResponse());
    }
}
