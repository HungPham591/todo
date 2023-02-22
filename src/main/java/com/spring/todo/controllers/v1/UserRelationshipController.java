package com.spring.todo.controllers.v1;

import com.spring.todo.controllers.BaseController;
import com.spring.todo.model.entities.UserRelationshipEntity;
import com.spring.todo.model.inputs.UserRelationshipInput;
import com.spring.todo.model.response.UserRelationshipResponse;
import com.spring.todo.services.UserRelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/userRelationship", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserRelationshipController extends BaseController<UserRelationshipEntity, UserRelationshipResponse> {

    @Autowired
    private UserRelationshipService userRelationshipService;

    @GetMapping("/suggestUsers")
    public ResponseEntity<List<UserRelationshipResponse>> getSuggestUser(
            Authentication authentication,
            @RequestParam("name") String name,
            @RequestParam("skip") Integer skip,
            @RequestParam("limit") Integer limit) throws Exception {
        List<UserRelationshipEntity> userRelationshipEntities = userRelationshipService.getSuggestUser(authentication.getName(), name, skip, limit);
        return success(userRelationshipEntities);
    }

    @GetMapping("/myContacts")
    public ResponseEntity<List<UserRelationshipResponse>> getMyFriends(
            Authentication authentication,
            @RequestParam("name") String name,
            @RequestParam("skip") Integer skip,
            @RequestParam("limit") Integer limit) throws Exception {
        List<UserRelationshipEntity> userRelationshipEntities = userRelationshipService.getMyFriends(authentication.getName(), name, skip, limit);
        return success(userRelationshipEntities);
    }

    @GetMapping("/requestUser")
    public ResponseEntity<List<UserRelationshipResponse>> getRequestUser(
            Authentication authentication,
            @RequestParam("name") String name,
            @RequestParam("skip") Integer skip,
            @RequestParam("limit") Integer limit) throws Exception {
        List<UserRelationshipEntity> userRelationshipEntities = userRelationshipService.getRequestUser(authentication.getName(), name, skip, limit);
        return success(userRelationshipEntities);
    }

    @PostMapping("/friendRequest")
    public ResponseEntity<UserRelationshipResponse> createFriendRequest(Authentication authentication, @RequestBody UserRelationshipInput input) throws Exception {
        UserRelationshipEntity userRelationshipEntity = userRelationshipService.createFriendRequest(authentication.getName(), input);
        return success(userRelationshipEntity);
    }

    @PutMapping("/friendRequestAccept")
    public ResponseEntity<UserRelationshipResponse> updateFriendRequestAccept(
            Authentication authentication,
            @RequestParam("id") String id,
            @RequestBody UserRelationshipInput input) throws Exception {
        UserRelationshipEntity userRelationshipEntity = userRelationshipService.updateFriendRequestAccept(authentication.getName(), input);
        return success(userRelationshipEntity);
    }

    @PutMapping("/friendRequestDecline")
    public ResponseEntity<UserRelationshipResponse> updateFriendRequestDecline(
            Authentication authentication,
            @RequestParam("id") String id,
            @RequestBody UserRelationshipInput input) throws Exception {
        UserRelationshipEntity userRelationshipEntity = userRelationshipService.updateFriendRequestDecline(authentication.getName(), input);
        return success(userRelationshipEntity);
    }

    @DeleteMapping("/friendRequest")
    public ResponseEntity<UserRelationshipResponse> deleteFriendRequest(Authentication authentication, @RequestParam("id") String id) throws Exception {
        UserRelationshipEntity userRelationshipEntity = userRelationshipService.deleteFriendRequest(authentication.getName(), id);
        return success(userRelationshipEntity);
    }

    @PostMapping("/updateSuggestUser")
    public ResponseEntity<List<UserRelationshipResponse>> updateSuggestUser(Authentication authentication, @RequestBody List<UserRelationshipInput> input) throws Exception {
        List<UserRelationshipEntity> userRelationshipEntity = userRelationshipService.updateSuggestUser(authentication.getName(), input);
        return success(userRelationshipEntity);
    }
}
