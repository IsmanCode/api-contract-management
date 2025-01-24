package com.api.contract.management.service.query.contract;

import com.api.contract.management.base.command.Command;
import com.api.contract.management.base.dto.request.UniqueRequest;
import com.api.contract.management.dto.query.response.ProjectResponse;
import com.api.contract.management.dto.query.response.TeamResponse;

import java.util.UUID;

public interface TeamFindByIdService extends Command<UniqueRequest<UUID>, TeamResponse> {
}
