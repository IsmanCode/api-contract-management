package com.api.contract.management.service.query.impl;

import com.api.contract.management.dto.query.request.DivisionListRequest;
import com.api.contract.management.dto.query.response.DivisionResponse;
import com.api.contract.management.entity.Division;
import com.api.contract.management.repository.DivisionRepository;
import com.api.contract.management.service.query.contract.DivisionListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DivisionListServiceImpl implements DivisionListService {

    private final DivisionRepository divisionRepository;

    @Override
    public List<DivisionResponse> execute(DivisionListRequest request) {

        List<Division> divisions = divisionRepository.findAll();

        return buildResponse(divisions);
    }

    private List<DivisionResponse> buildResponse(List<Division> divisions) {
        return divisions.stream()
                .map(division -> DivisionResponse.builder()
                        .id(division.getId())
                        .name(division.getName())
                        .title(division.getTitle())
                        .entity(division)
                        .build())
                .toList();
    }
}
