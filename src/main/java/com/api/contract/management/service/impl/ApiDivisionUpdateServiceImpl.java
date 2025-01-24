package com.api.contract.management.service.impl;

import com.api.contract.management.dto.request.ApiDivisionUpdateRequest;
import com.api.contract.management.dto.response.DivisionResponse;
import com.api.contract.management.entity.Division;
import com.api.contract.management.repository.DivisionRepository;
import com.api.contract.management.service.contract.ApiDivisionUpdateService;
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
public class ApiDivisionUpdateServiceImpl implements ApiDivisionUpdateService {

    private final DivisionRepository divisionRepository;

    @Transactional
    @Override
    public DivisionResponse execute(ApiDivisionUpdateRequest request) {
        Long now = Instant.now().toEpochMilli();
        Division division = updateDivision(request, now);
        return buildApiDivisionUpdateResponse(division);
    }

    private Division updateDivision(ApiDivisionUpdateRequest request, Long now) {
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

    private DivisionResponse buildApiDivisionUpdateResponse(Division division) {
        DivisionResponse response = new DivisionResponse();
        BeanUtils.copyProperties(division, response);
        return response;
    }

}
