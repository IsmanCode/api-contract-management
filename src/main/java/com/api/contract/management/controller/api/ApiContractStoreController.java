package com.api.contract.management.controller.api;

import com.api.contract.management.base.command.ServiceExecutor;
import com.api.contract.management.base.controller.dto.response.BaseResponse;
import com.api.contract.management.dto.request.ApiContractPublishRequest;
import com.api.contract.management.dto.request.ApiContractStoreRequest;
import com.api.contract.management.service.contract.ApiContractPublishService;
import com.api.contract.management.service.contract.ApiContractStoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiContractStoreController {

    private final ServiceExecutor serviceExecutor;

    @PostMapping("/api-contract/store")
    public ResponseEntity doExecute(@RequestBody() @Valid ApiContractStoreRequest request) {

        var response = serviceExecutor.execute(ApiContractStoreService.class, request);
        return ResponseEntity.ok(BaseResponse.builder().data(response).build());
    }
}
