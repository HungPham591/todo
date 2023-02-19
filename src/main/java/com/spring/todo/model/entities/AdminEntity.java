package com.spring.todo.model.entities;

import com.spring.todo.model.response.AdminResponse;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Entity(name = "Admin")
public class AdminEntity extends ProfileEntity<AdminEntity, AdminResponse> {
    @Email
    private String email;
    @NotBlank
    private String password;
    @OneToOne(mappedBy = "profile", fetch = FetchType.LAZY)
    private AccountEntity account;

    @Override
    public AdminResponse toReponse() {
        return super.mapToResponse(this, new AdminResponse());
    }
}
