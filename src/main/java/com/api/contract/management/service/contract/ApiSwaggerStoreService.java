package com.api.contract.management.service.contract;

import com.api.contract.management.base.command.Command;
import com.api.contract.management.base.controller.dto.response.BaseResponse;
import com.api.contract.management.dto.request.ApiSwaggerStoreRequest;
import com.api.contract.management.dto.request.ApiSwaggerUIRequest;
import com.api.contract.management.dto.response.ApiSwaggerStoreResponse;
import com.api.contract.management.dto.response.ApiSwaggerUIResponse;

public interface ApiSwaggerStoreService extends Command<ApiSwaggerStoreRequest, BaseResponse> {
}
