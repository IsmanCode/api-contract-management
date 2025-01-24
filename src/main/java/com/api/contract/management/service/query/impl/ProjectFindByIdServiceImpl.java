package com.api.contract.management.service.query.impl;

import com.api.contract.management.base.dto.request.UniqueRequest;
import com.api.contract.management.base.dto.response.ErrorResponse;
import com.api.contract.management.base.exceptions.thrower.DataNotFoundException;
import com.api.contract.management.common.enums.ErrorActionResultEnum;
import com.api.contract.management.dto.query.response.ProjectResponse;
import com.api.contract.management.entity.Project;
import com.api.contract.management.repository.ProjectRepository;
import com.api.contract.management.service.query.contract.ProjectFindByIdService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProjectFindByIdServiceImpl implements ProjectFindByIdService {

    private final ProjectRepository ProjectRepository;

    @Override
    public ProjectResponse execute(UniqueRequest<UUID> request) {

        Optional<Project> checkData = ProjectRepository.findById(request.getValue());

        if (checkData.isEmpty()) {
            String message = "Project not found";
            throw new DataNotFoundException(message, Collections.singletonList(
                    ErrorResponse.builder()
                            .code(ErrorActionResultEnum.NOT_FOUND.getCode())
                            .field("id")
                            .message(ErrorActionResultEnum.NOT_FOUND.getMessage())
                            .build()
            ));
        }
        Project data = checkData.get();

        return buildResponse(data);
    }

    private ProjectResponse buildResponse(Project data) {
        return ProjectResponse.builder()
                .id(data.getId())
                .name(data.getName())
                .title(data.getTitle())
                .entity(data)
                .build();
    }
}
