package com.learn.javabasic.thread.sxtdemo;

public class RabbitApp {
    public static void main(String[] args) {
        Rabbit rabbit = new Rabbit();
        Tortoise tortoise = new Tortoise();
        tortoise.start();
        rabbit.start();
    }
}
