package com.google.learn.javabasic.thread.sxtdemo.net.httpserver.demo1;



import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 请求并响应
 */
public class Server4 {
    private ServerSocket server;
    private static final String CRLF = "\r\n";
    private static final String BLANK = " ";
    public static void main(String[] args) {
        Server4 server = new Server4();
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

            byte[] data = new byte[1024 * 1024 * 2];
            int len = client.getInputStream().read(data);

            // 接收客户端请求信息
            String requestInfo = new String(data, 0, len).trim();
            System.out.println(requestInfo);

            // 响应
            StringBuilder responseContext = new StringBuilder();

            responseContext.append("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>HTTP响应示例</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    Hello Tomcat\n" +
                    "</body>\n" +
                    "</html>");

            Response rep = new Response(client.getOutputStream());
            rep.println(responseContext.toString());
            rep.pushToClient(404);




        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**
 *
 */
