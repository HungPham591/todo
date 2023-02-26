package com.spring.todo.services;

import com.spring.todo.model.entities.TypeRelationshipEntity;
import com.spring.todo.model.inputs.TypeRelationshipInput;
import com.spring.todo.repositories.TypeRelationshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
public class TypeRelationshipService extends BaseService {

    @Autowired
    private TypeRelationshipRepository typeRelationshipRepository;

    public TypeRelationshipEntity getTypeRelationship(String id) throws Exception {
        Optional<TypeRelationshipEntity> typeRelationshipEntity = typeRelationshipRepository.findById(id);
        if (typeRelationshipEntity.isEmpty()) {
            throw new Exception();
        }
        return typeRelationshipEntity.get();
    }

    public List<TypeRelationshipEntity> getTypeRelationships() throws Exception {
        List<TypeRelationshipEntity> typeRelationshipEntities = typeRelationshipRepository.findAll();
        if (ObjectUtils.isEmpty(typeRelationshipEntities)) {
            throw new Exception();
        }
        return typeRelationshipEntities;
    }

    public TypeRelationshipEntity createTypeRelationship(TypeRelationshipInput input) throws Exception {
        TypeRelationshipEntity typeRelationshipEntity = typeRelationshipRepository.save(input.toEntity());
        if (ObjectUtils.isEmpty(typeRelationshipEntity)) {
            throw new Exception();
        }
        return typeRelationshipEntity;
    }

    public TypeRelationshipEntity updateTypeRelationship(String id, TypeRelationshipInput input) throws Exception {
        this.getTypeRelationship(id);
        TypeRelationshipEntity typeRelationship = input.toEntity();
        typeRelationship.setId(id);
        TypeRelationshipEntity typeRelationshipEntity = typeRelationshipRepository.save(typeRelationship);
        return typeRelationshipEntity;
    }

    public TypeRelationshipEntity deleteTypeRelationship(String id, TypeRelationshipInput input) throws Exception {
        this.getTypeRelationship(id);
        typeRelationshipRepository.deleteById(id);
        TypeRelationshipEntity typeRelationshipEntity = new TypeRelationshipEntity();
        typeRelationshipEntity.setId(id);
        return typeRelationshipEntity;
    }
}
