package com.api.contract.management.service.contract;

import com.api.contract.management.base.command.Command;
import com.api.contract.management.base.dto.response.ResultResponse;
import com.api.contract.management.dto.request.ApiDivisionDeleteRequest;
import com.api.contract.management.dto.request.ApiDivisionStoreRequest;
import com.api.contract.management.dto.response.DivisionResponse;

public interface ApiDivisionDeleteService extends Command<ApiDivisionDeleteRequest, ResultResponse> {
}
