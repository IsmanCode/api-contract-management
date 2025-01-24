package com.api.contract.management.controller.api;

import com.api.contract.management.base.command.ServiceExecutor;
import com.api.contract.management.base.dto.response.BaseResponse;
import com.api.contract.management.dto.request.ApiTeamStoreRequest;
import com.api.contract.management.service.contract.ApiTeamStoreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiTeamStoreController {

    private final ServiceExecutor serviceExecutor;

    @PostMapping("/team/store")
    public ResponseEntity doExecute(@RequestBody @Valid ApiTeamStoreRequest request) {
        var response = serviceExecutor
                .execute(ApiTeamStoreService.class, request);
        return ResponseEntity.ok(BaseResponse.builder()
                .data(response)
                .build()
        );
    }
}
