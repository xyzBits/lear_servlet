package com.google.learn.javabasic.thread.sxtdemo.net.httpserver.demo4;

import com.google.learn.javabasic.thread.sxtdemo.net.tcp.weichat.version2.CloseUtil;

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
        try {
            Servlet serv = WebApp.getServlet(req.getUrl());
            if (serv == null) {
                this.code = 404;
            } else {
                serv.service(req, rep);
            }

            rep.pushToClient(code); // 推送到客户端
        } catch (Exception e) {
            e.printStackTrace();
            this.code = 500;
        }

        try {
            rep.pushToClient(500);
        } catch (IOException e) {
            e.printStackTrace();
        }
        CloseUtil.closeSocket(client);
    }
}
