package com.api.contract.management.service.impl;

import com.api.contract.management.base.command.ServiceExecutor;
import com.api.contract.management.base.dto.request.UniqueRequest;
import com.api.contract.management.dto.request.ApiTeamUpdateRequest;
import com.api.contract.management.dto.response.TeamResponse;
import com.api.contract.management.entity.Division;
import com.api.contract.management.entity.Team;
import com.api.contract.management.repository.TeamRepository;
import com.api.contract.management.service.contract.ApiTeamUpdateService;
import com.api.contract.management.service.query.contract.DivisionFindByIdService;
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
public class ApiTeamUpdateServiceImpl implements ApiTeamUpdateService {

    private final TeamRepository teamRepository;
    
    private final ServiceExecutor serviceExecutor;

    @Transactional
    @Override
    public TeamResponse execute(ApiTeamUpdateRequest request) {
        Long now = Instant.now().toEpochMilli();
        Team team = updateTeam(request, now);
        return buildApiTeamUpdateResponse(team);
    }

    private Team updateTeam(ApiTeamUpdateRequest request, Long now) {
        Team apiTeam =getTeam(request);
        BeanUtils.copyProperties(request, apiTeam);
        apiTeam.setDivision(getDivision(request));
        apiTeam.setName(request.getName());
        apiTeam.setCreatedDate(now);
        apiTeam.setUpdatedDate(now);
        apiTeam.setCreatedBy("system");
        apiTeam.setUpdatedBy("system");
        teamRepository.save(apiTeam);
        return apiTeam;
    }

    private TeamResponse buildApiTeamUpdateResponse(Team team) {
        TeamResponse response = new TeamResponse();
        BeanUtils.copyProperties(team, response);
        return response;
    }

    private Division getDivision(ApiTeamUpdateRequest request) {
        return serviceExecutor.execute(DivisionFindByIdService.class, UniqueRequest.<UUID>builder()
                .value(request.getDivisionId())
                .build()).getEntity();
    }

    private Team getTeam(ApiTeamUpdateRequest request) {
        return serviceExecutor.execute(TeamFindByIdService.class, UniqueRequest.<UUID>builder()
                .value(request.getId())
                .build()).getEntity();
    }

}
