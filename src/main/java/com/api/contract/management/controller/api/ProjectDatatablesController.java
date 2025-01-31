package com.api.contract.management.controller.api;

import com.api.contract.management.base.command.ServiceExecutor;
import com.api.contract.management.dto.datatable.DataTableRequest;
import com.api.contract.management.dto.datatable.DataTableResults;
import com.api.contract.management.service.contract.ProjectDatatablesService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProjectDatatablesController {

    private final ServiceExecutor serviceExecutor;

    @GetMapping(value = "/project/datatables")
    public DataTableResults doExecute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        log.debug("dataTables: {}", httpServletRequest.getRequestURI());
        DataTableRequest request = new DataTableRequest(httpServletRequest);
        return serviceExecutor.execute(ProjectDatatablesService.class,request);
    }

}
