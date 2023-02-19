package com.spring.todo.repositories;

import com.spring.todo.model.entities.UserRelationshipEntity;
import com.spring.todo.repositories.custom.UserRelationshipCustom;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRelationshipRepository extends BaseRepository<UserRelationshipEntity>, UserRelationshipCustom {
}
