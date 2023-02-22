package com.spring.todo.services;

import com.spring.todo.model.entities.GroupEntity;
import com.spring.todo.model.inputs.GroupInput;
import com.spring.todo.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GroupService extends BaseService {

    @Autowired
    private GroupRepository groupRepository;

    public GroupEntity getGroup(String id) {
        Optional<GroupEntity> groupEntity = groupRepository.findById(id);
        return groupEntity.get();
    }

    public List<GroupEntity> getMyGroups(String user, String name, String sort, Integer skip, Integer limit) {
        Pageable page = PageRequest.of(skip, limit, Sort.by(sort));
        Page<GroupEntity> listGroup = groupRepository.findGroupByOwner(user, name, page);
        return listGroup.get().collect(Collectors.toList());
    }

    public GroupEntity createGroup(String user, GroupInput groupInput) {
        GroupEntity groupEntity = groupRepository.save(groupInput.toEntity());
        return groupEntity;
    }

    public GroupEntity updateGroup(String user, String id, GroupInput groupInput) {
        GroupEntity groupEntity = groupInput.toEntity();
        groupEntity.setId(id);
        groupEntity = groupRepository.save(groupEntity);
        return groupEntity;
    }

    public GroupEntity deleteGroup(String user, String id) {
        groupRepository.deleteById(id);
        GroupEntity groupEntity = new GroupEntity();
        groupEntity.setId(id);
        return groupEntity;
    }
}
