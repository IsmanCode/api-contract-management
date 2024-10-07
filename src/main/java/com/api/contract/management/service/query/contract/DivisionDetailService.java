package com.api.contract.management.service.query.contract;

import com.api.contract.management.base.command.Command;
import com.api.contract.management.base.dto.request.UniqueRequest;
import com.api.contract.management.dto.query.request.DivisionDetailRequest;
import com.api.contract.management.dto.query.request.DivisionListRequest;
import com.api.contract.management.dto.query.response.DivisionResponse;

import java.util.List;
import java.util.UUID;

public interface DivisionDetailService extends Command<DivisionDetailRequest, DivisionResponse> {
}
