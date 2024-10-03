package com.api.contract.management.controller.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class DashboardController {
    @GetMapping(value = {
            "",
            "/",
            "dashboard"
    })
    public ModelAndView doExecute(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("content/dashboard");
        return modelAndView;
    }
}
