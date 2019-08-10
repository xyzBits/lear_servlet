package com.google.learn.javabasic.thread.sxtdemo.net.httpserver.demo2;

public class RegisterServlet extends Servlet {
    @Override
    public void doGet(Request req, Response rep) throws Exception {
        rep.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>welcome to back</title>\n" +
                "</head>\n" +
                "<body>\n");
        rep.println("Your name is  " + req.getParameter("uname") + "\n");

        rep.println("</body>\n" +
                "</html>");
    }

    @Override
    public void doPost(Request req, Response rep) throws Exception {

    }
}
