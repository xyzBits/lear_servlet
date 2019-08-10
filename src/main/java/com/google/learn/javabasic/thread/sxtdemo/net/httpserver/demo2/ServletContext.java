package com.google.learn.javabasic.thread.sxtdemo.net.httpserver.demo2;

import java.util.HashMap;
import java.util.Map;

public class ServletContext {
    // 为每一个servlet取个别名
    // login LoginServlet
    private Map<String, Servlet> servlet;

    // url ----> login
    /**
     * /log --> login
     * /login --> login
     * 一个资源让多个路径访问
     */
    private Map<String, String> mapping;

    public ServletContext() {
        this.servlet = new HashMap<>();
        this.mapping = new HashMap<>();
    }

    public Map<String, Servlet> getServlet() {
        return servlet;
    }

    public void setServlet(Map<String, Servlet> servlet) {
        this.servlet = servlet;
    }

    public Map<String, String> getMapping() {
        return mapping;
    }

    public void setMapping(Map<String, String> mapping) {
        this.mapping = mapping;
    }
}
