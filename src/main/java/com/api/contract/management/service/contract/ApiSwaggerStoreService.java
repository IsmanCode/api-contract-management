package com.api.contract.management.service.contract;

import com.api.contract.management.base.command.Command;
import com.api.contract.management.base.dto.response.BaseResponse;
import com.api.contract.management.dto.request.ApiSwaggerStoreRequest;
import com.api.contract.management.dto.response.ApiSwaggerStoreResponse;

public interface ApiSwaggerStoreService extends Command<ApiSwaggerStoreRequest, ApiSwaggerStoreResponse> {
}
