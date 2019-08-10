package com.google.learn.javabasic.thread.sxtdemo.net.tcp.weichat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建客户端： 发送数据  + 接收数据
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9999);

        Socket client = server.accept();


        // 输入流
        DataInputStream dis = new DataInputStream(client.getInputStream());
        String msg = dis.readUTF();
        System.out.println(msg);


        // 输出 流
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF("服务器 ---> " + msg);
        dos.flush();



    }
}
