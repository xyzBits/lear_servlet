package com.learn.spring.aop.proxy;


import com.learn.spring.aop.beans.ICalculator;
import com.learn.spring.aop.beans.impl.CalculatorImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class CalculatorLogProxy {
    // 要代理的对象
    private ICalculator target;

    public CalculatorLogProxy(ICalculator target) {
        this.target = target;
    }

    public ICalculator getLogProxy() {
        ICalculator proxy = null;

        //代理对象由哪一个类加载器负责加载
        ClassLoader loader = target.getClass().getClassLoader();

        // 代理对象的类型，即其中有哪些 方法
        Class[] interfaces = new Class[] {ICalculator.class};

        // 当调用代理对象其中的方法时，该代码执行
        InvocationHandler handler = new InvocationHandler() {
            /**
             *
             * @param proxy 正在返回的代理对象，一般情况下，在invoke方法中都不使用该对象
             * @param method 正在被调用的方法
             * @param args 调用方法时传入的参数
             * @return
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();

                // 日志
                System.out.println("The method " + methodName + " begins with " + Arrays.asList(args));

                // 执行方法
                Object result  = null;
                try {
                    // 前置通知
                    result = method.invoke(target, args);

                    // 返回通知，可以访问到方法的返回值
                } catch (Exception e) {
                    // 异常通知， 可以访问到方法出现的异常
                    e.printStackTrace();
                }

                // 后置通知， 因为方法可能会出现异常，所以访问不到方法的返回值

                // 日志
                System.out.println("The method " + methodName + " ends with " + result);

                return result;
            }
        };

        proxy = (ICalculator) Proxy.newProxyInstance(loader, interfaces, handler);
        return proxy;

    }

    public static void main(String[] args) {
        ICalculator target = new CalculatorImpl();
        ICalculator proxy = new  CalculatorLogProxy(target).getLogProxy();
    }
}
