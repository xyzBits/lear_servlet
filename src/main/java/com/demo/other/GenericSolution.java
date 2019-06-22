package com.demo.other;

public class GenericSolution {
    public static <T> T getObject(Class<T> clazz) throws InstantiationException, IllegalAccessException {
        T t = clazz.newInstance();
        return t;
    }

    public <T> void show(T t) {
        System.out.println(t);
    }
}

interface Inter<T> {
    void show(T t);
}

class InterImpl implements Inter<String> {
    @Override
    public void show(String s) {
        System.out.println(s);
    }
}

class ImterImpl1<T> implements Inter<T> {
    @Override
    public void show(T t) {
        System.out.println(t);
    }
}