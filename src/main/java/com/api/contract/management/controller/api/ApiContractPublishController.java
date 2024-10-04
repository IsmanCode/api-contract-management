package com.api.contract.management.controller.api;

import com.api.contract.management.base.command.ServiceExecutor;
import com.api.contract.management.common.util.ObjectMapperUtil;
import com.api.contract.management.dto.request.ApiContractPublishRequest;
import com.api.contract.management.dto.request.ApiSwaggerStoreRequest;
import com.api.contract.management.service.contract.ApiContractPublishService;
import com.api.contract.management.service.contract.ApiSwaggerStoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiContractPublishController {

    private final ServiceExecutor serviceExecutor;

    @PatchMapping("/api-contract/publish/{id}")
    public ResponseEntity doExecute(@PathVariable("id") UUID id) {
        log.debug("id: {}", id);
        var response = serviceExecutor.execute(ApiContractPublishService.class, ApiContractPublishRequest.builder()
                        .id(id)
                .build());
        return ResponseEntity.ok(response);
    }
}
