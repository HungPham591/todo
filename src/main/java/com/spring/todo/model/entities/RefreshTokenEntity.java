package com.spring.todo.model.entities;

import com.spring.todo.model.response.BaseResponse;
import lombok.Data;

import javax.persistence.Entity;
import java.util.Date;

@Data
@Entity(name = "RefreshToken")
public class RefreshTokenEntity extends BaseEntity {
    private String token;
    private Date expired;
    @Override
    public BaseResponse toReponse() {
        return null;
    }
}
