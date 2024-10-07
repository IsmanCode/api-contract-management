package com.api.contract.management.service.query.contract;

import com.api.contract.management.base.command.Command;
import com.api.contract.management.base.dto.request.UniqueRequest;
import com.api.contract.management.dto.query.request.ProjectDetailRequest;
import com.api.contract.management.dto.query.response.ProjectResponse;

import java.util.UUID;

public interface ProjectDetailService extends Command<ProjectDetailRequest, ProjectResponse> {
}
