package com.api.contract.management.service.query.impl;

import com.api.contract.management.base.dto.request.UniqueRequest;
import com.api.contract.management.base.dto.response.ErrorResponse;
import com.api.contract.management.base.exceptions.thrower.DataNotFoundException;
import com.api.contract.management.dto.query.request.ProjectDetailRequest;
import com.api.contract.management.dto.query.response.ProjectResponse;
import com.api.contract.management.entity.Project;
import com.api.contract.management.repository.ProjectRepository;
import com.api.contract.management.service.query.contract.ProjectDetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProjectDetailServiceImpl implements ProjectDetailService {

    private final ProjectRepository projectRepository;

    @Override
    public ProjectResponse execute(ProjectDetailRequest request) {

        Optional<Project> checkData = projectRepository.findByIdAndTeamId(request.getId(),request.getTeamId());

        if (!checkData.isPresent()) {
            String message = "Project not found";
            throw new DataNotFoundException(message, Arrays.asList(
                    ErrorResponse.builder()
                            .code("404")
                            .field("id")
                            .message(message)
                            .build()
            ));
        }
        Project data = checkData.get();

        return buildResponse(data);
    }

    private ProjectResponse buildResponse(Project data) {
        return ProjectResponse.builder()
                .teamId(data.getTeam().getId())
                .id(data.getId())
                .name(data.getName())
                .title(data.getTitle())
                .entity(data)
                .build();
    }
}
