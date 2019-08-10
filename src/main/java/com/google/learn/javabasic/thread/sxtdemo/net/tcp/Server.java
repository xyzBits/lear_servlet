package com.google.learn.javabasic.thread.sxtdemo.net.tcp;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1 创建服务器 指定端口 ServerSocket(int port)
 *
 * 2 接收客户端的接连 阻塞式  https://localhost:8888/
 *
 * 3 发送数据  + 接收数据
 */
public class Server {
    public static void main(String[] args) throws IOException {
        // 1 创建服务器 指定端口 ServerSocket(int port)
        ServerSocket server = new ServerSocket(8888);

        // 2 接收客户端的接连 阻塞式
        Socket socket = server.accept();
        System.out.println("一个客户端建立连接");

        // 3 发送数据  + 接收数据
        String msg = "欢迎使用";
/*        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write(msg);
        bw.newLine();
        bw.flush();*/

        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeUTF(msg);
        dos.flush();

    }
}
