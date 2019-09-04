package com.learn.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstController {

    @RequestMapping("/handle01")
    public String handle01() {
        return "success";
    }
}
