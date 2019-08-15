package com.learn.javabasic.thread.sxtdemo.net.tcp.weichat.version4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


/**
 * 创建客户端： 发送数据  + 接收数据
 * 写出数据： 输出 流
 * 读取数据： 输入流
 * <p>
 * 输入流与输出 流在同一个线程，应该彼此独立， 应该独立处理
 */
public class Client {
    public static void main(String[] args) throws IOException {
/*        Socket client = new Socket("localhost", 9999);

        // 控制台输入流

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        DataInputStream dis = new DataInputStream(client.getInputStream());

        while (true) {
            String info = console.readLine();

            // 输出 流
            dos.writeUTF(info);
            dos.flush();

            // 输入流
            String msg = dis.readUTF();
            System.out.println(msg);
        }*/


        System.out.println("请输入名称： ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        if (name.equals("")) {
            return;
        }

        Socket client = new Socket("localhost", 9999);
        new Thread(new Send(client, name)).start();
        new Thread(new Receive(client)).start();

    }
}
