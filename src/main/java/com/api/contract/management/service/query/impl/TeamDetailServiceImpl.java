package com.api.contract.management.service.query.impl;

import com.api.contract.management.base.dto.request.UniqueRequest;
import com.api.contract.management.base.dto.response.ErrorResponse;
import com.api.contract.management.base.exceptions.thrower.DataNotFoundException;
import com.api.contract.management.dto.query.request.TeamDetailRequest;
import com.api.contract.management.dto.query.response.TeamResponse;
import com.api.contract.management.entity.Team;
import com.api.contract.management.repository.TeamRepository;
import com.api.contract.management.service.query.contract.TeamDetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeamDetailServiceImpl implements TeamDetailService {

    private final TeamRepository divisionRepository;

    @Override
    public TeamResponse execute(TeamDetailRequest request) {

        Optional<Team> checkData = divisionRepository.findByIdAndDivisionId(request.getId(),request.getDivisionId());

        if (!checkData.isPresent()) {
            String message = "Team not found";
            throw new DataNotFoundException(message, Arrays.asList(
                    ErrorResponse.builder()
                            .code("404")
                            .field("id")
                            .message(message)
                            .build()
            ));
        }
        Team data = checkData.get();

        return buildResponse(data);
    }

    private TeamResponse buildResponse(Team data) {
        return TeamResponse.builder()
                .divisionId(data.getDivision().getId())
                .id(data.getId())
                .name(data.getName())
                .title(data.getTitle())
                .entity(data)
                .build();
    }
}
