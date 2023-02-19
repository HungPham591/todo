package com.spring.todo.controllers.v1;

import com.spring.todo.controllers.BaseController;
import com.spring.todo.model.response.RoleResponse;
import com.spring.todo.model.entities.RoleEntity;
import com.spring.todo.model.inputs.RoleInput;
import com.spring.todo.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/role", produces = MediaType.APPLICATION_JSON_VALUE)
public class RoleController extends BaseController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/role")
    public ResponseEntity<RoleResponse> getRole(@RequestParam("id") String id) {
        return null;
    }

    @GetMapping("/roles")
    public ResponseEntity<RoleResponse> getRoles(
            @RequestParam("name") String name,
            @RequestParam("skip") Integer skip,
            @RequestParam("limit") Integer limit) {
        return null;
    }

    @GetMapping("/myRole")
    public ResponseEntity<RoleResponse> getMyRole(
            Authentication authentication,
            @RequestParam String group) {
        return null;
    }

    @PostMapping("/")
    public ResponseEntity<RoleResponse> createRole(@RequestBody RoleInput roleInput) {
        return null;
    }

    @PutMapping("/")
    public ResponseEntity<RoleEntity> updateRole(
            @RequestParam("id") String id,
            @RequestBody RoleInput roleInput) {
        return null;
    }

    @PutMapping("/memberRole")
    public ResponseEntity<RoleEntity> setRole() {
        return null;
    }

    @DeleteMapping("/")
    public ResponseEntity<RoleEntity> deleteRole(@RequestParam("id") String id) {
        return null;
    }
}
