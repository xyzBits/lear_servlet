package com.google.learn.javabasic.thread.sxtdemo.classloader;

/**
 * 测试自定义的类加载器
 */
public class Demo3 {
    public static void main(String[] args) throws ClassNotFoundException {
        FileSystemClassLoader loader = new FileSystemClassLoader("D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\simple");

        Class<?> clazz =  loader.loadClass("com.bjsxt.bean.Emp");
        System.out.println("--------->" + clazz.hashCode());

        Class<?> clazz1 =  loader.loadClass("com.bjsxt.bean.Emp");
        System.out.println("--------->" + clazz1.hashCode());

        FileSystemClassLoader loader2 = new FileSystemClassLoader("D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\simple");

        // 同一个类，被 不同的类加载器加载，jvm认为是不同的类
        Class<?> clazz2 =  loader2.loadClass("com.bjsxt.bean.Emp");
        System.out.println("--------->" + clazz2.hashCode());

        Class<?> clazz3 =  loader2.loadClass("java.lang.String");
        System.out.println("--------->" + clazz3.hashCode());
        System.out.println(clazz3.getClassLoader()); //引导 类加载器

        System.out.println(clazz2.getClassLoader()); // 自定义义类加载器


        System.out.println(new Demo3().getClass().getClassLoader()); // AppClassLoader类加载器

    }
}
