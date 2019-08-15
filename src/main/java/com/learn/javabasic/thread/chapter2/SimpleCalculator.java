package com.learn.javabasic.thread.chapter2;

public class SimpleCalculator implements CalculatorStragety {
    private static final double SALARY_RATE = 0.1;
    public static final double BONUS_RATE = 0.15;

    @Override
    public double calculate(double salary, double bonus) {
        return salary * SALARY_RATE + bonus * BONUS_RATE;
    }
}
