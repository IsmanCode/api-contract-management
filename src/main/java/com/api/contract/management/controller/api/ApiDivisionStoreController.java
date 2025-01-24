package com.api.contract.management.controller.api;

import com.api.contract.management.base.command.ServiceExecutor;
import com.api.contract.management.base.dto.response.BaseResponse;
import com.api.contract.management.common.util.ObjectMapperUtil;
import com.api.contract.management.dto.request.ApiDivisionStoreRequest;
import com.api.contract.management.service.contract.ApiDivisionStoreService;
import jakarta.validation.Valid;
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
public class ApiDivisionStoreController {

    private final ServiceExecutor serviceExecutor;

    @PostMapping("/division/store")
    public ResponseEntity doExecute(@RequestBody @Valid ApiDivisionStoreRequest request) {
        var response = serviceExecutor
                .execute(ApiDivisionStoreService.class, request);
        return ResponseEntity.ok(BaseResponse.builder()
                .data(response)
                .build()
        );
    }
}
