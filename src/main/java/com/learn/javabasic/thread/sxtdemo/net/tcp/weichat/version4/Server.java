package com.learn.javabasic.thread.sxtdemo.net.tcp.weichat.version4;


import com.learn.javabasic.thread.sxtdemo.net.tcp.weichat.version2.CloseUtil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 创建客户端： 发送数据  + 接收数据
 */
public class Server {
    private static List<MyChannel> all = new ArrayList<MyChannel>();

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

/*        ServerSocket server = new ServerSocket(9999);

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

        }*/


        new Server().start();


    }

    public void start() throws IOException {
        ServerSocket server = new ServerSocket(9999);

        while (true) {
            Socket client = server.accept();
            MyChannel channel = new MyChannel(client);
            all.add(channel); // 加入到容器中统一管理

            new Thread(channel).start();
        }

    }

    /**
     * 一个客户端，一条道路
     * 1 输入流
     * 2 输出流
     * 3 接收数据
     * 4 发送数据
     */
    private class MyChannel implements Runnable {
        private DataInputStream dis;
        private DataOutputStream dos;

        private boolean isRunning = true;

        private String name;

        public MyChannel(Socket client) {
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());

                this.name = dis.readUTF();
                System.out.println("用户 ----> " + this.name + " 进入聊天室");
                send("欢迎 ---->" + this.name + " 进入聊天室");
                sendOther(this.name + " ----> 进入聊天室", true);
            } catch (IOException e) {
                //e.printStackTrace();
                isRunning = false;
                CloseUtil.closeAll(dis, dos);
            }
        }

        private String receive() {
            String msg = "";
            try {
                msg = dis.readUTF();
            } catch (IOException e) {
                //e.printStackTrace();
                CloseUtil.closeAll(dis);
                isRunning = false;
                all.remove(this);

            }

            return msg;
        }

        private void send(String msg) {
            if ((msg == null) || (msg.equals(""))) {
                return;
            }

            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                //e.printStackTrace();
                CloseUtil.closeAll(dos);
                isRunning = false;
                all.remove(this);
            }

        }

        private void sendOther(String msg, boolean isSystemInfo) {
            //String msg = this.receive();

            // 是否为私聊
            if (msg.startsWith("@") && msg.indexOf(":") > -1) { // 私聊

                // 获取name
                String name = msg.substring(1, msg.indexOf(":"));
                String content = msg.substring(msg.indexOf(":") + 1);
                for (MyChannel other : all) {
                    if (other.name.equals(name)) {
                        other.send(this.name + " ----> 对您悄悄地说： ---> " + content);
                    }

                }
            } else {// 群聊
                // 遍历容器
                for (MyChannel other : all) {
                    if (other == this) {
                        continue;
                    }
                    if (isSystemInfo) {
                        other.send("系统消息 ---> " + msg);
                    } else {
                        other.send(this.name + " ---> 对所有人说 ---> " + msg);
                    }
                }


            }
        }

        @Override
        public void run() {
            while (isRunning) {
                sendOther(receive(), false);
            }
        }
    }
}
