package com.spring.todo.controllers.v1;

import com.spring.todo.controllers.BaseController;
import com.spring.todo.model.entities.UserEntity;
import com.spring.todo.model.inputs.UserInput;
import com.spring.todo.model.response.UserResponse;
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
    public ResponseEntity<UserResponse> getInfo(Authentication authentication) throws Exception {
        UserEntity userEntity = userService.getInfo(authentication);
        return success(userEntity);
    }

    @GetMapping("/user")
    public ResponseEntity<UserResponse> getUser(@RequestParam("id") String id) throws Exception {
        UserEntity userEntity = userService.getUser(id);
        return success(userEntity);
    }

    @PutMapping("/")
    public ResponseEntity<UserResponse> updateUser(
            Authentication authentication,
            @RequestParam("id") String id,
            @RequestBody UserInput userInput) throws Exception {
        UserEntity userEntity = userService.updateUser(authentication.getName(), id, userInput);
        return success(userEntity);
    }

    @PutMapping("/password")
    public ResponseEntity<UserResponse> updatePassword(
            Authentication authentication,
            @RequestParam("password") String password,
            @RequestParam("oldpassword") String oldPassword) throws Exception {
        UserEntity userEntity = userService.updatePassword(authentication.getName(), password, oldPassword);
        return success(userEntity);
    }

    @DeleteMapping("/")
    public ResponseEntity<UserResponse> deleteUser(Authentication authentication, @RequestParam("id") String id) throws Exception {
        UserEntity userEntity = userService.deleteUser(authentication.getName(), id);
        return success(userEntity);
    }
}
