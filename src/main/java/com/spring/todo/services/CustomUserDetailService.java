package com.spring.todo.services;

import com.spring.todo.model.entities.AccountEntity;
import com.spring.todo.model.entities.CustomUserDetailEntity;
import com.spring.todo.repositories.AccountRepository;
import com.spring.todo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //username la id cua account
        AccountEntity account = accountRepository.getById(username);
        if (account == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetailEntity(account);
    }
}
