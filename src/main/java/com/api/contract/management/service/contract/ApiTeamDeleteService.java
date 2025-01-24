package com.api.contract.management.service.contract;

import com.api.contract.management.base.command.Command;
import com.api.contract.management.base.dto.request.UniqueRequest;
import com.api.contract.management.base.dto.response.ResultResponse;
import com.api.contract.management.dto.request.ApiTeamDeleteRequest;

import java.util.UUID;

public interface ApiTeamDeleteService extends Command<ApiTeamDeleteRequest, ResultResponse> {
}
