package com.learn.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 把这个类声明为一个切面，需要把该类放入ioc容器中，再声明为一个切面
 * 可以使用@Order注解指定切面的优先级，值越小优先级越高
 */
@Order(2)
@Aspect
@Component
public class LogAspect {

    /**
     *
     */
    @Pointcut("execution(public int com.google.learn.spring.aop.beans.ICalculator.*(int, int))")
    public void declareJointPointExpression() {}



    @Before("declareJointPointExpression()")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());

        System.out.println("------The method " + methodName + " begins with " + args);

    }

    // 后置通知；目标方法执行后执行，无论是否发生异常，执行的通知
    // 后置通知中，不能访问目标方法的执行结果

    @After("declareJointPointExpression()")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " ends");
    }


    /**
     * 方法正常结束后执行的代码
     * 返回通知是可以访问不对劲方法的返回值的
     */
    @AfterReturning(value = "declareJointPointExpression()",
    returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " ends with " + result);
    }


    /**
     * 在目标方法出现 异常时会执行
     * 可以访问到异常对象，且可以指定出现在特定异常时再执行此代码，
     * 其实就是看有没有捕捉到这个异常
     */
    @AfterThrowing(value = "declareJointPointExpression()",
            throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " occurs exception: " + ex);
    }

    /**
     * 环绕通知需要携带
     * @see ProceedingJoinPoint 类型的参数
     * 环绕通知类似于动态代理的全过程
     * 这个参数可以决定是否执行目标方法
     * 且环绕通知后必须要有返回值 ，返回值 即为目标方法的返回值
     * @param pjd
     * @return
     */
    @Around("declareJointPointExpression()")
    public Object aroundMethod(ProceedingJoinPoint pjd) {
        Object result = null;
        String methodName = pjd.getSignature().getName();

        try {
            // 前置通知
            System.out.println("The method " + methodName + " begins with " + Arrays.asList(pjd.getArgs()));

            // 执行目标方法
            result = pjd.proceed();

            // 后置通知
            System.out.println("The method " + methodName + " ends with " + result);
        } catch (Throwable e) {
            // 异常通知
            System.out.println("The method " + methodName + " occurs exception: " + e);
            throw new RuntimeException(e);
        }

        // 后置通知
        System.out.println("The method " + methodName + " ends ");

        return result;
    }
}
