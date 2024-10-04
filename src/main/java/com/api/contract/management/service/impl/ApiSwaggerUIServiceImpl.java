package com.api.contract.management.service.impl;

import com.api.contract.management.dto.request.ApiSwaggerUIRequest;
import com.api.contract.management.dto.response.ApiSwaggerUIResponse;
import com.api.contract.management.entity.ApiContract;
import com.api.contract.management.repository.ApiContractRepository;
import com.api.contract.management.service.contract.ApiSwaggerUIService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApiSwaggerUIServiceImpl implements ApiSwaggerUIService {

    private final ApiContractRepository apiContractRepository;

    @Override
    public ApiSwaggerUIResponse execute(ApiSwaggerUIRequest request) {
        Optional<ApiContract> checkApiContract = apiContractRepository.findById(request.getId());
        if (!checkApiContract.isPresent()) {
            return new ApiSwaggerUIResponse();
        }
        ApiContract apiContract = checkApiContract.get();
        return ApiSwaggerUIResponse.builder()
                .openApiSpec(apiContract.getOpenApiSpec() == null ? new HashMap<>() :apiContract.getOpenApiSpec())
                .build();
    }
}
