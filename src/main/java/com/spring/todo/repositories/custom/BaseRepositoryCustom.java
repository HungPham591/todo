package com.spring.todo.repositories.custom;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class BaseRepositoryCustom<T> {
    @Autowired
    public SessionFactory sessionFactory;

    public Session getSession() {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
            return session;
        } catch (Exception e) {
            session = sessionFactory.openSession();
            return session;
        }
    }

}
