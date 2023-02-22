package com.spring.todo.repositories;

import com.spring.todo.model.entities.GroupEntity;
import com.spring.todo.repositories.custom.GroupRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Repository
@Transactional
public interface GroupRepository extends BaseRepository<GroupEntity>, GroupRepositoryCustom {
    @Query(value = "select u from GroupTask u where u.name = :name")
    public Page<GroupEntity> findByName(@Param("name") String name, Pageable pageable);

    @Query(value = "select u from GroupTask u join u.owner r where r.id = :owner and r.name = :name")
    public Page<GroupEntity> findGroupByOwner(@Param("owner") String owner, @Param("name") String name, Pageable pageable);

    @Query(value = "select u from GroupTask u join u.members r where r.id = :member")
    public Page<GroupEntity> findGroupByMember(@Param("member") String member, Pageable pageable);

    @Query(value = "select u from GroupTask u join u.owner r where r.id in :owners")
    public Page<GroupEntity> findGroupByOwners(@Param("owners") Set<String> owners, Pageable pageable);

    @Query(value = "select u from GroupTask u join u.members r where r.id in :members")
    public Page<GroupEntity> findGroupByMembers(@Param("members") Set<String> members, Pageable pageable);
}
