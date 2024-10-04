package com.api.contract.management.controller.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Controller
public class SwaggerUIController {
    @GetMapping("/swagger-ui/{id}")
    public ModelAndView doExecute(@PathVariable("id") UUID id,
                                  HttpServletRequest request) {
        String contextPath = request.getContextPath();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("content/swagger-ui");
        Map<String,Object> params = new HashMap<>();
        params.put("contextPath",contextPath);
        params.put("id",id);
        modelAndView.addAllObjects(params);
        log.debug("contextPath: {} id: {}", contextPath,id);
        return modelAndView;
    }
}
