package com.learn.spring.aop.proxy;

import java.lang.reflect.Proxy;

@SuppressWarnings("all")
public class GeneralProxy {

    public static <T> T getProxyObject(T target) {
        Class<T> clazz = (Class<T>) target.getClass();

        T proxyObject = (T) Proxy.newProxyInstance(clazz.getClassLoader(),
                clazz.getInterfaces(),
                ((proxy, method, args) -> {
                    Object result = method.invoke(target, args);
                    return result;
                }));

        return proxyObject;
    }
}
