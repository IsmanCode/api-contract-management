package com.api.contract.management.service.contract;

import com.api.contract.management.base.command.Command;
import com.api.contract.management.base.controller.dto.response.BaseResponse;
import com.api.contract.management.dto.request.ApiContractPublishRequest;
import com.api.contract.management.dto.request.ApiSwaggerStoreRequest;
import com.api.contract.management.dto.response.ApiContractPublishResponse;
import com.api.contract.management.dto.response.ApiSwaggerStoreResponse;

public interface ApiContractPublishService extends Command<ApiContractPublishRequest, BaseResponse> {
}
