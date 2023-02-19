package com.spring.todo.repositories;

import com.spring.todo.model.entities.CommentEntity;
import com.spring.todo.repositories.custom.CommentRepositoryCustom;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CommentRepository extends BaseRepository<CommentEntity>, CommentRepositoryCustom {
}
