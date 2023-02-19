package com.spring.todo.model.response;

import lombok.Data;

@Data
public class GenderResponse extends BaseResponse {
    private String code;
    private String name;
}
