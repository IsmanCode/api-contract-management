package com.api.contract.management.base.exceptions.thrower;

import com.api.contract.management.base.dto.response.ErrorResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DataNotFoundException extends RuntimeException {

    private Integer httpStatusCode;

    private List<ErrorResponse> errors = new ArrayList<>();

    public DataNotFoundException(String message) {
        super(message);
    }

    public DataNotFoundException(String message,Integer httpStatusCode) {
        super(message);
        this.httpStatusCode = httpStatusCode;
    }

    public DataNotFoundException(String message, List<ErrorResponse> errors) {
        super(message);
        this.errors = errors;
    }

    public DataNotFoundException(String message, List<ErrorResponse> errors, Throwable throwable) {
        super(message, throwable);
        this.errors = errors;
    }
}
