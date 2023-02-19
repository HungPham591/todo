package com.spring.todo.model.entities;

import com.spring.todo.model.response.AccountResponse;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Entity(name = "Account")
public class AccountEntity extends BaseEntity<AccountEntity, AccountResponse> {
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "profile", referencedColumnName = "id")
    private ProfileEntity profile;
    @OneToOne(mappedBy = "account", fetch = FetchType.LAZY)
    private VerificationTokenEntity verificationToken;
    @OneToOne(mappedBy = "account", fetch = FetchType.LAZY)
    private PasswordResetTokenEntity passwordResetTokenEntity;
    //khi nguoi dung xac nhan tai khoan
    private boolean enabled;
    private String role;

    @Override
    public AccountResponse toReponse() {
        return super.mapToResponse(this, new AccountResponse());
    }
}
