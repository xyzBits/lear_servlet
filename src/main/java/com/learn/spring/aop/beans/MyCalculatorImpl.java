package com.learn.spring.aop.beans;

public class MyCalculatorImpl {

    public int add(int i, int j) {
        int result = i + j;
        return result;
    }


    public int sub(int i, int j) {
        int result = i - j;
        return result;
    }

    public int mul(int i, int j) {
        int result = i * j;
        return result;
    }

    public int div(int i, int j) {
        int result = i / j;
        return result;
    }
}
