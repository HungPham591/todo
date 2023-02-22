package com.spring.todo.model.entities;

import com.spring.todo.model.response.BaseResponse;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

@Data
@Entity(name = "VerificationToken")
public class VerificationTokenEntity extends BaseEntity {
    private String token;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account",referencedColumnName = "id")
    private AccountEntity account;

    private Date expiryDate;

    private Date calculateExpiryDate(int expiryTimeInMinutes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Timestamp(cal.getTime().getTime()));
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }

    @Override
    public BaseResponse toReponse() {
        return null;
    }
}
