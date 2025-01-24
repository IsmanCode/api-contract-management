package com.api.contract.management.service.impl;

import com.api.contract.management.base.command.ServiceExecutor;
import com.api.contract.management.dto.request.ApiDivisionStoreRequest;
import com.api.contract.management.dto.response.DivisionResponse;
import com.api.contract.management.entity.Division;
import com.api.contract.management.repository.DivisionRepository;
import com.api.contract.management.service.contract.ApiDivisionStoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApiDivisionStoreServiceImpl implements ApiDivisionStoreService {

    private final DivisionRepository divisionRepository;

    @Transactional
    @Override
    public DivisionResponse execute(ApiDivisionStoreRequest request) {
        Long now = Instant.now().toEpochMilli();
        Division division = storeDivision(request, now);
        return buildApiDivisionStoreResponse(division);
    }

    private Division storeDivision(ApiDivisionStoreRequest request, Long now) {
        Division apiDivision = new Division();
        BeanUtils.copyProperties(request, apiDivision);
        apiDivision.setName(request.getName());
        apiDivision.setCreatedDate(now);
        apiDivision.setUpdatedDate(now);
        apiDivision.setCreatedBy("system");
        apiDivision.setUpdatedBy("system");
        divisionRepository.save(apiDivision);
        return apiDivision;
    }

    private DivisionResponse buildApiDivisionStoreResponse(Division division) {
        DivisionResponse response = new DivisionResponse();
        BeanUtils.copyProperties(division, response);
        return response;
    }

}
