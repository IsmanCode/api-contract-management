package com.api.contract.management.controller.api;

import com.api.contract.management.base.command.ServiceExecutor;
import com.api.contract.management.base.dto.response.BaseResponse;
import com.api.contract.management.dto.request.ApiDivisionDeleteRequest;
import com.api.contract.management.dto.request.ApiDivisionUpdateRequest;
import com.api.contract.management.service.contract.ApiDivisionDeleteService;
import com.api.contract.management.service.contract.ApiDivisionUpdateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiDivisionDeleteController {

    private final ServiceExecutor serviceExecutor;

    @DeleteMapping("/division/delete/{id}")
    public ResponseEntity doExecute(@PathVariable("id") UUID id) {
        var response = serviceExecutor
                .execute(ApiDivisionDeleteService.class, ApiDivisionDeleteRequest.builder()
                        .id(id)
                        .build());
        return ResponseEntity.ok(BaseResponse.builder()
                .data(response)
                .build()
        );
    }
}
