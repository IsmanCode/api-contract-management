package com.api.contract.management.base.exceptions.catcher;

import com.api.contract.management.base.dto.response.ErrorResponse;
import com.api.contract.management.base.controller.dto.response.BaseResponse;
import com.api.contract.management.base.exceptions.AbstractException;
import com.api.contract.management.base.dto.request.BaseExceptionRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class MissingServletRequestParameterExceptionHttp implements AbstractException {

    @Override
    public ResponseEntity buildResponse(BaseExceptionRequest exception) {

        List<ErrorResponse> errors = new ArrayList();
        ErrorResponse error = new ErrorResponse();
        error.setCode("400");
        error.setField("-");
        error.setMessage(exception.getException().getMessage());
        errors.add(error);

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(
                        BaseResponse.builder()
                                .errors(errors)
                                .build()
                );
    }

}
