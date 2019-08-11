package com.google.learn.javabasic.thread.sxtdemo.reflect;

/**
 * 测试各种类型
 * class interface enum annotation primitive type void 对应的java.lang.Class对象的获取方式
 */
@SuppressWarnings(value = {"all"})
public class Demo1 {
    public static void main(String[] args) {
        String classPath = "com.google.learn.javabasic.thread.sxtdemo.reflect.User";

        try {
            // 对象封装一些数据 或者表示 一些数据
            /**
             * 一个类被 加载后，类的整个结构信息会被 放到对应的Class对象中
             * 这个Class对象是由jvm创建的，这个对象就像一面镜子，通过这个镜子，我们可以看到对应类的全部信息
             * 就像是我们这个类的图纸一样，
             * 一个类只被 加载一次
             * 一个类只对应一个Class对象，
             * 汽车有多个，图纸只有一个
             */
            Class clazz = Class.forName(classPath);
            System.out.println(clazz.hashCode());

            // 一个类只被 加载一次
            Class clazz2 = Class.forName(classPath);
            System.out.println(clazz2.hashCode()); // hashCode是相同的

            Class strClazz = String.class;
            Class strClazz2 = classPath.getClass();

            Class intClazz = int.class;

            // 数组是和维数有关系，还不是长度
            int[] arr01 = new int[10];
            int[] arr02 = new int[20];
            System.out.println(arr01.getClass().hashCode());
            System.out.println(arr02.getClass().hashCode());

            int[][] arr03 = new int[2][3];
            System.out.println(arr03.getClass().hashCode());

            double[] arr04 = new double[3];
            System.out.println(arr04.getClass().hashCode());


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
