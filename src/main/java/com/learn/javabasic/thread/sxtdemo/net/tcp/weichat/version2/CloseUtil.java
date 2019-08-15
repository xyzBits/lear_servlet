package com.learn.javabasic.thread.sxtdemo.net.tcp.weichat.version2;

import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;

public class CloseUtil {
    public static void closeAll(Closeable... io) {
        for (Closeable temp: io) {
            if (temp != null) {
                try {
                    temp.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void closeSocket(Closeable... sockets) {
        for (Closeable socket: sockets) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
