package com.spring.todo.model.entities;

import com.spring.todo.model.response.BaseResponse;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class ProfileEntity<E extends ProfileEntity, D extends BaseResponse> extends BaseEntity<E, D> {

}
