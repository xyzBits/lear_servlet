package com.learn.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;
import java.util.List;

public class MyLogAspect {
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());

        System.out.println("------The method " + methodName + " begins with " + args);

    }

    // 后置通知；目标方法执行后执行，无论是否发生异常，执行的通知
    // 后置通知中，不能访问目标方法的执行结果


    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " ends");
    }


    /**
     * 方法正常结束后执行的代码
     * 返回通知是可以访问不对劲方法的返回值的
     */

    public void afterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " ends with " + result);
    }


    /**
     * 在目标方法出现 异常时会执行
     * 可以访问到异常对象，且可以指定出现在特定异常时再执行此代码，
     * 其实就是看有没有捕捉到这个异常
     */

    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " occurs exception: " + ex);
    }


    public Object aroundMethod(ProceedingJoinPoint pjd) {
        Object result = null;
        String methodName = pjd.getSignature().getName();

        try {
            System.out.println("The method " + methodName + " begins with " + Arrays.asList(pjd.getArgs()));

            result = pjd.proceed();

            System.out.println("hello");


            System.out.println("The method " + methodName + " ends with " + result);
        } catch (Throwable e) {
            System.out.println("The method " + methodName + " occurs exception: " + e);
            throw new RuntimeException(e);
        }

        System.out.println("hello");
        System.out.println("The method " + methodName + " ends ");

        return result;
    }
}
