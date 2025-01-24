package com.api.contract.management.service.contract;

import com.api.contract.management.base.command.Command;
import com.api.contract.management.base.dto.response.BaseResponse;
import com.api.contract.management.dto.request.ApiContractPublishRequest;

public interface ApiContractPublishService extends Command<ApiContractPublishRequest, BaseResponse> {
}
