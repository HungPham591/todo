package com.spring.todo.repositories;

import com.spring.todo.model.entities.DeviceMetaDataEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface DeviceMetaDataRepository extends BaseRepository<DeviceMetaDataEntity> {
    List<DeviceMetaDataEntity> findByAccountId(String accountId);
}
