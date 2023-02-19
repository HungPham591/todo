package com.spring.todo.repositories;

import com.spring.todo.model.entities.AccountEntity;
import com.spring.todo.repositories.custom.AccountRepositoryCustom;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface AccountRepository extends BaseRepository<AccountEntity>, AccountRepositoryCustom {
    public List<AccountEntity> findByEmail(String email);
}
