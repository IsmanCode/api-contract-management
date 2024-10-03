package com.api.contract.management.base.exceptions.impl;

import com.api.contract.management.base.dto.request.BaseExceptionRequest;
import com.api.contract.management.base.exceptions.AbstractException;
import com.api.contract.management.base.exceptions.ExceptionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ExceptionFactoryImpl implements ExceptionFactory, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public AbstractException buildException(BaseExceptionRequest exception) {
        log.info("BaseExceptionRequest: {}", exception);
        String className = exception.getException().getClass().getSimpleName();

        String requestType = "";
        if (exception.getRequestType() != null) {
            requestType = exception.getRequestType();
            className = className.concat(requestType);
            log.info("className: {}", className);
            //RuntimeExceptionHttp
        }

        className = toLowerFirstChar(className); //runtimeExceptionHttp
        log.info("className.toLowerFirstChar: {}", className);

        if (applicationContext.containsBean(className)) {
            return (AbstractException) applicationContext.getBean(className);
        }

        className = "globalException".concat(requestType);

        return (AbstractException) applicationContext.getBean(className);

    }

    private String toLowerFirstChar(String string) {
        if (string == null || string.length() == 0) {
            return string;
        }

        char c[] = string.toCharArray();
        c[0] = Character.toLowerCase(c[0]);

        return new String(c);
    }

}
