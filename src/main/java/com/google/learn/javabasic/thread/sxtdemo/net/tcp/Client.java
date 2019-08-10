package com.google.learn.javabasic.thread.sxtdemo.net.tcp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 1 创建客户端 必须指定服务器端 + 端口 此时就在连接
 *
 * 2 接收数据 +发送数据
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //1 创建客户端 必须指定服务器端 + 端口 此时就在连接
        /**
         * 如果 server 没有启动，无法建立连接
         * Exception in thread "main" java.net.ConnectException: Connection refused: connect
         */
        Socket client = new Socket("localhost", 8888);

        // 2 接收数据
/*        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String echo = br.readLine(); // 阻塞式方法
        System.out.println(echo);*/

        DataInputStream dis = new DataInputStream(client.getInputStream());
        String echo = dis.readUTF();
        System.out.println(echo);

    }
}
