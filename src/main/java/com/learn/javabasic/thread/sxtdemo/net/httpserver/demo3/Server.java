package com.learn.javabasic.thread.sxtdemo.net.httpserver.demo3;


import com.learn.javabasic.thread.sxtdemo.net.tcp.weichat.version2.CloseUtil;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * 请求并响应
 */
public class Server {
    private ServerSocket server;
    private static final String CRLF = "\r\n";
    private static final String BLANK = " ";
    private boolean isShutDown = false;
    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }


    public void start() {
        start(8888);
    }

    /**
     * 启动方法
     *
     */
    public void start(int port) {
        try {
            server = new  ServerSocket(port);
            this.receive();
        } catch (IOException e) {
            stop();
            //e.printStackTrace();
        }
    }

    /**
     * 停止服务器
     */
    public void stop() {
        isShutDown = true;
        CloseUtil.closeSocket(server);
    }

    /**
     * 接收客户端
     */
    private void receive() {
        try {
            while (!isShutDown) {
                new Thread(new Dispatcher(server.accept())).start();
            }

        } catch (IOException e) {
            stop();
            //e.printStackTrace();
        }
    }
}

/**
 *
 */
