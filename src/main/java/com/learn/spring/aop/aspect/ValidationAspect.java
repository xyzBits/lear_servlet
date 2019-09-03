package com.learn.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(1)
@Aspect
@Component
public class ValidationAspect {
    @Before("com.learn.spring.aop.aspect.LogAspect.declareJointPointExpression()")
    public void beforeMethod(JoinPoint joinPoint) {
        System.out.println("-----> validate:  " + Arrays.asList(joinPoint.getArgs()));

    }
}
