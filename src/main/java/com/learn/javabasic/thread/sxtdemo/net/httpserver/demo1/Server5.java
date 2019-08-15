package com.learn.javabasic.thread.sxtdemo.net.httpserver.demo1;



import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 请求并响应
 */
public class Server5 {
    private ServerSocket server;
    private static final String CRLF = "\r\n";
    private static final String BLANK = " ";
    public static void main(String[] args) {
        Server5 server = new Server5();
        server.start();
    }


    /**
     * 启动方法
     *
     */
    public void start() {
        try {
            server = new  ServerSocket(8888);
            this.receive();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 停止服务器
     */
    public void stop() {

    }

    /**
     * 接收客户端
     */
    private void receive() {
        try {
            Socket client = server.accept();

            // 请求
            Request req = new Request(client.getInputStream());





            // 响应
 /*           StringBuilder responseContext = new StringBuilder();

            responseContext.append("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>HTTP响应示例</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    Hello Tomcat\n" +
                    "</body>\n" +
                    "</html>");*/

            Response rep = new Response(client.getOutputStream());
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

            rep.pushToClient(200);




        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**
 *
 */
