package com.api.contract.management.controller.api;

import com.api.contract.management.base.command.ServiceExecutor;
import com.api.contract.management.base.dto.response.BaseResponse;
import com.api.contract.management.dto.request.ApiDivisionStoreRequest;
import com.api.contract.management.dto.request.ApiDivisionUpdateRequest;
import com.api.contract.management.service.contract.ApiDivisionUpdateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiDivisionUpdateController {

    private final ServiceExecutor serviceExecutor;

    @PutMapping("/division/update")
    public ResponseEntity doExecute(@RequestBody @Valid ApiDivisionUpdateRequest request) {
        var response = serviceExecutor
                .execute(ApiDivisionUpdateService.class, request);
        return ResponseEntity.ok(BaseResponse.builder()
                .data(response)
                .build()
        );
    }
}
