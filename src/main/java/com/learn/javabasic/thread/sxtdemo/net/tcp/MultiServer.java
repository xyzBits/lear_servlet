package com.learn.javabasic.thread.sxtdemo.net.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer {
    public static void main(String[] args) throws IOException {
        // 1 创建服务器 指定端口 ServerSocket(int port)
        ServerSocket server = new ServerSocket(8888);


        // 2 接收客户端的接连 阻塞式
        while (true) {
            Socket socket = server.accept();
            System.out.println("一个客户端建立连接");

            // 3 发送数据  + 接收数据
            String msg = "欢迎使用";

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF(msg);
            dos.flush();

            while (true) {
                // 其他的客户端就连不上了，一直在等，因为上一个还没处理完
            }

        }
    }
}
