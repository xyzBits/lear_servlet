package com.learn.spring.aop.demo;

import com.learn.spring.aop.beans.ICalculator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Demo1 {
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet\\src\\main\\resources\\bean-demo.xml");
        ICalculator target = context.getBean(ICalculator.class);
        //int result = target.add(1, 2);
        //System.out.println(result);
      /*  ICalculator proxy = new CalculatorLogProxy(target).getLogProxy();

        System.out.println(proxy.getClass().getName());*/


        System.out.println(target.getClass());
        int result = target.div(100, 4);
        System.out.println(result);

    }
}
