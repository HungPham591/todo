package com.spring.todo.model.entities;

import lombok.Data;

import javax.persistence.Entity;
import java.util.Date;

@Data
@Entity(name = "RefreshToken")
public class RefreshTokenEntity extends BaseEntity {
    private String token;
    private Date expired;
    @Override
    public Object toReponse() {
        return null;
    }
}
