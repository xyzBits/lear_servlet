package com.google.learn.javabasic.thread.sxtdemo.net.httpserver.demo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket server;
    public static void main(String[] args) {
        Server server = new Server();
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

            StringBuilder sb = new StringBuilder();
            String msg = null;

            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));

            while ((msg = br.readLine()) != null) {
                sb.append(msg);
                sb.append("\r\n");
            }
            //System.out.println(sb.toString());

            // 接收客户端请求信息
            String requestInfo = sb.toString().trim();
            System.out.println(requestInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
