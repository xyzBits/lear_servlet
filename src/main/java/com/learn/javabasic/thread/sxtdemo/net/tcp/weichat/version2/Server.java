package com.learn.javabasic.thread.sxtdemo.net.tcp.weichat.version2;

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
 /*       ServerSocket server = new ServerSocket(9999);

        Socket client = server.accept();


        // 输入流
        DataInputStream dis = new DataInputStream(client.getInputStream());
        String msg = dis.readUTF();
        System.out.println(msg);


        // 输出 流
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF("服务器 ---> " + msg);
        dos.flush();*/

        ServerSocket server = new ServerSocket(9999);

        // 服务一个客户端的时候，其他的只能等待
        while (true) {
            Socket client = server.accept();
            DataInputStream dis = new DataInputStream(client.getInputStream());
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());

            while (true) {
                String msg = dis.readUTF();
                System.out.println(msg);

                dos.writeUTF("服务器 ---> " + msg);
                dos.flush();
            }

        }


    }
}
