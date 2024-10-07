package com.api.contract.management.service.query.contract;

import com.api.contract.management.base.command.Command;
import com.api.contract.management.base.controller.dto.response.BaseResponse;
import com.api.contract.management.dto.query.request.DivisionListRequest;
import com.api.contract.management.dto.query.response.DivisionListResponse;
import com.api.contract.management.dto.request.ApiContractPublishRequest;

import java.util.List;

public interface DivisionListService extends Command<DivisionListRequest, List<DivisionListResponse>> {
}
