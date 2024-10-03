package com.api.contract.management.base.command.impl;

import com.api.contract.management.base.command.Command;
import com.api.contract.management.base.command.ServiceExecutor;
import com.api.contract.management.base.dto.request.ServiceRequest;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ServiceExutorImpl implements ServiceExecutor, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public <REQUEST extends ServiceRequest, RESPONSE> RESPONSE execute(Class<? extends Command<REQUEST, RESPONSE>> commandClass, REQUEST request) {

        Command<REQUEST,RESPONSE> command = applicationContext.getBean(commandClass);

        return command.execute(request);
    }
}
 