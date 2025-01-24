package com.api.contract.management.service.query.contract;

import com.api.contract.management.base.command.Command;
import com.api.contract.management.base.dto.request.UniqueRequest;
import com.api.contract.management.base.dto.response.ResultResponse;
import com.api.contract.management.dto.query.request.ProjectDetailRequest;
import com.api.contract.management.dto.query.response.DivisionResponse;
import com.api.contract.management.dto.query.response.ProjectResponse;

import java.util.UUID;

public interface DivisionFindByIdService extends Command<UniqueRequest<UUID>, DivisionResponse> {
}
