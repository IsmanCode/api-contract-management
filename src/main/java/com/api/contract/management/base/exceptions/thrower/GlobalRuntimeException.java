package com.api.contract.management.base.exceptions.thrower;

import com.api.contract.management.base.dto.response.ErrorResponse;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GlobalRuntimeException extends RuntimeException {

    private List<ErrorResponse> errors = new ArrayList<>();

    public GlobalRuntimeException(String message) {
        super(message);
    }

    public GlobalRuntimeException(String message, List<ErrorResponse> errors) {
        super(message);
        this.errors = errors;
    }

    public GlobalRuntimeException(String message, List<ErrorResponse> errors, Throwable throwable) {
        super(message, throwable);
        this.errors = errors;
    }
}
