package com.google.learn.javabasic.thread.Chapter7;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable callable = new MyCallable();
        FutureTask<Integer> task = new FutureTask<>(callable);
        new Thread(task).start();
        System.out.println(task.get());
    }
}

class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return 100;
    }
}
