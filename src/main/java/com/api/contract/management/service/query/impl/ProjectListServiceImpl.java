package com.api.contract.management.service.query.impl;

import com.api.contract.management.dto.query.request.ProjectListRequest;
import com.api.contract.management.dto.query.response.ProjectResponse;
import com.api.contract.management.entity.Project;
import com.api.contract.management.repository.ProjectRepository;
import com.api.contract.management.service.query.contract.ProjectListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProjectListServiceImpl implements ProjectListService {

    private final ProjectRepository projectRepository;

    @Override
    public List<ProjectResponse> execute(ProjectListRequest request) {

        List<Project> projects;
        if (request.getProjectId() != null) {
            projects = projectRepository.findByTeamId(request.getProjectId());
        } else {
            projects = projectRepository.findAll();
        }

        return buildResponse(projects);
    }

    private List<ProjectResponse> buildResponse(List<Project> projects) {
        return projects.stream()
                .map(project -> ProjectResponse.builder()
                        .id(project.getId())
                        .teamId(project.getTeam().getId())
                        .name(project.getName())
                        .title(project.getTitle())
                        .entity(project)
                        .build())
                .toList();
    }
}
