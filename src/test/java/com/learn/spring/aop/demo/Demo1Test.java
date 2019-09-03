package com.learn.spring.aop.demo;

import com.learn.spring.aop.beans.MyCalculatorImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("classpath:aop2.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class Demo1Test {

    @Autowired
    MyCalculatorImpl myCalculator;

    @Test
    public void testXmlAop() {
        System.out.println(myCalculator);
        System.out.println(myCalculator.getClass());
        myCalculator.add(1, 2);
    }

}