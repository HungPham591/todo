package com.spring.todo.controllers.v1;

import com.spring.todo.controllers.BaseController;
import com.spring.todo.model.entities.TypeRelationshipEntity;
import com.spring.todo.model.inputs.TypeRelationshipInput;
import com.spring.todo.model.response.TypeRelationshipResponse;
import com.spring.todo.services.TypeRelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/typeRelationship", produces = MediaType.APPLICATION_JSON_VALUE)
public class TypeRelationshipController extends BaseController<TypeRelationshipEntity, TypeRelationshipResponse> {

    @Autowired
    private TypeRelationshipService typeRelationshipService;

    @GetMapping("/typeRelationship")
    public ResponseEntity<TypeRelationshipResponse> getTypeRelationship(Authentication authentication, @RequestParam("id") String id) throws Exception {
        TypeRelationshipEntity typeRelationshipEntity = typeRelationshipService.getTypeRelationship(id);
        return success(typeRelationshipEntity);
    }

    @GetMapping("/typeRelationships")
    public ResponseEntity<List<TypeRelationshipResponse>> getTypeRelationships(Authentication authentication) throws Exception {
        List<TypeRelationshipEntity> typeRelationshipEntities = typeRelationshipService.getTypeRelationships();
        return success(typeRelationshipEntities);
    }

    @PostMapping("/")
    public ResponseEntity<TypeRelationshipResponse> createTypeRelationship(Authentication authentication, @RequestBody TypeRelationshipInput input) throws Exception {
        TypeRelationshipEntity typeRelationshipEntity = typeRelationshipService.createTypeRelationship(input);
        return success(typeRelationshipEntity);
    }

    @PutMapping("/")
    public ResponseEntity<TypeRelationshipResponse> updateTypeRelationship(Authentication authentication, @RequestBody TypeRelationshipInput input) throws Exception {
        TypeRelationshipEntity typeRelationshipEntity = typeRelationshipService.updateTypeRelationship(input);
        return success(typeRelationshipEntity);
    }

    @DeleteMapping("/")
    public ResponseEntity<TypeRelationshipResponse> deleteTypeRelationship(Authentication authentication, @RequestBody TypeRelationshipInput input) throws Exception {
        TypeRelationshipEntity typeRelationshipEntity = typeRelationshipService.deleteTypeRelationship(input);
        return success(typeRelationshipEntity);
    }
}
