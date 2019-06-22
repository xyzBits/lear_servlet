package com.google.learn.proxy;

import org.junit.Test;

import java.lang.reflect.Proxy;

import static org.junit.Assert.*;

public class JavaDeveloperTest {
    @Test
    public void test001() {
        JavaDeveloper zack = new JavaDeveloper("zack");

        Developer zackProxy = (Developer) Proxy.newProxyInstance(zack.getClass().getClassLoader(),
                zack.getClass().getInterfaces(), ((proxy, method, args) -> {
                    if (method.getName().equals("code")) {
                        System.out.println("Zack is praying for the code");
                        return method.invoke(zack, args);
                    }

                    if (method.getName().equals("debug")) {
                        System.out.println("Zack's have no bug! No need to debug!");
                        return null;
                    }
                    return null;
                }));

        //zack.code();
        //zack.debug();
        zackProxy.code();
        zackProxy.debug();
    }

}