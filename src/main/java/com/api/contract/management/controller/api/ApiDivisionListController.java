package com.api.contract.management.controller.api;

import com.api.contract.management.base.command.ServiceExecutor;
import com.api.contract.management.base.dto.response.BaseResponse;
import com.api.contract.management.dto.query.request.DivisionListRequest;
import com.api.contract.management.service.query.contract.DivisionListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiDivisionListController {

    private final ServiceExecutor serviceExecutor;

    @GetMapping(value = "/division/list")
    public ResponseEntity doExecute() {

        var response = serviceExecutor.execute(DivisionListService.class, new DivisionListRequest());
        return ResponseEntity.ok(BaseResponse
                .builder()
                .data(response)
                .build());
    }

}
