package com.learn.javabasic.thread.sxtdemo.net.tcp.weichat.version4;

import com.google.learn.javabasic.thread.sxtdemo.net.tcp.weichat.version2.CloseUtil;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Send implements Runnable {
    // 控制台输入流
    private BufferedReader console;

    // 管道输出流
    private DataOutputStream dos;

    // 线程控制
    private boolean isRunning = true;

    private String name;

    public Send() {
        console = new BufferedReader(new InputStreamReader(System.in));
    }

    public Send(Socket client, String name) {
        this();
        try {
            dos = new DataOutputStream(client.getOutputStream());
            this.name = name;
            send(this.name);
        } catch (IOException e) {
            isRunning = false;
            //e.printStackTrace(); 初始化出现异常，关闭流
            CloseUtil.closeAll(dos, console);
        }
    }

    @Override
    public void run() {
        while (isRunning) {
            send(getMsgFromConsole());
        }
    }

    // 1 从控制台接收数据
    private String getMsgFromConsole() {
        try {
            return console.readLine();
        } catch (IOException e) {
            //e.printStackTrace();
        }
        return "";
    }

    /**
     * 1 从控制台接收数据
     * 2 发送数据
     */
    private void send(String msg) {
        //String msg = getMsgFromConsole();
        if ((msg != null) && (!msg.equals(""))) {
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                //e.printStackTrace();
                isRunning = false;
                CloseUtil.closeAll(dos, console);
            }
        }
    }


}