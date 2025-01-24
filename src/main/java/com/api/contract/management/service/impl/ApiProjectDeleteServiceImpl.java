package com.api.contract.management.service.impl;

import com.api.contract.management.base.command.ServiceExecutor;
import com.api.contract.management.base.dto.request.UniqueRequest;
import com.api.contract.management.base.dto.response.ResultResponse;
import com.api.contract.management.common.enums.SuccessActionResultEnum;
import com.api.contract.management.dto.request.ApiProjectDeleteRequest;
import com.api.contract.management.repository.ProjectRepository;
import com.api.contract.management.service.contract.ApiProjectDeleteService;
import com.api.contract.management.service.query.contract.ProjectFindByIdService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApiProjectDeleteServiceImpl implements ApiProjectDeleteService {

    private final ProjectRepository projectRepository;

    private final ServiceExecutor serviceExecutor;

    @Override
    public ResultResponse execute(ApiProjectDeleteRequest request) {
        serviceExecutor.execute(ProjectFindByIdService.class, UniqueRequest.<UUID>builder()
                        .value(request.getId())
                .build());
        projectRepository.deleteById(request.getId());

        return buildResponse();
    }

    private ResultResponse buildResponse() {

        return ResultResponse.builder()
                .code(SuccessActionResultEnum.DELETE.getCode())
                .code(SuccessActionResultEnum.DELETE.getMessage())
                .build();
    }

}
