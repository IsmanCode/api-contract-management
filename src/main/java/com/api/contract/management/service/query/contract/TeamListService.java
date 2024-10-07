package com.api.contract.management.service.query.contract;

import com.api.contract.management.base.command.Command;
import com.api.contract.management.dto.query.request.TeamListRequest;
import com.api.contract.management.dto.query.response.TeamResponse;

import java.util.List;

public interface TeamListService extends Command<TeamListRequest, List<TeamResponse>> {
}
