package com.api.contract.management.controller.api;

import com.api.contract.management.base.command.ServiceExecutor;
import com.api.contract.management.dto.datatable.DataTableRequest;
import com.api.contract.management.dto.datatable.DataTableResults;
import com.api.contract.management.service.contract.ApiContractDatatablesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiContractDatatablesController {

    private final ServiceExecutor serviceExecutor;

    @GetMapping(value = "/api-contract/datatables")
    public DataTableResults doExecute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        log.debug("dataTables: {}", httpServletRequest.getRequestURI());
        DataTableRequest request = new DataTableRequest(httpServletRequest);
        return serviceExecutor.execute(ApiContractDatatablesService.class,request);
    }

}
