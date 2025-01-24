package com.api.contract.management.service.query.impl;

import com.api.contract.management.base.dto.request.UniqueRequest;
import com.api.contract.management.base.dto.response.ErrorResponse;
import com.api.contract.management.base.exceptions.thrower.DataNotFoundException;
import com.api.contract.management.common.enums.ErrorActionResultEnum;
import com.api.contract.management.dto.query.response.TeamResponse;
import com.api.contract.management.entity.Team;
import com.api.contract.management.repository.TeamRepository;
import com.api.contract.management.service.query.contract.TeamFindByIdService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeamFindByIdServiceImpl implements TeamFindByIdService {

    private final TeamRepository TeamRepository;

    @Override
    public TeamResponse execute(UniqueRequest<UUID> request) {

        Optional<Team> checkData = TeamRepository.findById(request.getValue());

        if (checkData.isEmpty()) {
            String message = "Team not found";
            throw new DataNotFoundException(message, Collections.singletonList(
                    ErrorResponse.builder()
                            .code(ErrorActionResultEnum.NOT_FOUND.getCode())
                            .field("id")
                            .message(ErrorActionResultEnum.NOT_FOUND.getMessage())
                            .build()
            ));
        }
        Team data = checkData.get();

        return buildResponse(data);
    }

    private TeamResponse buildResponse(Team data) {
        return TeamResponse.builder()
                .id(data.getId())
                .name(data.getName())
                .title(data.getTitle())
                .entity(data)
                .build();
    }
}
