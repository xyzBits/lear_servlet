package com.learn.javabasic.thread.sxtdemo.reflect.demo;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class Demo4 {
    private void test01(Map<String, User> map, List<User> users) {
        System.out.println("Demo4.test01()");
    }

    private Map<Integer, User> test02() {
        System.out.println("Demo4.test02()");
        return null;
    }

    public static void main(String[] args) {
        try {
            // 获取指定方法的泛型信息
            Method method = Demo4.class.getDeclaredMethod("test01", Map.class, List.class);
            Type[] types = method.getGenericParameterTypes();

            for (Type paramType : types) {
                System.out.println("# -->" + paramType);
                if (paramType instanceof ParameterizedType) {
                    Type[] genricTypes = ((ParameterizedType) paramType).getActualTypeArguments();
                    for (Type genricType : genricTypes) {
                        System.out.println("泛型类型： ----> " + genricType);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //获得指定方法的返回值 的泛型信息
        System.out.println("获得指定方法的返回值 的泛型信息");

        try {
            Method method2 = Demo4.class.getDeclaredMethod("test02", null);

            Type returnType = method2.getGenericReturnType();
            if (returnType instanceof ParameterizedType) {
                Type[] genricTypes = ((ParameterizedType) returnType).getActualTypeArguments();

                for (Type genrictype : genricTypes) {
                    System.out.println("返回值 泛型类型为：－－－－＞" + genrictype);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
