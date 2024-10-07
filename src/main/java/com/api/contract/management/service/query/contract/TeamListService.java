package com.api.contract.management.service.query.contract;

import com.api.contract.management.base.command.Command;
import com.api.contract.management.dto.query.request.TeamListRequest;
import com.api.contract.management.dto.query.response.DivisionListResponse;
import com.api.contract.management.dto.query.response.TeamListResponse;
import com.api.contract.management.dto.request.ApiContractPublishRequest;

import java.util.List;

public interface TeamListService extends Command<TeamListRequest, List<TeamListResponse>> {
}
