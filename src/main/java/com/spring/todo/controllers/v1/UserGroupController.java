package com.spring.todo.controllers.v1;

import com.spring.todo.controllers.BaseController;
import com.spring.todo.model.entities.UserGroupEntity;
import com.spring.todo.model.inputs.UserGroupInput;
import com.spring.todo.model.response.UserGroupResponse;
import com.spring.todo.services.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/userGroup", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserGroupController extends BaseController<UserGroupEntity, UserGroupResponse> {

    @Autowired
    private UserGroupService userGroupService;

    @GetMapping("/myRole")
    public ResponseEntity<UserGroupResponse> getMyRole(
            Authentication authentication,
            @RequestParam String group) throws Exception {
        UserGroupEntity userGroupEntity = userGroupService.getMyRole(authentication.getName(), group);
        return success(userGroupEntity);
    }

    @GetMapping("/requestGroups")
    public ResponseEntity<List<UserGroupResponse>> getRequestGroups(
            Authentication authentication,
            @RequestParam("name") String name,
            @RequestParam("sort") String sort,
            @RequestParam("skip") Integer skip,
            @RequestParam("limit") Integer limit) throws Exception {
        List<UserGroupEntity> userGroupEntities = userGroupService.getRequestGroups(authentication.getName(), name, sort, skip, limit);
        return success(userGroupEntities);
    }

    @GetMapping("/invitedGroups")
    public ResponseEntity<List<UserGroupResponse>> getInvitedGroups(
            Authentication authentication,
            @RequestParam("name") String name,
            @RequestParam("sort") String sort,
            @RequestParam("skip") Integer skip,
            @RequestParam("limit") Integer limit) throws Exception {
        List<UserGroupEntity> userGroupEntities = userGroupService.getInvitedGroups(authentication.getName(), name, sort, skip, limit);
        return success(userGroupEntities);
    }

    @PutMapping("/memberRole")
    public ResponseEntity<UserGroupResponse> setRole(Authentication authentication, @RequestBody UserGroupInput input) throws Exception {
        UserGroupEntity userGroupEntity = userGroupService.setRole(authentication.getName(), input);
        return success(userGroupEntity);
    }

    @PostMapping("/joinGroup")
    public ResponseEntity<UserGroupResponse> joinGroup(Authentication authentication, @RequestBody UserGroupInput input) throws Exception {
        UserGroupEntity userGroupEntity = userGroupService.joinGroup(authentication.getName(), input);
        return success(userGroupEntity);
    }

    @PostMapping("/acceptJoin")
    public ResponseEntity<UserGroupResponse> acceptJoin(Authentication authentication, @RequestBody UserGroupInput input) throws Exception {
        UserGroupEntity userGroupEntity = userGroupService.acceptJoin(authentication.getName(), input);
        return success(userGroupEntity);
    }

    @PostMapping("/rejectJoin")
    public ResponseEntity<UserGroupResponse> rejectJoin(Authentication authentication, @RequestBody UserGroupInput input) throws Exception {
        UserGroupEntity userGroupEntity = userGroupService.rejectJoin(authentication.getName(), input);
        return success(userGroupEntity);
    }

    @PostMapping("/inviteGroup")
    public ResponseEntity<UserGroupResponse> inviteGroup(Authentication authentication, @RequestBody UserGroupInput input) throws Exception {
        UserGroupEntity userGroupEntity = userGroupService.inviteGroup(authentication.getName(), input);
        return success(userGroupEntity);
    }

    @PostMapping("/acceptInvite")
    public ResponseEntity<UserGroupResponse> acceptInvite(Authentication authentication, @RequestBody UserGroupInput input) throws Exception {
        UserGroupEntity userGroupEntity = userGroupService.acceptInvite(authentication.getName(), input);
        return success(userGroupEntity);
    }

    @PostMapping("/rejectInvite")
    public ResponseEntity<UserGroupResponse> rejectInvite(Authentication authentication, @RequestBody UserGroupInput input) throws Exception {
        UserGroupEntity userGroupEntity = userGroupService.rejectInvite(authentication.getName(), input);
        return success(userGroupEntity);
    }
}
