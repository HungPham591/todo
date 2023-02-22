package com.spring.todo.controllers.v1;

import com.spring.todo.controllers.BaseController;
import com.spring.todo.model.entities.GroupEntity;
import com.spring.todo.model.inputs.GroupInput;
import com.spring.todo.model.response.GroupResponse;
import com.spring.todo.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/group", produces = MediaType.APPLICATION_JSON_VALUE)
public class GroupController extends BaseController<GroupEntity, GroupResponse> {
    @Autowired
    private GroupService groupService;

    @GetMapping("/group")
    public ResponseEntity<GroupResponse> getGroup(@RequestParam("id") String id) throws Exception {
        GroupEntity groupEntity = groupService.getGroup(id);
        return success(groupEntity);
    }

    @GetMapping("/myGroups")
    public ResponseEntity<List<GroupResponse>> getMyGroups(
            Authentication authentication,
            @RequestParam("name") String name,
            @RequestParam("sort") String sort,
            @RequestParam("skip") Integer skip,
            @RequestParam("limit") Integer limit) throws Exception {
        List<GroupEntity> groupEntityList = groupService.getMyGroups(authentication.getName(), name, sort, skip, limit);
        return success(groupEntityList);
    }

//    @GetMapping("/suggestGroup")
//    public ResponseEntity<List<GroupResponse>> getSuggestGroup(
//            Authentication authentication,
//            @RequestParam("name") String name,
//            @RequestParam("sort") String sort,
//            @RequestParam("skip") Integer skip,
//            @RequestParam("limit") Integer limit
//    ) {
//        List<GroupEntity> groupEntities = groupService.getSuggestGroup(authentication, name, sort, skip, limit);
//        return success(groupEntities);
//    }

    @PostMapping("/")
    public ResponseEntity<GroupResponse> createGroup(Authentication authentication, @RequestBody GroupInput groupInput) throws Exception {
        GroupEntity groupEntity = groupService.createGroup(authentication.getName(), groupInput);
        return success(groupEntity);
    }

    @PutMapping("/")
    public ResponseEntity<GroupResponse> updateGroup(Authentication authentication, @RequestParam("id") String id, @RequestBody GroupInput groupInput) throws Exception {
        GroupEntity groupEntity = groupService.updateGroup(authentication.getName(), id, groupInput);
        return success(groupEntity);
    }

    @DeleteMapping("/")
    public ResponseEntity<GroupResponse> deleteGroup(Authentication authentication, @RequestParam("id") String id) throws Exception {
        GroupEntity groupEntity = groupService.deleteGroup(authentication.getName(), id);
        return success(groupEntity);
    }

}
