package com.api.contract.management.service.impl;

import com.api.contract.management.base.command.ServiceExecutor;
import com.api.contract.management.common.enums.ApiContractStatusEnum;
import com.api.contract.management.dto.query.request.DivisionDetailRequest;
import com.api.contract.management.dto.query.request.ProjectDetailRequest;
import com.api.contract.management.dto.query.request.TeamDetailRequest;
import com.api.contract.management.dto.request.ApiContractStoreRequest;
import com.api.contract.management.dto.response.ApiContractStoreResponse;
import com.api.contract.management.entity.ApiContract;
import com.api.contract.management.entity.Division;
import com.api.contract.management.entity.Project;
import com.api.contract.management.entity.Team;
import com.api.contract.management.repository.ApiContractHistoryRepository;
import com.api.contract.management.repository.ApiContractRepository;
import com.api.contract.management.service.contract.ApiContractStoreService;
import com.api.contract.management.service.query.contract.DivisionDetailService;
import com.api.contract.management.service.query.contract.ProjectDetailService;
import com.api.contract.management.service.query.contract.TeamDetailService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApiContractStoreServiceImpl implements ApiContractStoreService {

    private final ApiContractRepository apiContractRepository;

    private final ServiceExecutor serviceExecutor;

    @Transactional
    @Override
    public ApiContractStoreResponse execute(ApiContractStoreRequest request) {
        Long now = Instant.now().toEpochMilli();
        ApiContract apiContract = storeContract(request, now);
        return buildApiContractStoreResponse(apiContract);
    }

    private ApiContract storeContract(ApiContractStoreRequest request, Long now) {
        ApiContract apiContract = new ApiContract();
        BeanUtils.copyProperties(request, apiContract);
        apiContract.setName(request.getContractName());
        apiContract.setRevision(0);
        apiContract.setProject(getProject(request));
        apiContract.setStatus(ApiContractStatusEnum.CONSTRUCT);
        apiContract.setCreatedDate(now);
        apiContract.setUpdatedDate(now);
        apiContract.setCreatedBy("system");
        apiContract.setUpdatedBy("system");
        apiContractRepository.save(apiContract);
        return apiContract;
    }

    private Project getProject(ApiContractStoreRequest request) {
        return serviceExecutor.execute(ProjectDetailService.class, ProjectDetailRequest.builder()
                .id(UUID.fromString(request.getProjectId()))
                .teamId(UUID.fromString(request.getTeamId()))
                .build()).getEntity();
    }

    private ApiContractStoreResponse buildApiContractStoreResponse(ApiContract apiContract) {
        ApiContractStoreResponse response = new ApiContractStoreResponse();
        response.setId(apiContract.getId());
        return response;
    }

}
