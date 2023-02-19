package com.spring.todo.model.entities;

import com.spring.todo.model.response.RoleResponse;
import lombok.Data;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity(name = "Role")
public class RoleEntity extends BaseEntity<RoleEntity, RoleResponse> {
    @Size(max = 200)
    @NotBlank
    private String name;
    @Size(max = 2000)
    @NotBlank
    private String description;
    @Size(max = 200)
    @NotBlank
    private String code;

    @Override
    public RoleResponse toReponse() {
        return super.mapToResponse(this, new RoleResponse());
    }
}
