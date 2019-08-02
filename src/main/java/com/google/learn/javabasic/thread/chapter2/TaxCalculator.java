package com.google.learn.javabasic.thread.chapter2;

public class TaxCalculator implements CalculatorStragety {
    private final double salary;
    private final double bonus;

    public void setCalculatorStragety(CalculatorStragety calculatorStragety) {
        this.calculatorStragety = calculatorStragety;
    }

    private CalculatorStragety calculatorStragety;


    public TaxCalculator(double salary, double bonus) {
        this.salary = salary;
        this.bonus = bonus;
    }

    public double getSalary() {
        return salary;
    }

    public double getBonus() {
        return bonus;
    }

    protected double calcTax() {
        if (calculatorStragety != null) {
            return calculatorStragety.calculate(salary, bonus);
        } else {
            return 0.d;
        }
    }

    public TaxCalculator(double salary, double bonus, CalculatorStragety calculatorStragety) {
        this.salary = salary;
        this.bonus = bonus;
        this.calculatorStragety = calculatorStragety;
    }

    public double calculate() {
        return this.calcTax();
    }

    @Override
    public double calculate(double salary, double bonus) {
        return 0;
    }
}
