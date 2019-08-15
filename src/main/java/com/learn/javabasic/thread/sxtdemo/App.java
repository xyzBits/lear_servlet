package com.learn.javabasic.thread.sxtdemo;

public class App {


    public static void main(String[] args) {
        // 共同的资源
        Movie m = new Movie();

        Player p = new Player(m);
        Watcher w = new Watcher(m);

        new Thread(p).start();
        new Thread(w).start();
    }

}
