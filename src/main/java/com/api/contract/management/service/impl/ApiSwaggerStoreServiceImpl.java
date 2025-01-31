package com.api.contract.management.service.impl;

import com.api.contract.management.base.dto.response.BaseResponse;
import com.api.contract.management.base.dto.response.ErrorResponse;
import com.api.contract.management.base.exceptions.thrower.DataNotFoundException;
import com.api.contract.management.common.enums.ApiContractStatusEnum;
import com.api.contract.management.dto.request.ApiSwaggerStoreRequest;
import com.api.contract.management.dto.response.ApiSwaggerStoreResponse;
import com.api.contract.management.entity.ApiContract;
import com.api.contract.management.entity.ApiContractHistory;
import com.api.contract.management.repository.ApiContractHistoryRepository;
import com.api.contract.management.repository.ApiContractRepository;
import com.api.contract.management.service.contract.ApiSwaggerStoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApiSwaggerStoreServiceImpl implements ApiSwaggerStoreService {

    private final ApiContractRepository apiContractRepository;

    private final ApiContractHistoryRepository apiContractHistoryRepository;

    @Transactional
    @Override
    public ApiSwaggerStoreResponse execute(ApiSwaggerStoreRequest request) {
        Long now = Instant.now().toEpochMilli();
        Optional<ApiContract> checkApiContract = apiContractRepository.findById(request.getId());
        if (checkApiContract.isEmpty()) {
            String message = "Api contract not found";
            throw new DataNotFoundException(message,
                    Collections.singletonList(
                            ErrorResponse.builder()
                                    .code("404")
                                    .field("id")
                                    .message(message)
                                    .build()
                    ));
        }
        ApiContract apiContract = checkApiContract.get();
        saveApiContractHistory(apiContract,now);
        updateApiContract(request,apiContract,now);

        return buildApiSwaggerStoreResponse(request);
    }

    private ApiSwaggerStoreResponse buildApiSwaggerStoreResponse(ApiSwaggerStoreRequest request) {
        ApiSwaggerStoreResponse response = new ApiSwaggerStoreResponse();
        response.setId(request.getId());
        return response;
    }


    private void updateApiContract(ApiSwaggerStoreRequest request,ApiContract apiContract, Long now) {
        log.debug("updateApiContract");
        if (!isNewData(apiContract)) {
            log.debug("updateApiContract - not new data");
            apiContract.setRevision(apiContract.getRevision() + 1);
        }
        apiContract.setOpenApiSpec(request.getOpenApiSpec());
        apiContract.setUpdatedDate(now);
        apiContract.setUpdatedBy(apiContract.getUpdatedBy());
        apiContractRepository.save(apiContract);
    }

    private void saveApiContractHistory(ApiContract apiContract,Long now) {
        log.debug("saveApiContractHistory");
        if (!isNewData(apiContract)) {
            log.debug("saveApiContractHistory - not new data");
            ApiContractHistory apiContractHistory = new ApiContractHistory();
            BeanUtils.copyProperties(apiContract, apiContractHistory);
            apiContractHistory.setOpenApiSpec(apiContract.getOpenApiSpec());
            apiContractHistory.setApiContract(apiContract);
            apiContractHistory.setCreatedDate(now);
            apiContractHistory.setUpdatedDate(now);
            apiContractHistory.setCreatedBy(apiContract.getCreatedBy());
            apiContractHistory.setUpdatedBy(apiContract.getCreatedBy());
            apiContractHistoryRepository.save(apiContractHistory);
        }
    }

    private Boolean isNewData(ApiContract apiContract) {
        return apiContract.getStatus().equals(ApiContractStatusEnum.CONSTRUCT);
    }
}
