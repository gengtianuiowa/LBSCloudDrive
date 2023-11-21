package com.qta.be.server.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class MainController {
    // 将注册页映射到静态资源下。
    @GetMapping({"/test"})
    public String mapping() {
        return "index";
    }
}
