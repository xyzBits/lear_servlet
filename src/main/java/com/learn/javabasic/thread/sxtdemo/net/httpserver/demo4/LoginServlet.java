package com.learn.javabasic.thread.sxtdemo.net.httpserver.demo4;

public class LoginServlet extends Servlet {

    @Override
    public void doGet(Request req, Response rep) throws Exception {
/*        rep.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>HTTP响应示例</title>\n" +
                "</head>\n" +
                "<body>\n");
        rep.println( "Hello " + req.getParameter("uname") + "\n");

        rep.println("</body>\n" +
                "</html>");*/

        String name = req.getParameter("uname");
        String pwd = req.getParameter("pwd");

        if (login(name, pwd)) {
            rep.println("login succeed");
        } else {
            rep.println("login failed");
        }
    }

    private boolean login(String name, String pwd) {
        return name.equals("bjsxt") && pwd.equals("123456");
    }

    @Override
    public void doPost(Request req, Response rep) throws Exception {

    }
}
