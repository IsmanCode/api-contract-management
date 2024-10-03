package com.api.contract.management.base.command;

import com.api.contract.management.base.dto.request.ServiceRequest;

public interface ServiceExecutor {

    <REQUEST extends ServiceRequest, RESPONSE> RESPONSE execute(Class<? extends Command<REQUEST,RESPONSE>> commandClass, REQUEST request);

}
