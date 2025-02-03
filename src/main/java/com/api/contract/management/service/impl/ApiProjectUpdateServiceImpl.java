package com.api.contract.management.service.impl;

import com.api.contract.management.base.command.ServiceExecutor;
import com.api.contract.management.base.dto.request.UniqueRequest;
import com.api.contract.management.dto.request.ApiProjectStoreRequest;
import com.api.contract.management.dto.request.ApiProjectUpdateRequest;
import com.api.contract.management.dto.response.ProjectResponse;
import com.api.contract.management.entity.Project;
import com.api.contract.management.entity.Team;
import com.api.contract.management.repository.ProjectRepository;
import com.api.contract.management.service.contract.ApiProjectUpdateService;
import com.api.contract.management.service.query.contract.ProjectFindByIdService;
import com.api.contract.management.service.query.contract.TeamFindByIdService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApiProjectUpdateServiceImpl implements ApiProjectUpdateService {

    private final ProjectRepository projectRepository;

    private final ServiceExecutor serviceExecutor;

    @Transactional
    @Override
    public ProjectResponse execute(ApiProjectUpdateRequest request) {
        Long now = Instant.now().toEpochMilli();
        Project Project = updateProject(request, now);
        return buildApiProjectUpdateResponse(Project);
    }

    private Project updateProject(ApiProjectUpdateRequest request, Long now) {
        Project apiProject = getProject(request);
        BeanUtils.copyProperties(request, apiProject);
        apiProject.setName(request.getName());
        apiProject.setTeam(getTeam(request));
        apiProject.setCreatedDate(now);
        apiProject.setUpdatedDate(now);
        apiProject.setCreatedBy("system");
        apiProject.setUpdatedBy("system");
        projectRepository.save(apiProject);
        return apiProject;
    }

    private ProjectResponse buildApiProjectUpdateResponse(Project Project) {
        ProjectResponse response = new ProjectResponse();
        BeanUtils.copyProperties(Project, response);
        return response;
    }

    private Project getProject(ApiProjectUpdateRequest request) {
        return serviceExecutor.execute(ProjectFindByIdService.class, UniqueRequest.<UUID>builder()
                .value(request.getId())
                .build()).getEntity();
    }

    private Team getTeam(ApiProjectUpdateRequest request) {
        return serviceExecutor.execute(TeamFindByIdService.class, UniqueRequest.<UUID>builder()
                .value(request.getTeamId())
                .build()).getEntity();
    }

}
