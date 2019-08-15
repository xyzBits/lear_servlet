package com.learn.spring.aop.beans.impl;

import com.google.learn.spring.aop.beans.ICalculator;
import org.springframework.stereotype.Component;

@Component
public class CalculatorImpl implements ICalculator {
    @Override
    public int add(int i, int j) {
        int result = i + j;
        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result = i - j;
        return result;
    }

    @Override
    public int mul(int i, int j) {
        int result = i * j;
        return result;
    }

    @Override
    public int div(int i, int j) {
        int result = i / j;
        return result;
    }
}
