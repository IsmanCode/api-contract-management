package com.api.contract.management.controller.web;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
public class DivisionController {
    @GetMapping("/division")
    public ModelAndView doExecute(HttpServletRequest request) {
        String contextPath = request.getContextPath();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("content/division");
        Map<String,Object> params = new HashMap<>();
        params.put("contextPath",contextPath);
        modelAndView.addAllObjects(params);
        return modelAndView;
    }

}
