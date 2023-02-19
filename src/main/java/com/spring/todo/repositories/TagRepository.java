package com.spring.todo.repositories;

import com.spring.todo.model.entities.TagEntity;
import com.spring.todo.repositories.custom.TagRepositoryCustom;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TagRepository extends BaseRepository<TagEntity>, TagRepositoryCustom {
}
