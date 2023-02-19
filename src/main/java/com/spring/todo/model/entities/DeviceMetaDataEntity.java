package com.spring.todo.model.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "DeviceMetaData")
public class DeviceMetaDataEntity extends BaseEntity {
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "account",referencedColumnName = "id")
    private AccountEntity account;
    private String deviceDetails;
    private String location;
    private Date lastLoggedIn;

    @Override
    public Object toReponse() {
        return null;
    }
}
