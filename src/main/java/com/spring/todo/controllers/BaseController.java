package com.spring.todo.controllers;


import com.spring.todo.model.entities.BaseEntity;
import com.spring.todo.model.response.BaseResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseController<E extends BaseEntity, R extends BaseResponse> {
    protected ResponseEntity success() {
        return ResponseEntity.ok("");
    }

    protected ResponseEntity<R> success(E entity) {
        return ResponseEntity.ok((R) entity.toReponse());
    }

    protected ResponseEntity<List<R>> success(List<E> listEntity) {
        return ResponseEntity.ok(listEntity.stream().map(entity -> (R) entity.toReponse()).collect(Collectors.toList()));
    }
}
