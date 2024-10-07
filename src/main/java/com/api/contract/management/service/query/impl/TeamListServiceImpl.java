package com.api.contract.management.service.query.impl;

import com.api.contract.management.dto.query.request.TeamListRequest;
import com.api.contract.management.dto.query.response.TeamListResponse;
import com.api.contract.management.entity.Team;
import com.api.contract.management.repository.TeamRepository;
import com.api.contract.management.service.query.contract.TeamListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeamListServiceImpl implements TeamListService {

    private final TeamRepository teamRepository;

    @Override
    public List<TeamListResponse> execute(TeamListRequest request) {

        List<Team> teams = teamRepository.findByDivisionId(request.getDivisionId());

        return buildResponse(teams);
    }

    private List<TeamListResponse> buildResponse(List<Team> teams) {
        return teams.stream()
                .map(team -> TeamListResponse.builder()
                        .id(team.getId())
                        .divisionId(team.getDivision().getId())
                        .name(team.getName())
                        .title(team.getTitle())
                        .entity(team)
                        .build())
                .toList();
    }
}
