package com.api.contract.management.controller.api;

import com.api.contract.management.base.command.ServiceExecutor;
import com.api.contract.management.dto.request.ApiSwaggerUIRequest;
import com.api.contract.management.service.contract.ApiSwaggerUIService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiSwaggerUIController {

    private final ServiceExecutor serviceExecutor;

    @GetMapping(value = "/swagger-ui/{id}")
    public ResponseEntity doExecute(@PathVariable("id") UUID id,
                                    HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        log.debug("dataTables: {}", httpServletRequest.getRequestURI());

        var response = serviceExecutor.execute(ApiSwaggerUIService.class, ApiSwaggerUIRequest.builder()
                        .id(id)
                .build());
        return ResponseEntity.ok(response.getOpenApiSpec());
    }

}
