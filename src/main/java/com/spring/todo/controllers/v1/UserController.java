package com.spring.todo.controllers.v1;

import com.spring.todo.controllers.BaseController;
import com.spring.todo.model.response.UserResponse;
import com.spring.todo.model.inputs.UserInput;
import com.spring.todo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @GetMapping("/info")
    public ResponseEntity<UserResponse> getInfo(Authentication authentication) {
        return null;
    }

    @GetMapping("/user")
    public ResponseEntity<UserResponse> getUser(@RequestParam("id") String id) {
        return null;
    }

    @GetMapping("/suggestUsers")
    public ResponseEntity<UserResponse> getSuggestUser(
            @RequestParam("name") String name,
            @RequestParam("skip") Integer skip,
            @RequestParam("limit") Integer limit) {
        return null;
    }

    @GetMapping("/myContacts")
    public ResponseEntity<UserResponse> getMyContacts(
            @RequestParam("name") String name,
            @RequestParam("skip") Integer skip,
            @RequestParam("limit") Integer limit) {
        return null;
    }

    @GetMapping("/requestUser")
    public ResponseEntity<UserResponse> getRequestUser(
            @RequestParam("name") String name,
            @RequestParam("skip") Integer skip,
            @RequestParam("limit") Integer limit) {
        return null;
    }

    @PutMapping("/")
    public ResponseEntity<UserResponse> updateUser(
            @RequestParam("id") String id,
            @RequestBody UserInput userInput) {
        return null;
    }

    @PutMapping("/password")
    public ResponseEntity<UserResponse> updatePassword(
            Authentication authentication,
            @RequestParam("password") String password,
            @RequestParam("oldpassword") String oldPassword
    ) {
        return null;
    }

    @DeleteMapping("/")
    public ResponseEntity<UserResponse> deleteUser(@RequestParam("id") String id) {
        return null;
    }
}
