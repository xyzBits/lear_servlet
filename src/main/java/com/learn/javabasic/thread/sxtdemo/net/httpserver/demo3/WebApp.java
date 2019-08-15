package com.learn.javabasic.thread.sxtdemo.net.httpserver.demo3;


import java.util.Map;

public class WebApp {
    private static ServletContext context;
    static {
        context = new ServletContext();
        Map<String, String> mapping = context.getMapping();
        mapping.put("/login", "Login");
        mapping.put("/log", "Login");
        mapping.put("/reg", "Register");

        Map<String, String> servlet = context.getServlet();
        servlet.put("Login", "com.google.learn.javabasic.thread.sxtdemo.net.httpserver.demo3.LoginServlet");
        servlet.put("Register", "com.google.learn.javabasic.thread.sxtdemo.net.httpserver.demo3.RegisterServlet");

    }

    public static Servlet getServlet(String url) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if ((url == null) || (url = url.trim()).equals("")) {
            return null;
        }
        //return context.getServlet().get(context.getMapping().get(url));
        // 根据字符 串创建对象
        String name = context.getServlet().get(context.getMapping().get(url));
        return (Servlet) Class.forName(name).newInstance();
    }
}
