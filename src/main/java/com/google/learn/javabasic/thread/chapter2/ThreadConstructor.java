package com.google.learn.javabasic.thread.chapter2;

public class ThreadConstructor {
    public static void main(String[] args) {
        Thread t1 = new Thread();
        ThreadGroup group = new ThreadGroup("TestGroup");
        Thread t2 = new Thread(group, "t2");
        ThreadGroup mainThreadGroup = Thread.currentThread().getThreadGroup();
        System.out.println(mainThreadGroup.getName());
        System.out.println(t1.getThreadGroup().getName());
        System.out.println(t2.getThreadGroup().getName());
        System.out.println(t2.getThreadGroup() == group);
        System.out.println(t1.getThreadGroup() == Thread.currentThread().getThreadGroup());

        System.out.println("============");
        Thread.currentThread();
    }
}
