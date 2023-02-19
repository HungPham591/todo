package com.spring.todo.repositories.custom;

import com.spring.todo.model.entities.AdminEntity;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.List;


public class AdminRepositoryCustomImpl extends BaseRepositoryCustom<AdminEntity> implements AdminRepositoryCustom {

    @Override
    public List<AdminEntity> findAdminByLikeEmail(String email) {
        Session session = this.getSession();
        String sql = "SELECT a FROM Admin a WHERE a.email LIKE :email";

        Query query = session.createQuery(sql);

        query.setParameter("email", "%" + email + "%");
        return query.list();
    }

    @Override
    public List<AdminEntity> findAdminByLikeId(String id) {
        Session session = this.getSession();
        String sql = "SELECT a FROM Admin a WHERE a.id LIKE :id";

        Query query = session.createQuery(sql);

        query.setParameter("id", "%" + id + "%");
        return query.list();
    }
}
