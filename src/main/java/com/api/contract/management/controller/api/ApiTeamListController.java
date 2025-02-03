package com.api.contract.management.controller.api;

import com.api.contract.management.base.command.ServiceExecutor;
import com.api.contract.management.base.dto.response.BaseResponse;
import com.api.contract.management.dto.query.request.TeamListRequest;
import com.api.contract.management.service.query.contract.TeamListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiTeamListController {

    private final ServiceExecutor serviceExecutor;

    @GetMapping(value = "/team/list")
    public ResponseEntity doExecute(@RequestParam(value = "divisionId",required = false) String divisionId) {

        var response = serviceExecutor.execute(TeamListService.class, TeamListRequest.builder()
                        .divisionId(
                                Optional.ofNullable(divisionId)
                                        .map(UUID::fromString)
                                        .orElse(null)
                        )
                .build());
        return ResponseEntity.ok(BaseResponse
                .builder()
                .data(response)
                .build());
    }

}
