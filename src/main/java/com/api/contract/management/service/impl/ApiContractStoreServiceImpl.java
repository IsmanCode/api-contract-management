package com.api.contract.management.service.impl;

import com.api.contract.management.dto.request.ApiContractStoreRequest;
import com.api.contract.management.dto.response.ApiContractStoreResponse;
import com.api.contract.management.repository.ApiContractHistoryRepository;
import com.api.contract.management.repository.ApiContractRepository;
import com.api.contract.management.service.contract.ApiContractStoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApiContractStoreServiceImpl implements ApiContractStoreService {

    private final ApiContractRepository apiContractRepository;

    private final ApiContractHistoryRepository apiContractHistoryRepository;

    @Transactional
    @Override
    public ApiContractStoreResponse execute(ApiContractStoreRequest request) {

        return buildApiContractStoreResponse(request);
    }

    private ApiContractStoreResponse buildApiContractStoreResponse(ApiContractStoreRequest request) {
        ApiContractStoreResponse response = new ApiContractStoreResponse();
        return response;
    }

}
