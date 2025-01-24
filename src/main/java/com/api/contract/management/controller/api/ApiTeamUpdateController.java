package com.api.contract.management.controller.api;

import com.api.contract.management.base.command.ServiceExecutor;
import com.api.contract.management.base.dto.response.BaseResponse;
import com.api.contract.management.dto.request.ApiTeamUpdateRequest;
import com.api.contract.management.service.contract.ApiTeamUpdateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiTeamUpdateController {

    private final ServiceExecutor serviceExecutor;

    @PutMapping("/team/update")
    public ResponseEntity doExecute(@RequestBody @Valid ApiTeamUpdateRequest request) {
        var response = serviceExecutor
                .execute(ApiTeamUpdateService.class, request);
        return ResponseEntity.ok(BaseResponse.builder()
                .data(response)
                .build()
        );
    }
}
