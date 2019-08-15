package com.learn.javabasic.thread.sxtdemo.net.httpserver.demo4;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

public class WebApp {
    private static ServletContext context;

    static {
/*        context = new ServletContext();
        Map<String, String> mapping = context.getMapping();
        mapping.put("/login", "Login");
        mapping.put("/log", "Login");
        mapping.put("/reg", "Register");

        Map<String, String> servlet = context.getServlet();
        servlet.put("Login", "com.google.learn.javabasic.thread.sxtdemo.net.httpserver.demo3.LoginServlet");
        servlet.put("Register", "com.google.learn.javabasic.thread.sxtdemo.net.httpserver.demo3.RegisterServlet");*/

        try {
            // 获取解析工厂
            SAXParserFactory factory = SAXParserFactory.newInstance();

            // 获取解析器
            SAXParser sax = factory.newSAXParser();

            // 指定xml + 处理器
            WebHandler webHandler = new WebHandler();
            String xmlFilePath = "D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet\\src\\main\\java\\com\\google\\learn\\javabasic\\thread\\sxtdemo\\net\\httpserver\\demo4\\web.xml";

            sax.parse(new FileInputStream(xmlFilePath),
                    webHandler);


            context = new ServletContext();

            Map<String, String> servlet = context.getServlet();

            // servlet-name servlet-class
            System.out.println(webHandler.getEntities());
            for (Entity entity : webHandler.getEntities()) {
                System.out.println(entity.getServletName());
                servlet.put(entity.getServletName(), entity.getServletClass());
            }

            // url-pattern servlet-name
            Map<String, String> mapping = context.getMapping();
            for (Mapping mapp : webHandler.getMappings()) {
                List<String> urls = mapp.getUrlPatterns();
                for (String url : urls) {
                    mapping.put(url, mapp.getServletName());
                }
            }
            System.out.println("servlet ====" + servlet);
            System.out.println("mapping ====" + mapping);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Servlet getServlet(String url) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if ((url == null) || (url = url.trim()).equals("")) {
            return null;
        }
        //return context.getServlet().get(context.getMapping().get(url));
        // 根据字符 串创建对象
        System.out.println(url);
        String name = context.getServlet().get(context.getMapping().get(url));
        System.out.println(name);
        System.out.println((Servlet) Class.forName(name).newInstance());
        return (Servlet) Class.forName(name).newInstance();
    }
}
