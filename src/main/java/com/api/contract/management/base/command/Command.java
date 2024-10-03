package com.api.contract.management.base.command;

import com.api.contract.management.base.dto.request.ServiceRequest;

public interface Command<REQUEST extends ServiceRequest, RESPONSE>{

    RESPONSE execute(REQUEST request);

}
