package com.api.contract.management.base.controller.advice.controller;

import com.api.contract.management.base.dto.request.BaseExceptionRequest;
import com.api.contract.management.base.exceptions.ExceptionFactory;
import com.api.contract.management.base.exceptions.impl.ExceptionFactoryImpl;
import com.api.contract.management.base.exceptions.enums.RequestType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaExceptionAdvice {

    private final ExceptionFactory exceptionFactory;

    public String handleHttpException(Exception exception) {
        Exception ex = exception;
        log.error("ExceptionAdviceHttp " + ex.getMessage());
        log.trace("ExceptionAdviceHttp trace: ", ex);

        BaseExceptionRequest baseExceptionRequest = BaseExceptionRequest.builder()
                .exception(ex)
                .requestType(RequestType.KAFKA.getCode())
                .build();

        return exceptionFactory.buildException(baseExceptionRequest)
                .<String>buildResponse(baseExceptionRequest);

    }

}
