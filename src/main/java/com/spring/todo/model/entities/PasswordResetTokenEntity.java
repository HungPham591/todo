package com.spring.todo.model.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;

@Data
@Entity(name = "PasswordResetToken")
public class PasswordResetTokenEntity extends BaseEntity {
    private static final int EXPIRATION = 60 * 24;

    private String token;

    @OneToOne(targetEntity = AccountEntity.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "account")
    private AccountEntity account;

    private Date expiryDate;

    @Override
    public Object toReponse() {
        return null;
    }
}
