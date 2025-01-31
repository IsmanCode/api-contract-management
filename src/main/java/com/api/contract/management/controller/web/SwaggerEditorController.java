package com.api.contract.management.controller.web;

import com.api.contract.management.base.command.ServiceExecutor;
import com.api.contract.management.common.util.ObjectMapperUtil;
import com.api.contract.management.dto.request.ApiSwaggerUIRequest;
import com.api.contract.management.service.contract.ApiSwaggerUIService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Controller
@RequiredArgsConstructor
public class SwaggerEditorController {

    private final ServiceExecutor serviceExecutor;

    @GetMapping("/swagger-editor/{id}")
    public ModelAndView doExecute(@PathVariable("id") UUID id,
                                  HttpServletRequest request) {
        String contextPath = request.getContextPath();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("content/swagger-editor");

        var response = serviceExecutor.execute(ApiSwaggerUIService.class, ApiSwaggerUIRequest.builder()
                        .id(id)
                .build());

        String yamlSpec="";
        if (response.getOpenApiSpec() != null && !response.getOpenApiSpec().isEmpty()) {
            String jsonSpec = ObjectMapperUtil.convertToString(response.getOpenApiSpec());
            log.debug("jsonSpec: {}", jsonSpec);
            yamlSpec = ObjectMapperUtil.convertJsonToYaml(jsonSpec);
            log.debug("yamlSpec: {}", yamlSpec);
        }
        Map<String,Object> params = new HashMap<>();
        params.put("id",id);
        params.put("swaggerEditorSpec",yamlSpec);
        params.put("contextPath",contextPath);
        modelAndView.addAllObjects(params);
        log.debug("contextPath: {}", contextPath);
        return modelAndView;
    }

}
