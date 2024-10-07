package com.api.contract.management.service.query.contract;

import com.api.contract.management.base.command.Command;
import com.api.contract.management.dto.query.request.ProjectListRequest;
import com.api.contract.management.dto.query.response.ProjectListResponse;

import java.util.List;

public interface ProjectListService extends Command<ProjectListRequest, List<ProjectListResponse>> {
}
