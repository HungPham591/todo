package com.spring.todo.services;

import org.springframework.data.domain.Pageable;

import java.util.List;

public class BaseService {
    protected void ensureOwnerShip(String userId, String ownerId) throws Exception {
        if (userId.equals(ownerId)) {
            throw new Exception();
        }
    }


    protected Pageable createPagination(List<String> listSort) {
        return null;
    }

    protected Pageable createPagination(Integer skip, Integer limit) throws Exception {
        return null;
    }

    protected Pageable createPagination(Integer skip, Integer limit, List<String> listSort) throws Exception {
        return null;
    }
}
