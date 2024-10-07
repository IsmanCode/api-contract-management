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

    private final ProjectRepository teamRepository;

    @Override
    public List<ProjectResponse> execute(ProjectListRequest request) {

        List<Project> teams = teamRepository.findByTeamId(request.getTeamId());

        return buildResponse(teams);
    }

    private List<ProjectResponse> buildResponse(List<Project> teams) {
        return teams.stream()
                .map(team -> ProjectResponse.builder()
                        .id(team.getId())
                        .teamId(team.getTeam().getId())
                        .name(team.getName())
                        .title(team.getTitle())
                        .entity(team)
                        .build())
                .toList();
    }
}
