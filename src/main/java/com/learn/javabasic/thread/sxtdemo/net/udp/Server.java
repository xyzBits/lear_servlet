package com.learn.javabasic.thread.sxtdemo.net.udp;


import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 1 创建服务端 + 端口
 * 2 准备接收容器
 * 3 封装成包 DatagramPacket(byte[] buf, int length)
 * 4 接受数据
 * 5 分析数据
 * 6 释放
 */
public class Server {
    public static void main(String[] args) throws IOException {
        //1 创建服务端 + 端口
        DatagramSocket server = new DatagramSocket(8888);

        //2 准备接收容器
        byte[] container = new byte[1024];

        //3 封装成包 DatagramPacket(byte[] buf, int length)
        DatagramPacket packet = new DatagramPacket(container, container.length);

        //4 接受数据
        server.receive(packet);

        //5 分析数据
        byte[] data = packet.getData();
        /*int len = packet.getLength();
        System.out.println(new String(data, 0, len));*/
        double num = convert(data);
        System.out.println(num);

        //6 释放
        server.close();
    }

    private static double convert(byte[] data) throws IOException {
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(data));
        double num = dis.readDouble();
        dis.close();
        return num;
    }

}
