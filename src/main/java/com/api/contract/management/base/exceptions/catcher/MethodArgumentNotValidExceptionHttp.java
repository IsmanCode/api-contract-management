package com.api.contract.management.base.exceptions.catcher;

import com.api.contract.management.base.dto.request.BaseExceptionRequest;
import com.api.contract.management.base.dto.response.ErrorResponse;
import com.api.contract.management.base.dto.response.BaseResponse;
import com.api.contract.management.base.exceptions.AbstractException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class MethodArgumentNotValidExceptionHttp implements AbstractException {

    @Override
    public ResponseEntity buildResponse(BaseExceptionRequest exception) {

        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        if (exception.getException() instanceof MethodArgumentNotValidException data) {

            List<ErrorResponse> errors = data.getBindingResult().getFieldErrors().stream()
                    .map(fieldError -> {
                        ErrorResponse errorResponse = new ErrorResponse();
                        errorResponse.setCode(fieldError.getCode());
                        errorResponse.setField(fieldError.getField());
                        errorResponse.setMessage(fieldError.getDefaultMessage());
                        return errorResponse;
                    }).collect(Collectors.toList());

            return ResponseEntity
                    .status(httpStatus)
                    .body(
                            BaseResponse.builder()
                                    .errors(errors)
                                    .build()
                    );
        }

        throw new RuntimeException("not handle exception",exception.getException());
    }

}
