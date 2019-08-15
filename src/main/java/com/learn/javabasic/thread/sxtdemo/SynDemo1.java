package com.learn.javabasic.thread.sxtdemo;


public class SynDemo1 {
    public static void main(String[] args) {
        /*Jvm jvm = Jvm.getInstance();
        Jvm jvm1 = Jvm.getInstance();
        System.out.println(jvm == jvm1);*/
        JvmThread jvmThread = new JvmThread(100);
        JvmThread jvmThread1 = new JvmThread(200);
        jvmThread.start();
        jvmThread1.start();
    }

}


class JvmThread extends Thread {

    private long time;

    public JvmThread(long time) {
        this.time = time;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 创建 jvm " + Jvm.getInstance(time));
    }
}

class Jvm {
    private static Jvm instance = null; // 这里懒得创建对象，使用的时候再创建

    // 构造器私有化，避免外部直接创建对象
    private Jvm() {
    }

    public static Jvm getInstance(long time) {

        // 已经存在对象了，提高效率
        if (instance == null) {
            // 对象是字节码信息，将类信息锁信了，模板锁住了
            synchronized (Jvm.class) {
                if (instance == null) {
                    try {
                        Thread.sleep(time);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new Jvm();
                }
            }
        }
        return instance;
    }


    public static Jvm getInstance3(long time) {

        // 对象是字节码信息
        synchronized (Jvm.class) {
            if (instance == null) {
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                instance = new Jvm();
            }
        }
        return instance;
    }

    public static synchronized Jvm getInstance2(long time) {


        if (instance == null) {
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new Jvm();
        }
        return instance;
    }


    public static Jvm getInstance1(long time) {


        if (instance == null) {
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new Jvm();
        }
        return instance;
    }
}