package com.api.contract.management.service.query.impl;

import com.api.contract.management.base.dto.request.UniqueRequest;
import com.api.contract.management.base.dto.response.ErrorResponse;
import com.api.contract.management.base.exceptions.thrower.DataNotFoundException;
import com.api.contract.management.dto.query.request.DivisionDetailRequest;
import com.api.contract.management.dto.query.response.DivisionResponse;
import com.api.contract.management.entity.Division;
import com.api.contract.management.repository.DivisionRepository;
import com.api.contract.management.service.query.contract.DivisionDetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class DivisionDetailServiceImpl implements DivisionDetailService {

    private final DivisionRepository divisionRepository;

    @Override
    public DivisionResponse execute(DivisionDetailRequest request) {

        Optional<Division> checkData = divisionRepository.findById(request.getId());

        if (!checkData.isPresent()) {
            String message = "Division not found";
            throw new DataNotFoundException(message, Arrays.asList(
                    ErrorResponse.builder()
                            .code("404")
                            .field("id")
                            .message(message)
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
