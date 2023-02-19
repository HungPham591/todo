package com.spring.todo.repositories;

import com.spring.todo.model.entities.VerificationTokenEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface VerificationTokenRepository extends BaseRepository<VerificationTokenEntity> {
//    VerificationTokenEntity findByToken(String token);
//
//    VerificationTokenEntity findByUser(User user);
}
