package com.spring.todo.repositories;

import com.spring.todo.model.entities.TaskEntity;
import com.spring.todo.repositories.custom.TaskRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface TaskRepository extends BaseRepository<TaskEntity>, TaskRepositoryCustom {
    @Query(value = "select u from Task u where u.title like :title")
    public Page<TaskEntity> findByTitle(@Param("title") String title, Pageable pageable);

    @Query(value = "select u from Task u join u.assigner r where r.id = :assigner")
    public Page<TaskEntity> findTaskByAssigner(@Param("assigner") String assigner, Pageable pageable);

    @Query(value = "select u from Task u join u.assignee r where r.id = :assignee")
    public Page<TaskEntity> findTaskByAssignee(@Param("assignee") String assignee, Pageable pageable);

    @Query(value = "select u from Task u join u.group r where r.id = :group")
    public Page<TaskEntity> findTaskByGroup(@Param("group") String group, Pageable pageable);
}
