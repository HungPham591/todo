package com.spring.todo.repositories;

import com.spring.todo.model.entities.TypeRelationshipEntity;
import com.spring.todo.repositories.custom.TypeRelationshipCustom;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TypeRelationshipRepository extends BaseRepository<TypeRelationshipEntity>, TypeRelationshipCustom {
}
