package com.api.contract.management.service.impl;

import com.api.contract.management.base.command.ServiceExecutor;
import com.api.contract.management.base.dto.request.UniqueRequest;
import com.api.contract.management.dto.request.ApiDivisionUpdateRequest;
import com.api.contract.management.dto.request.ApiTeamStoreRequest;
import com.api.contract.management.dto.response.TeamResponse;
import com.api.contract.management.entity.Division;
import com.api.contract.management.entity.Division;
import com.api.contract.management.entity.Team;
import com.api.contract.management.repository.TeamRepository;
import com.api.contract.management.service.contract.ApiTeamStoreService;
import com.api.contract.management.service.query.contract.DivisionFindByIdService;
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
public class ApiTeamStoreServiceImpl implements ApiTeamStoreService {

    private final TeamRepository TeamRepository;
    
    private final ServiceExecutor serviceExecutor;

    @Transactional
    @Override
    public TeamResponse execute(ApiTeamStoreRequest request) {
        Long now = Instant.now().toEpochMilli();
        Team Team = storeTeam(request, now);
        return buildApiTeamStoreResponse(Team);
    }

    private Team storeTeam(ApiTeamStoreRequest request, Long now) {
        Team apiTeam = new Team();
        BeanUtils.copyProperties(request, apiTeam);
        apiTeam.setDivision(getDivision(request));
        apiTeam.setName(request.getName());
        apiTeam.setCreatedDate(now);
        apiTeam.setUpdatedDate(now);
        apiTeam.setCreatedBy("system");
        apiTeam.setUpdatedBy("system");
        TeamRepository.save(apiTeam);
        return apiTeam;
    }

    private TeamResponse buildApiTeamStoreResponse(Team Team) {
        TeamResponse response = new TeamResponse();
        BeanUtils.copyProperties(Team, response);
        return response;
    }

    private Division getDivision(ApiTeamStoreRequest request) {
        return serviceExecutor.execute(DivisionFindByIdService.class, UniqueRequest.<UUID>builder()
                .value(request.getDivisionId())
                .build()).getEntity();
    }

}
