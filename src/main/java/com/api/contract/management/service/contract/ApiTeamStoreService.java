package com.api.contract.management.service.contract;

import com.api.contract.management.base.command.Command;
import com.api.contract.management.dto.request.ApiTeamStoreRequest;
import com.api.contract.management.dto.response.TeamResponse;

public interface ApiTeamStoreService extends Command<ApiTeamStoreRequest, TeamResponse> {
}
