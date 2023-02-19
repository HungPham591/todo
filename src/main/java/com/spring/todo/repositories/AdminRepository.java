package com.spring.todo.repositories;

import com.spring.todo.model.entities.AdminEntity;
import com.spring.todo.repositories.custom.AdminRepositoryCustom;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public interface AdminRepository extends BaseRepository<AdminEntity>, AdminRepositoryCustom {
    public List<AdminEntity> findByEmail(String email);

}
