package com.google.learn.javabasic.thread.sxtdemo.net.httpserver.demo4;

import java.util.ArrayList;
import java.util.List;

/**
 *     <servlet-mapping>
 *         <servlet-name>login</servlet-name>
 *         <url-pattern>/log</url-pattern>
 *     </servlet-mapping>
 */
public class Mapping {
    private String servletName;
    private List<String> urlPatterns;

    public Mapping() {
        urlPatterns = new ArrayList<>();
    }

    public String getServletName() {
        return servletName;
    }

    public void setServletName(String servletName) {
        this.servletName = servletName;
    }

    public List<String> getUrlPatterns() {
        return urlPatterns;
    }

    public void setUrlPatterns(List<String> urlPatterns) {
        this.urlPatterns = urlPatterns;
    }
}
