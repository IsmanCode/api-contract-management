package com.api.contract.management.service.query.impl;

import com.api.contract.management.base.dto.request.UniqueRequest;
import com.api.contract.management.base.dto.response.ErrorResponse;
import com.api.contract.management.base.dto.response.ResultResponse;
import com.api.contract.management.base.exceptions.thrower.DataNotFoundException;
import com.api.contract.management.common.enums.ErrorActionResultEnum;
import com.api.contract.management.dto.query.request.DivisionDetailRequest;
import com.api.contract.management.dto.query.response.DivisionResponse;
import com.api.contract.management.entity.Division;
import com.api.contract.management.repository.DivisionRepository;
import com.api.contract.management.service.query.contract.DivisionDetailService;
import com.api.contract.management.service.query.contract.DivisionFindByIdService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class DivisionFindByIdServiceImpl implements DivisionFindByIdService {

    private final DivisionRepository divisionRepository;

    @Override
    public DivisionResponse execute(UniqueRequest<UUID> request) {

        Optional<Division> checkData = divisionRepository.findById(request.getValue());

        if (checkData.isEmpty()) {
            String message = "Division not found";
            throw new DataNotFoundException(message, Collections.singletonList(
                    ErrorResponse.builder()
                            .code(ErrorActionResultEnum.NOT_FOUND.getCode())
                            .field("id")
                            .message(ErrorActionResultEnum.NOT_FOUND.getMessage())
                            .build()
            ));
        }
        Division data = checkData.get();

        return buildResponse(data);
    }

    private DivisionResponse buildResponse(Division data) {
        return DivisionResponse.builder()
                .id(data.getId())
                .name(data.getName())
                .title(data.getTitle())
                .entity(data)
                .build();
    }
}
