package com.api.contract.management.controller.api;

import com.api.contract.management.base.command.ServiceExecutor;
import com.api.contract.management.base.dto.response.BaseResponse;
import com.api.contract.management.dto.request.ApiContractStoreRequest;
import com.api.contract.management.service.contract.ApiContractStoreService;
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
public class ApiContractStoreController {

    private final ServiceExecutor serviceExecutor;

    @PostMapping("/api-contract/store")
    public ResponseEntity doExecute(@RequestBody() @Valid ApiContractStoreRequest request){

        String redirectUrl = "/swagger-editor/";
        var response = serviceExecutor.execute(ApiContractStoreService.class, request);
        response.setUri(redirectUrl + response.getId());

        return ResponseEntity.ok(BaseResponse.builder()
                .data(response)
                .build());
    }
}
