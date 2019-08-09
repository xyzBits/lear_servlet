package com.google.learn.javabasic.thread.sxtdemo;

/**
 * 生产者
 */
public class Player implements Runnable {

    private Movie m;

    public Player(Movie m) {
        this.m = m;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 ==0) {
                m.play(" 。。。 左青龙");
            } else {
                m.play(" 。。。 右白虎");
            }
        }
    }
}
