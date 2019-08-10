package com.google.learn.javabasic.thread.sxtdemo.net.httpserver.demo1;



import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 请求并响应
 */
public class Server6 {
    private ServerSocket server;
    private static final String CRLF = "\r\n";
    private static final String BLANK = " ";
    public static void main(String[] args) {
        Server6 server = new Server6();
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
            Request req = new Request(client.getInputStream());
            Response rep = new Response(client.getOutputStream());
            Servlet serv = new Servlet();
            serv.service(req, rep);

            rep.pushToClient(200);



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**
 *
 */
