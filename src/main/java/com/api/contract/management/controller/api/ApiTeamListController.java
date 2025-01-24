package com.api.contract.management.controller.api;

import com.api.contract.management.base.command.ServiceExecutor;
import com.api.contract.management.base.dto.response.BaseResponse;
import com.api.contract.management.dto.query.request.TeamListRequest;
import com.api.contract.management.service.query.contract.TeamListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiTeamListController {

    private final ServiceExecutor serviceExecutor;

    @GetMapping(value = "/team/list/{divisionId}")
    public ResponseEntity doExecute(@PathVariable("divisionId") String divisionId) {

        var response = serviceExecutor.execute(TeamListService.class, TeamListRequest.builder()
                        .divisionId(UUID.fromString(divisionId))
                .build());
        return ResponseEntity.ok(BaseResponse
                .builder()
                .data(response)
                .build());
    }

}
