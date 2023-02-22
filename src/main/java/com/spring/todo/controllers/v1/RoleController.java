package com.spring.todo.controllers.v1;

import com.spring.todo.controllers.BaseController;
import com.spring.todo.model.entities.RoleEntity;
import com.spring.todo.model.inputs.RoleInput;
import com.spring.todo.model.response.RoleResponse;
import com.spring.todo.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/role", produces = MediaType.APPLICATION_JSON_VALUE)
public class RoleController extends BaseController<RoleEntity, RoleResponse> {
    @Autowired
    private RoleService roleService;

    @GetMapping("/role")
    public ResponseEntity<RoleResponse> getRole(@RequestParam("id") String id) throws Exception {
        RoleEntity roleEntity = roleService.getRole(id);
        return success(roleEntity);
    }

    @GetMapping("/roles")
    public ResponseEntity<List<RoleResponse>> getRoles() throws Exception {
        List<RoleEntity> roleEntities = roleService.getRoles();
        return success(roleEntities);
    }

    @PostMapping("/")
    public ResponseEntity<RoleResponse> createRole(@RequestBody RoleInput roleInput) throws Exception {
        RoleEntity roleEntity = roleService.createRole(roleInput);
        return success(roleEntity);
    }

    @PutMapping("/")
    public ResponseEntity<RoleResponse> updateRole(
            @RequestParam("id") String id,
            @RequestBody RoleInput roleInput) throws Exception {
        RoleEntity roleEntity = roleService.updateRole(id, roleInput);
        return success(roleEntity);
    }

    @DeleteMapping("/")
    public ResponseEntity<RoleResponse> deleteRole(@RequestParam("id") String id) throws Exception {
        RoleEntity roleEntity = roleService.deleteRole(id);
        return success(roleEntity);
    }
}
