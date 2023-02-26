package com.spring.todo.common.exceptions;

public class UserAlreadyExistException extends RuntimeException {
    private int code;
    private String message;
}
