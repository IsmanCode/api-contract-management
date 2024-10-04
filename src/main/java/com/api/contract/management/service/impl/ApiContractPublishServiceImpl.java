package com.api.contract.management.service.impl;

import com.api.contract.management.base.controller.dto.response.BaseResponse;
import com.api.contract.management.base.dto.response.ErrorResponse;
import com.api.contract.management.base.exceptions.thrower.DataNotFoundException;
import com.api.contract.management.common.enums.ApiContractStatusEnum;
import com.api.contract.management.dto.request.ApiContractPublishRequest;
import com.api.contract.management.dto.request.ApiSwaggerStoreRequest;
import com.api.contract.management.dto.response.ApiContractPublishResponse;
import com.api.contract.management.dto.response.ApiSwaggerStoreResponse;
import com.api.contract.management.entity.ApiContract;
import com.api.contract.management.entity.ApiContractHistory;
import com.api.contract.management.repository.ApiContractHistoryRepository;
import com.api.contract.management.repository.ApiContractRepository;
import com.api.contract.management.service.contract.ApiContractPublishService;
import com.api.contract.management.service.contract.ApiSwaggerStoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApiContractPublishServiceImpl implements ApiContractPublishService {

    private final ApiContractRepository apiContractRepository;

    @Transactional
    @Override
    public BaseResponse execute(ApiContractPublishRequest request) {
        Optional<ApiContract> checkApiContract = apiContractRepository.findById(request.getId());
        if (!checkApiContract.isPresent()) {
            String message = "Api contract not found";
            throw new DataNotFoundException(message,
                    Arrays.asList(
                            ErrorResponse.builder()
                                    .code("404")
                                    .field("id")
                                    .message(message)
                                    .build()
                    ));
        }
        ApiContract apiContract = checkApiContract.get();
        if (apiContract.getStatus().equals(ApiContractStatusEnum.PUBLISHED)) {
            return buildApiSwaggerStoreResponse(request);
        }
        apiContract.setStatus(ApiContractStatusEnum.PUBLISHED);
        apiContract.setUpdatedDate(new Date());
        apiContract.setUpdatedBy(apiContract.getUpdatedBy());
        apiContractRepository.save(apiContract);

        return buildApiSwaggerStoreResponse(request);
    }

    private BaseResponse buildApiSwaggerStoreResponse(ApiContractPublishRequest request) {
        ApiContractPublishResponse response = new ApiContractPublishResponse();
        response.setId(request.getId());
        return BaseResponse.builder()
                .data(response)
                .build();
    }

}
