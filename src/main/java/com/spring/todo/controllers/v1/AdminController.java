package com.spring.todo.controllers.v1;


import com.spring.todo.controllers.BaseController;
import com.spring.todo.model.response.AdminResponse;
import com.spring.todo.model.inputs.AdminInput;
import com.spring.todo.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/admin", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminController extends BaseController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/info")
    public ResponseEntity<AdminResponse> getInfo(Authentication authentication) {
        return null;
    }

    @GetMapping("/admin")
    public ResponseEntity<AdminResponse> getAdmin(@RequestParam("id") String id) {
        return null;
    }

    @GetMapping("/admins")
    public ResponseEntity<List<AdminResponse>> getAdmins(
            @RequestParam("email") String email,
            @RequestParam("id") String id,
            @RequestParam("skip") Integer skip,
            @RequestParam("limit") Integer limit) {
        return null;
    }

    @PutMapping("/info")
    public ResponseEntity<AdminResponse> updateAdmin(
            @RequestBody AdminInput adminInput,
            @RequestParam String id) {
        return null;
    }

    @PutMapping("/password")
    public ResponseEntity<AdminResponse> updatePassword(
            Authentication authentication,
            @RequestParam("password") String password,
            @RequestParam("oldpassword") String oldPassword) {
        return null;
    }
}
