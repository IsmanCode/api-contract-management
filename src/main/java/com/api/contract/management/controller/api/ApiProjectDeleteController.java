package com.api.contract.management.controller.api;

import com.api.contract.management.base.command.ServiceExecutor;
import com.api.contract.management.base.dto.response.BaseResponse;
import com.api.contract.management.dto.request.ApiProjectDeleteRequest;
import com.api.contract.management.service.contract.ApiProjectDeleteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiProjectDeleteController {

    private final ServiceExecutor serviceExecutor;

    @DeleteMapping("/project/delete/{id}")
    public ResponseEntity doExecute(@PathVariable("id") UUID id) {
        var response = serviceExecutor
                .execute(ApiProjectDeleteService.class, ApiProjectDeleteRequest.builder()
                        .id(id)
                        .build());
        return ResponseEntity.ok(BaseResponse.builder()
                .data(response)
                .build()
        );
    }
}
