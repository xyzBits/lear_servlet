package com.learn.javabasic.pattern.createpattern.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 饿汉式
 */
public class SingletonDemo5 implements Serializable {
    private static final SingletonDemo5 instance = new SingletonDemo5();

    private SingletonDemo5() {
        // 防止通过反射来创建对象
        if (instance != null ) {
            throw new RuntimeException("dot not create singleton repeatedly");
        }
    }

    public static   SingletonDemo5 getInstance() {
        return instance;
    }

    //反序列化时，如果 定义了readResolve方法，则直接返回此方法指定的对象，不需要单独创建新对象
    private Object readResolve() throws ObjectStreamException {
        return instance;
    }

}
