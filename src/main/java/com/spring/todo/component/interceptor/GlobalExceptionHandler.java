package com.spring.todo.component.interceptor;

import com.spring.todo.common.exceptions.AuthException;
import com.spring.todo.common.exceptions.DataException;
import com.spring.todo.common.exceptions.LogicException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public String handleUnknownException(Exception e) {
        String errorMessage = "Unknown error";
        System.out.println(e);
        return errorMessage;
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public String handleBindException(BindException e) {
        String errorMessage = "Request invalid";
        if (e.getBindingResult().hasErrors()) {
            e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        }
        return errorMessage;
    }

    @ExceptionHandler(DataException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public String handleDataException(DataException e) {
        String errorMessage = "Logic invalid";
        return errorMessage;
    }

    @ExceptionHandler(LogicException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public String handleLogicException(LogicException e) {
        String errorMessage = "Request invalid";
        return errorMessage;
    }

    @ExceptionHandler(AuthException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public String handleAuthException(AuthException e) {
        String errorMessage = "Request invalid";
        return errorMessage;
    }
}
