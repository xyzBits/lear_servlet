package com.google.learn.javabasic.thread.sxtdemo.net.httpserver.demo1;

import com.google.learn.javabasic.thread.sxtdemo.net.tcp.weichat.version2.CloseUtil;

import java.awt.image.RescaleOp;
import java.io.IOException;
import java.net.Socket;

/**
 * 一个请求响应就是一个此对象
 */
public class Dispatcher implements Runnable {
    private Request req;
    private Response rep;
    private Socket client;
    private int code = 200;

    public Dispatcher(Socket client) {
        this.client = client;
        try {
            req = new Request(client.getInputStream());
            rep = new Response(client.getOutputStream());
        } catch (IOException e) {
            //e.printStackTrace();
            code = 500;
            return;
        }

    }

    @Override
    public void run() {
        Servlet serv = new Servlet();
        serv.service(req, rep);

        try {
            rep.pushToClient(code); // 推送到客户端
        } catch (IOException e) {
            //e.printStackTrace();
        }

        try {
            rep.pushToClient(500);
        } catch (IOException e) {
            e.printStackTrace();
        }
        CloseUtil.closeSocket(client);
    }
}
