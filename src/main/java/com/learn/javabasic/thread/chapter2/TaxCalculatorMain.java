package com.learn.javabasic.thread.chapter2;

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
