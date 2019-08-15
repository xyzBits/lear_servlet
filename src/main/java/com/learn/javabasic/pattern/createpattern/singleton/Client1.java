package com.learn.javabasic.pattern.createpattern.singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

/**
 * 测试多线程环境下五种创建单例模式的效率
 */
public class Client1 {
    private static Logger LOGGER = LoggerFactory.getLogger(Client1.class);

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        // 内部类不能直接使用外部的变量
        final CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100_000; i++) {
                        Object o = SingletonDemo5.getInstance();
                    }
                    countDownLatch.countDown();
                }
            }).start();
        }
        countDownLatch.await();

        long end = System.currentTimeMillis();

        LOGGER.info("总耗时 = " + (end - start));

    }
}
