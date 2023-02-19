package com.spring.todo.repositories;

import com.spring.todo.model.entities.PasswordResetTokenEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PasswordResetTokenRepository extends BaseRepository<PasswordResetTokenEntity> {
    PasswordResetTokenEntity findByToken(String token);

//    PasswordResetTokenEntity findByUser(User user);
}
