package com.spring.todo.repositories;

import com.spring.todo.model.entities.CommentEntity;
import com.spring.todo.repositories.custom.CommentRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CommentRepository extends BaseRepository<CommentEntity>, CommentRepositoryCustom {
    @Query("select c from Comment c where c.task = :task")
    public Page<CommentEntity> findByTask(@Param("task") String task, Pageable pageable);
}
