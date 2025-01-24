package com.api.contract.management.service.impl;

import com.api.contract.management.base.command.ServiceExecutor;
import com.api.contract.management.base.dto.request.UniqueRequest;
import com.api.contract.management.base.dto.response.ResultResponse;
import com.api.contract.management.common.enums.SuccessActionResultEnum;
import com.api.contract.management.dto.request.ApiDivisionDeleteRequest;
import com.api.contract.management.repository.DivisionRepository;
import com.api.contract.management.service.contract.ApiDivisionDeleteService;
import com.api.contract.management.service.query.contract.DivisionFindByIdService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApiDivisionDeleteServiceImpl implements ApiDivisionDeleteService {

    private final DivisionRepository divisionRepository;

    private final ServiceExecutor serviceExecutor;

    @Override
    public ResultResponse execute(ApiDivisionDeleteRequest request) {
        serviceExecutor.execute(DivisionFindByIdService.class, UniqueRequest.<UUID>builder()
                        .value(request.getId())
                .build());
        divisionRepository.deleteById(request.getId());

        return buildResponse();
    }

    private ResultResponse buildResponse() {

        return ResultResponse.builder()
                .code(SuccessActionResultEnum.DELETE.getCode())
                .code(SuccessActionResultEnum.DELETE.getMessage())
                .build();
    }

}
