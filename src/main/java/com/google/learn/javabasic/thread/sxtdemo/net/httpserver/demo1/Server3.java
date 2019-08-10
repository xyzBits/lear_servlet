package com.google.learn.javabasic.thread.sxtdemo.net.httpserver.demo1;



import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.BlockingDeque;

/**
 * 请求并响应
 */
public class Server3 {
    private ServerSocket server;
    private static final String CRLF = "\r\n";
    private static final String BLANK = " ";
    public static void main(String[] args) {
        Server3 server = new Server3();
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

            StringBuilder response = new StringBuilder();
            // 1 HTTP协议的版本 状态码 描述
            response.append("HTTP/1.1").append(BLANK).append("200").append(BLANK).append("OK").append(CRLF);

            // 2 头信息 响应头
            response.append("Server:bjsxt Server/0.0.1").append(CRLF);
            response.append("Date:").append(new Date()).append(CRLF);
            response.append("Content-type:text/html;charset=GBK").append(CRLF);

            //正文长度
            response.append("Content-Length:").append(responseContext.toString().getBytes().length).append(CRLF);

            // 3 正文之前
            response.append(CRLF);

            // 4 正文
            response.append(responseContext);

            // 输出 流
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            bw.write(response.toString());
            bw.flush();
            bw.close();



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**
 *
 */
