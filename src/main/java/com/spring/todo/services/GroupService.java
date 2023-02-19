package com.spring.todo.services;

import com.spring.todo.model.response.GroupResponse;
import com.spring.todo.model.response.UserGroupResponse;
import com.spring.todo.model.inputs.GroupInput;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GroupService extends BaseService {

    public ResponseEntity<GroupResponse> getGroup(String id) {
        return null;
    }

    public ResponseEntity<List<GroupResponse>> getMyGroups(Authentication authentication, String name, String sort, Integer skip, Integer limit) {
        return null;
    }

    public ResponseEntity<List<GroupResponse>> getRequestGroups(Authentication authentication, String name, Integer skip, Integer limit) {
        return null;
    }

    public ResponseEntity<List<GroupResponse>> getReceivedGroups(Authentication authentication, String name, Integer skip, Integer limit) {
        return null;
    }

    public ResponseEntity<List<GroupResponse>> getSuggestGroup(Authentication authentication, String name, Integer skip, Integer limit) {
        return null;
    }

    public ResponseEntity<GroupResponse> createGroup(GroupInput groupInput) {
        return null;
    }

    public ResponseEntity<GroupResponse> updateGroup(String id, GroupInput groupInput) {
        return null;
    }

    public ResponseEntity<GroupResponse> deleteGroup(String id) {
        return null;
    }

    public ResponseEntity<UserGroupResponse> joinGroup(Authentication authentication, Map<String, Object> body) {
        return null;
    }

    public ResponseEntity<UserGroupResponse> acceptJoin(Authentication authentication, Map<String, Object> body) {
        return null;
    }

    public ResponseEntity<UserGroupResponse> rejectJoin(Authentication authentication, Map<String, Object> body) {
        return null;
    }

    public ResponseEntity<UserGroupResponse> inviteGroup(Authentication authentication, Map<String, Object> body) {
        return null;
    }

    public ResponseEntity<UserGroupResponse> acceptInvite(Authentication authentication, Map<String, Object> body) {
        return null;
    }

    public ResponseEntity<UserGroupResponse> rejectInvite(Authentication authentication, Map<String, Object> body) {
        return null;
    }
}
