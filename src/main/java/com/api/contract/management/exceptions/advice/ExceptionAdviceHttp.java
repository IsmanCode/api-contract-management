package com.api.contract.management.exceptions.advice;

import com.api.contract.management.base.dto.request.BaseExceptionRequest;
import com.api.contract.management.base.exceptions.ExceptionFactory;
import com.api.contract.management.base.exceptions.enums.RequestType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class ExceptionAdviceHttp {

    private final ExceptionFactory exceptionFactory;

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleHttpException(Exception exception) {
        Exception ex = exception;
        log.error("ExceptionAdviceHttp " + ex.getMessage());
        log.trace("ExceptionAdviceHttp trace: ", ex);

        BaseExceptionRequest baseExceptionRequest = BaseExceptionRequest.builder()
                .exception(ex)
                .requestType(RequestType.HTTP.getCode())
                .build();

        return exceptionFactory.buildException(baseExceptionRequest)
                .buildResponse(baseExceptionRequest);

    }

}
