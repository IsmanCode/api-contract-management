package com.api.contract.management.service.query.contract;

import com.api.contract.management.base.command.Command;
import com.api.contract.management.dto.query.request.DivisionListRequest;
import com.api.contract.management.dto.query.response.DivisionResponse;

import java.util.List;

public interface DivisionListService extends Command<DivisionListRequest, List<DivisionResponse>> {
}
