package com.api.contract.management.base.controller.advice.controller;

import com.api.contract.management.base.dto.request.BaseExceptionRequest;
import com.api.contract.management.base.exceptions.ExceptionFactory;
import com.api.contract.management.base.exceptions.impl.ExceptionFactoryImpl;
import com.api.contract.management.base.exceptions.enums.RequestType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Slf4j
@RequiredArgsConstructor
@ControllerAdvice
public class HttpExceptionAdvice {

    private final ExceptionFactory exceptionFactory;

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
