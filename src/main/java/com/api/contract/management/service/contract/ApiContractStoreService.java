package com.api.contract.management.service.contract;

import com.api.contract.management.base.command.Command;
import com.api.contract.management.dto.request.ApiContractStoreRequest;
import com.api.contract.management.dto.response.ApiContractStoreResponse;

public interface ApiContractStoreService extends Command<ApiContractStoreRequest, ApiContractStoreResponse> {
}
