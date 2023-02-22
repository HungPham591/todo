package com.spring.todo.repositories;

import com.spring.todo.model.entities.RoleEntity;
import com.spring.todo.repositories.custom.RoleRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface RoleRepository extends BaseRepository<RoleEntity>, RoleRepositoryCustom {

}
