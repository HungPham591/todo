package com.spring.todo.model.response;

import lombok.Data;

@Data
public class GenericReponseResponse extends BaseResponse {
    private String message;
    private String error;
}
