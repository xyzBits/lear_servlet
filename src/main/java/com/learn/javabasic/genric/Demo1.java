package com.learn.javabasic.genric;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Demo1 {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
      /*  Class<?> clazz = StringBuffer.class;
        clazz = Integer.class;*/

        List list = new ArrayList();

        list.add("hello");
        // Incompatible types required java.lang.String  found java.lang.Object
        //String hello = list.get(0);
        //System.out.println(list.getClass());


        //List<Number> numbers = new ArrayList<Integer>();

        ArrayList<Integer> integers = new ArrayList<>();

        integers.add(1);

        //ArrayList<Number> numbers = integers;
        //numbers.add(0.9);
        //Integer n = integers.get(1);

        List<Number> numbers = new ArrayList<>();
        numbers.add(new Integer(123));
        numbers.add(new Double(3.4));
        Number n = numbers.get(0);

        //Pair<String> pair = new Pair<>(String.class);


        Class<Pair> clazz = Pair.class;
        Type t = clazz.getGenericSuperclass();
        if (t instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) t;
            Type[] types = pt.getActualTypeArguments(); // 可能有多个泛型类型
            Type firstType = types[0]; // 取第一个泛型类型
            Class<?> typeClass = (Class<?>) firstType;
            System.out.println(typeClass); // Integer
        }


    }
}


class Pair<T> {
    private T first;
    private T last;

    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }

    public T getLast() {
        return last;
    }
}

class IntPair extends Pair<Integer> {
    public IntPair(Integer first, Integer last) {
        super(first, last);
    }
}
/*class Pair<T> {
    private T first;
    private T last;

*//*    public Pair() {
        first = new T();
        last = new T(); // first = new Object();
    }*//*

    public Pair(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        first = clazz.newInstance();
        last = clazz.newInstance();

    }
}*/
