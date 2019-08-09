package com.google.learn.javabasic.thread.sxtdemo.net.udp;

import org.springframework.aop.target.LazyInitTargetSource;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 *         // 1 创建客户端 + 端口
 *         // 2 准备数据
 *         // 3 打包数据 （发送的地点及端口）
 *         // DatagramPaket(byte[] buf, int length, InetAddress address)
 *
 *         // 4 发送
 *
 *         // 5 释放
 *         如果 server关闭，也能发出去，而且没有异常
 */
public class Client {
    public static void main(String[] args) throws IOException {
        // 1 创建客户端 + 端口
        DatagramSocket client = new DatagramSocket(6666); // 这是指定了客户端的端口， 打包数据的时候才指定ip和端口，数据找去服务器，不是client 找服务器

        // 2 准备数据
       /* String msg = "udp编程";
        byte[] data = msg.getBytes();*/
       double num = 3.14;
       byte[] data = convert(num);

        // 3 打包数据 （发送的地点及端口）
        // DatagramPaket(byte[] buf, int length, InetAddress address)
        DatagramPacket packet = new DatagramPacket(data, data.length, new InetSocketAddress("localhost", 8888));

        // 4 发送
        client.send(packet);

        // 5 释放
        client.close();
    }

    private static byte[] convert(double num) throws IOException {
        byte[] data = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(bos);
        dos.writeDouble(num);
        dos.flush();

        // 获取数据

        data = bos.toByteArray();
        dos.close();
        return data;
    }
}
