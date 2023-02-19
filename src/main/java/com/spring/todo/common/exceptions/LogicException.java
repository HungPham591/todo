package com.spring.todo.common.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LogicException extends RuntimeException {
    private int code;
    private String message;
}
