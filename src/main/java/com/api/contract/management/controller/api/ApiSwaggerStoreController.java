package com.api.contract.management.controller.api;

import com.api.contract.management.base.command.ServiceExecutor;
import com.api.contract.management.common.util.ObjectMapperUtil;
import com.api.contract.management.dto.request.ApiSwaggerStoreRequest;
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
public class ApiSwaggerStoreController {

    private final ServiceExecutor serviceExecutor;

    @PostMapping("/swagger-store/{id}")
    public ResponseEntity doExecute(@RequestBody String jsonSpec, @PathVariable("id") UUID id) {
        log.debug("swagger-store id: {}", id);
        Map<String,Object> map = ObjectMapperUtil.convertToObject(jsonSpec,Map.class);
        var response = serviceExecutor.execute(ApiSwaggerStoreService.class, ApiSwaggerStoreRequest.builder()
                        .id(id)
                        .openApiSpec(map)
                .build());
        return ResponseEntity.ok(response);
    }
}
