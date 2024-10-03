package com.api.contract.management.controller.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
public class ApiContractController {
    @GetMapping("/api-contract")
    public ModelAndView doExecute(HttpServletRequest request) {
        String contextPath = request.getContextPath();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("content/swagger-editor");
        Map<String,Object> params = new HashMap<>();
        params.put("contextPath",contextPath);
        modelAndView.addAllObjects(params);
        log.debug("contextPath: {}", contextPath);
        return modelAndView;
    }

}
