package com.spring.todo.services;

import com.spring.todo.model.entities.UserRelationshipEntity;
import com.spring.todo.model.inputs.UserRelationshipInput;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRelationshipService extends BaseService {

    public List<UserRelationshipEntity> getSuggestUser(String user, String name, Integer skip, Integer limit) throws Exception {
        return null;
    }

    public List<UserRelationshipEntity> getMyFriends(String user, String name, Integer skip, Integer limit) throws Exception {
        return null;
    }

    public List<UserRelationshipEntity> getRequestUser(String user, String name, Integer skip, Integer limit) throws Exception {
        return null;
    }

    public UserRelationshipEntity createFriendRequest(String user, UserRelationshipInput input) throws Exception {
        return null;
    }

    public UserRelationshipEntity updateFriendRequestAccept(String user, UserRelationshipInput input) throws Exception {
        return null;
    }

    public UserRelationshipEntity updateFriendRequestDecline(String user, UserRelationshipInput input) throws Exception {
        return null;
    }

    public UserRelationshipEntity deleteFriendRequest(String user, String id) throws Exception {
        return null;
    }

    public List<UserRelationshipEntity> updateSuggestUser(String user, List<UserRelationshipInput> input) throws Exception {
        return null;
    }
}
