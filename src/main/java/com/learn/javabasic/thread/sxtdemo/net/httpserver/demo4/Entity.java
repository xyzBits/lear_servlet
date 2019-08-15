package com.learn.javabasic.thread.sxtdemo.net.httpserver.demo4;

/**
 *     <servlet>
 *         <servlet-name>login</servlet-name>
 *         <servlet-class>com.google.learn.javabasic.thread.sxtdemo.net.httpserver.demo4.LoginServlet</servlet-class>
 *     </servlet>
 */
public class Entity {
    private String servletName;
    private String servletClass;

    public String getServletName() {
        return servletName;
    }

    public void setServletName(String servletName) {
        this.servletName = servletName;
    }

    public String getServletClass() {
        return servletClass;
    }

    public void setServletClass(String servletClass) {
        this.servletClass = servletClass;
    }
}
