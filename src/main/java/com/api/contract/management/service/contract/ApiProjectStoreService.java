package com.api.contract.management.service.contract;

import com.api.contract.management.base.command.Command;
import com.api.contract.management.dto.request.ApiProjectStoreRequest;
import com.api.contract.management.dto.response.ProjectResponse;

public interface ApiProjectStoreService extends Command<ApiProjectStoreRequest, ProjectResponse> {
}
