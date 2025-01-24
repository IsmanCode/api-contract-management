package com.api.contract.management.controller.api;

import com.api.contract.management.base.command.ServiceExecutor;
import com.api.contract.management.base.dto.response.BaseResponse;
import com.api.contract.management.dto.query.request.ProjectListRequest;
import com.api.contract.management.service.query.contract.ProjectListService;
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
public class ApiProjectListController {

    private final ServiceExecutor serviceExecutor;

    @GetMapping(value = "/project/list/{teamId}")
    public ResponseEntity doExecute(@PathVariable("teamId") String teamId) {

        var response = serviceExecutor.execute(ProjectListService.class, ProjectListRequest.builder()
                        .teamId(UUID.fromString(teamId))
                .build());
        return ResponseEntity.ok(BaseResponse
                .builder()
                .data(response)
                .build());
    }

}
