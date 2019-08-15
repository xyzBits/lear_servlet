package com.learn.javabasic.thread.sxtdemo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Call {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService ser = Executors.newFixedThreadPool(2);
        Race rabbit = new Race("老不死", 1000);
        Race tortoise = new Race("小兔子", 500);

        Future<Integer> result1 = ser.submit(rabbit);
        Future<Integer> result2 = ser.submit(tortoise);

        Thread.sleep(2_000);
        rabbit.setFlage(false);
        tortoise.setFlage(false);

        int num1 = result1.get();
        int num2 = result2.get();

        System.out.println(num1);
        System.out.println(num2);

        ser.shutdown();
    }
}

class Race implements Callable<Integer> {
    private String name;
    private long time;
    private boolean flage = true;
    private int step = 0;

    public Race() {
    }

    public Race(String name, long time) {
        this.name = name;
        this.time = time;
    }

    @Override
    public Integer call() throws Exception {
        while (flage) {
            Thread.sleep(time);
            step++;
        }
        return step;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }





    public boolean isFlage() {
        return flage;
    }

    public void setFlage(boolean flage) {
        this.flage = flage;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}
