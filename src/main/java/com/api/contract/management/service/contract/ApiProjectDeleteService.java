package com.api.contract.management.service.contract;

import com.api.contract.management.base.command.Command;
import com.api.contract.management.base.dto.response.ResultResponse;
import com.api.contract.management.dto.request.ApiDivisionDeleteRequest;
import com.api.contract.management.dto.request.ApiProjectDeleteRequest;

public interface ApiProjectDeleteService extends Command<ApiProjectDeleteRequest, ResultResponse> {
}
