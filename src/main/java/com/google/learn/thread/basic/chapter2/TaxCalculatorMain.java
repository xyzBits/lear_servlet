package com.google.learn.thread.basic.chapter2;

import java.text.SimpleDateFormat;

public class TaxCalculatorMain {
    public static void main(String[] args) {
        /*TaxCalculator taxCalculator = new TaxCalculator(10000d, 2000d) {
            @Override
            public double calcTax() {
                return getSalary() * 0.1 + getBonus() * 0.15;
            }
        };*/
        CalculatorStragety simpleCalculator = new SimpleCalculator();

        TaxCalculator taxCalculator = new TaxCalculator(10000d, 2000d, simpleCalculator);
        //taxCalculator.setCalculatorStragety(simpleCalculator);
        double tax = taxCalculator.calculate();
        System.out.println(tax);

    }
}
