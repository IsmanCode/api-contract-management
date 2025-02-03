package com.api.contract.management.service.query.impl;

import com.api.contract.management.dto.query.request.TeamListRequest;
import com.api.contract.management.dto.query.response.TeamResponse;
import com.api.contract.management.entity.Team;
import com.api.contract.management.repository.TeamRepository;
import com.api.contract.management.service.query.contract.TeamListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeamListServiceImpl implements TeamListService {

    private final TeamRepository teamRepository;

    @Override
    public List<TeamResponse> execute(TeamListRequest request) {

        List<Team> teams;
        if (request.getDivisionId() != null) {
            teams = teamRepository.findByDivisionId(request.getDivisionId());
        } else {
            teams = teamRepository.findAll();
        }

        return buildResponse(teams);
    }

    private List<TeamResponse> buildResponse(List<Team> teams) {
        return teams.stream()
                .map(team -> TeamResponse.builder()
                        .id(team.getId())
                        .divisionId(team.getDivision().getId())
                        .name(team.getName())
                        .title(team.getTitle())
                        .entity(team)
                        .build())
                .toList();
    }
}
