package com.spring.todo.repositories;

import com.spring.todo.model.entities.UserEntity;
import com.spring.todo.repositories.custom.UserRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface UserRepository extends BaseRepository<UserEntity>, UserRepositoryCustom {
    @Query(value = "select u from User u where u.name = :name")
    public Page<UserEntity> findUserByName(@Param("name") String name, Pageable pageable);

    @Query(value = "select u from User u where u.birthday >= :start and u.birthday <= :end")
    public Page<UserEntity> findUserByBirthday(@Param("start") int start, @Param("end") int end, Pageable pageable);

    @Query(value = "select u from User u where u.gender = :gender")
    public Page<UserEntity> findUserByGender(@Param("gender") String gender, Pageable pageable);
}
