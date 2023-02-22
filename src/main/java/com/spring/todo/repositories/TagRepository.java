package com.spring.todo.repositories;

import com.spring.todo.model.entities.TagEntity;
import com.spring.todo.repositories.custom.TagRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface TagRepository extends BaseRepository<TagEntity>, TagRepositoryCustom {
    @Query(value = "select t from Tag t where t.name like :name")
    public List<TagEntity> findAllByName(@Param("name") String name);

    @Query(value = "select t from Tag t where t.name like :name and t.owner = :owner")
    public List<TagEntity> findAllByOwner(@Param("name") String name, @Param("owner") String owner);
}
