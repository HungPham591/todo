package com.spring.todo.model.entities;

import com.spring.todo.model.response.GenderResponse;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity(name = "Gender")
public class GenderEntity extends BaseEntity<GenderEntity, GenderResponse> {
    private String code;
    private String name;
    @Override
    public GenderResponse toReponse() {
        return null;
    }
}
