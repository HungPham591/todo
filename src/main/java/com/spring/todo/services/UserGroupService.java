package com.spring.todo.services;

import com.spring.todo.model.entities.RoleEntity;
import com.spring.todo.model.entities.UserGroupEntity;
import com.spring.todo.model.inputs.UserGroupInput;
import com.spring.todo.model.response.UserGroupResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class UserGroupService extends BaseService {

    public UserGroupEntity getMyRole(String user, String group) throws Exception {
        return null;
    }

    public RoleEntity setRole() throws Exception {
        return null;
    }

    public List<UserGroupEntity> getRequestGroups(String user, String name, String sort, Integer skip, Integer limit) throws Exception {
        return null;
    }

    public List<UserGroupEntity> getInvitedGroups(String user, String name, String sort, Integer skip, Integer limit) throws Exception {
        return null;
    }

    public UserGroupEntity setRole(String user, UserGroupInput input) throws Exception {
        return null;
    }

    public UserGroupEntity joinGroup(String user, UserGroupInput input) throws Exception {
        return null;
    }

    public UserGroupEntity acceptJoin(String user, UserGroupInput input) throws Exception {
        return null;
    }

    public UserGroupEntity rejectJoin(String user, UserGroupInput input) throws Exception {
        return null;
    }

    public UserGroupEntity inviteGroup(String user, UserGroupInput input) throws Exception {
        return null;
    }

    public UserGroupEntity acceptInvite(String user, UserGroupInput input) throws Exception {
        return null;
    }

    public UserGroupEntity rejectInvite(String user, UserGroupInput input) throws Exception {
        return null;
    }
}
