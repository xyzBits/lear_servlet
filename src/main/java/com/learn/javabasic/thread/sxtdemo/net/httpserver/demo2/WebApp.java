package com.learn.javabasic.thread.sxtdemo.net.httpserver.demo2;

import java.util.Map;

public class WebApp {
    private static ServletContext context;
    static {
        context = new ServletContext();
        Map<String, String> mapping = context.getMapping();
        mapping.put("/login", "Login");
        mapping.put("/log", "Login");
        mapping.put("/reg", "Register");

        Map<String, Servlet> servlet = context.getServlet();
        servlet.put("Login", new LoginServlet());
        servlet.put("Register", new RegisterServlet());

    }

    public static Servlet getServlet(String url) {
        if ((url == null) || (url = url.trim()).equals("")) {
            return null;
        }
        return context.getServlet().get(context.getMapping().get(url));
    }
}
