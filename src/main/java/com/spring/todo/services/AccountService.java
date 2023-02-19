package com.spring.todo.services;

import com.spring.todo.model.response.AccountResponse;
import com.spring.todo.model.entities.AccountEntity;
import com.spring.todo.model.inputs.AccountInput;
import com.spring.todo.repositories.AccountRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AccountService extends BaseService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ModelMapper modelMapper;

    public void createNewAccount() throws Exception {
    }


    public void confirmRegistration(String token) throws Exception {

    }

    public AccountInput getAccountByFilter(Map<String, Object> filter) throws Exception {
        return null;
    }

    public boolean checkIfValidOldPassword(AccountInput accountInput, String oldPassword) throws Exception {
        return false;
    }

    public void changeUserPassword(AccountInput accountInput, String password) throws Exception {

    }

    public AccountInput registerNewUserAccount(AccountResponse accountResponse) throws Exception {
        AccountEntity accountEntity = modelMapper.map(accountResponse, AccountEntity.class);
        AccountEntity result = accountRepository.save(accountEntity);
        return modelMapper.map(result, AccountInput.class);
    }
}
