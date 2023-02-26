package com.spring.todo.common.exceptions;

public class InvalidOldPasswordException extends RuntimeException {
    private int code;
    private String message;
}
