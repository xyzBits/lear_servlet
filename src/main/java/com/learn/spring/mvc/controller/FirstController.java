package com.learn.spring.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(value = "/hello")
@Controller
public class FirstController {
    private static final Logger LOGGER = LoggerFactory.getLogger(FirstController.class);

    @RequestMapping(value = "/handle01", params = {"username!=dongfang", "pwd", "!age"},
            headers = {"!User-Agent: Mozilla/5.0 " +
                    "(Windows NT 10.0; Win64; x64) " +
                    "AppleWebKit/537.36 (KHTML, like Gecko) " +
                    "Chrome/76.0.3809.100 Safari/537.36"})
    public String handle01() {
        return "success";
    }


    @RequestMapping("/handle02")
    public String handle02(String username) {
        System.out.println("参数名为 " + username);

        return "success";
    }

    @RequestMapping("/handle03")
    public String handle03(@RequestParam(value = "user", required = false, defaultValue = "你没带") String user,
                           @RequestHeader(value = "User-Agent", required = false, defaultValue = "请求头中没有这个参数") String userAgent,
                           @CookieValue(value ="JSESSIONID", required = false, defaultValue = "请求头中没有这个cookie") String id
    ) {
        LOGGER.info("参数名为 {}", user);

        LOGGER.info("浏览器信息为 {}", userAgent);

        LOGGER.info("JESSIONID信息为 {}", id);
        return "success";
    }


}
