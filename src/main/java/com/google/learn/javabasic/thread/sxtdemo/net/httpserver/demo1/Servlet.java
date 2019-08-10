package com.google.learn.javabasic.thread.sxtdemo.net.httpserver.demo1;

public class Servlet {
    public void service(Request req, Response rep) {
        rep.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>HTTP响应示例</title>\n" +
                "</head>\n" +
                "<body>\n");
        rep.println( "Hello " + req.getParameter("uname") + "\n");

        rep.println("</body>\n" +
                "</html>");
    }
}
