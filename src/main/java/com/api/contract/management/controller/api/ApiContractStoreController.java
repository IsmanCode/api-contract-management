package com.api.contract.management.controller.api;

import com.api.contract.management.base.command.ServiceExecutor;
import com.api.contract.management.base.controller.dto.response.BaseResponse;
import com.api.contract.management.dto.request.ApiContractPublishRequest;
import com.api.contract.management.dto.request.ApiContractStoreRequest;
import com.api.contract.management.service.contract.ApiContractPublishService;
import com.api.contract.management.service.contract.ApiContractStoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.UUID;

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
