package com.api.contract.management.service.impl;

import com.api.contract.management.base.command.ServiceExecutor;
import com.api.contract.management.base.dto.request.UniqueRequest;
import com.api.contract.management.base.dto.response.ResultResponse;
import com.api.contract.management.common.enums.SuccessActionResultEnum;
import com.api.contract.management.dto.request.ApiTeamDeleteRequest;
import com.api.contract.management.repository.TeamRepository;
import com.api.contract.management.service.contract.ApiTeamDeleteService;
import com.api.contract.management.service.query.contract.TeamFindByIdService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApiTeamDeleteServiceImpl implements ApiTeamDeleteService {

    private final TeamRepository TeamRepository;

    private final ServiceExecutor serviceExecutor;

    @Override
    public ResultResponse execute(ApiTeamDeleteRequest request) {
        serviceExecutor.execute(TeamFindByIdService.class, UniqueRequest.<UUID>builder()
                        .value(request.getId())
                .build());
        TeamRepository.deleteById(request.getId());

        return buildResponse();
    }

    private ResultResponse buildResponse() {

        return ResultResponse.builder()
                .code(SuccessActionResultEnum.DELETE.getCode())
                .code(SuccessActionResultEnum.DELETE.getMessage())
                .build();
    }

}
