package com.spring.todo.controllers.v1;

import com.spring.todo.controllers.BaseController;
import com.spring.todo.model.response.GroupResponse;
import com.spring.todo.model.inputs.GroupInput;
import com.spring.todo.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/group", produces = MediaType.APPLICATION_JSON_VALUE)
public class GroupController extends BaseController {
    @Autowired
    private GroupService groupService;

    @GetMapping("/group")
    public ResponseEntity<GroupResponse> getGroup(@RequestParam("id") String id) {
        return null;
    }

    @GetMapping("/myGroups")
    public ResponseEntity<List<GroupResponse>> getMyGroups(
            Authentication authentication,
            @RequestParam("name") String name,
            @RequestParam("sort") String sort,
            @RequestParam("skip") Integer skip,
            @RequestParam("limit") Integer limit) {
        return null;
    }

    @GetMapping("/requestGroups")
    public ResponseEntity<List<GroupResponse>> getRequestGroups(
            Authentication authentication,
            @RequestParam("name") String name,
            @RequestParam("skip") Integer skip,
            @RequestParam("limit") Integer limit) {
        return null;
    }

    @GetMapping("/recievedGroups")
    public ResponseEntity<List<GroupResponse>> getReceivedGroups(
            Authentication authentication,
            @RequestParam("name") String name,
            @RequestParam("skip") Integer skip,
            @RequestParam("limit") Integer limit) {
        return null;
    }

    @GetMapping("/suggestGroup")
    public ResponseEntity<List<GroupResponse>> getSuggestGroup(
            Authentication authentication,
            @RequestParam("name") String name,
            @RequestParam("skip") Integer skip,
            @RequestParam("limit") Integer limit
            ) {
        return null;
    }

    @PostMapping("/")
    public ResponseEntity<GroupResponse> createGroup(@RequestBody GroupInput groupInput) {
        return null;
    }

    @PutMapping("/")
    public ResponseEntity<GroupResponse> updateGroup(@RequestParam("id") String id, @RequestBody GroupInput groupInput) {
        return null;
    }

    @DeleteMapping("/")
    public ResponseEntity<GroupResponse> deleteGroup(@RequestParam("id") String id) {
        return null;
    }

    @PostMapping("/joinGroup")
    public ResponseEntity<GroupResponse> joinGroup(Authentication authentication, @RequestBody Object body) {
        return null;
    }

    @PostMapping("/acceptJoin")
    public ResponseEntity<GroupResponse> acceptJoin(Authentication authentication, @RequestBody Object body) {
        return null;
    }

    @PostMapping("/rejectJoin")
    public ResponseEntity<GroupResponse> rejectJoin(Authentication authentication, @RequestBody Object body) {
        return null;
    }

    @PostMapping("/inviteGroup")
    public ResponseEntity<GroupResponse> inviteGroup(Authentication authentication, @RequestBody Object body) {
        return null;
    }

    @PostMapping("/acceptInvite")
    public ResponseEntity<GroupResponse> acceptInvite(Authentication authentication, @RequestBody Object body) {
        return null;
    }

    @PostMapping("/rejectInvite")
    public ResponseEntity<GroupResponse> rejectInvite(Authentication authentication, @RequestBody Object body) {
        return null;
    }

}
