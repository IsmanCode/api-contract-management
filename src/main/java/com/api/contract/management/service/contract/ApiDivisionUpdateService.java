package com.api.contract.management.service.contract;

import com.api.contract.management.base.command.Command;
import com.api.contract.management.dto.request.ApiDivisionStoreRequest;
import com.api.contract.management.dto.request.ApiDivisionUpdateRequest;
import com.api.contract.management.dto.response.DivisionResponse;

public interface ApiDivisionUpdateService extends Command<ApiDivisionUpdateRequest, DivisionResponse> {
}
