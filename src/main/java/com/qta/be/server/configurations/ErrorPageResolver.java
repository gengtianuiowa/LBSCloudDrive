package com.qta.be.server.configurations;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ErrorPageResolver implements ErrorViewResolver {
    @Override
    public ModelAndView resolveErrorView(
            HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
        return new ModelAndView("redirect:/index", new HashMap<>());
    }
}
