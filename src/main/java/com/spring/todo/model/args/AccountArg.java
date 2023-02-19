package com.spring.todo.model.args;

import com.spring.todo.model.entities.AccountEntity;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
public class AccountArg extends BaseArg{
    @NotEmpty(message = "auth missing email")
    @Email(message = "email invalid")
    private String email;
    @NotEmpty(message = "auth missing password")
    private String password;
    private String matchingPassword;

}
