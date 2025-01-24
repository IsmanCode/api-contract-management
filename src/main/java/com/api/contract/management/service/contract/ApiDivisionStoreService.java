package com.api.contract.management.service.contract;

import com.api.contract.management.base.command.Command;
import com.api.contract.management.dto.request.ApiContractStoreRequest;
import com.api.contract.management.dto.request.ApiDivisionStoreRequest;
import com.api.contract.management.dto.response.ApiContractStoreResponse;
import com.api.contract.management.dto.response.DivisionResponse;

public interface ApiDivisionStoreService extends Command<ApiDivisionStoreRequest, DivisionResponse> {
}
