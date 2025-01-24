package com.api.contract.management.service.contract;

import com.api.contract.management.base.command.Command;
import com.api.contract.management.dto.request.ApiTeamUpdateRequest;
import com.api.contract.management.dto.response.TeamResponse;

public interface ApiTeamUpdateService extends Command<ApiTeamUpdateRequest, TeamResponse> {
}
