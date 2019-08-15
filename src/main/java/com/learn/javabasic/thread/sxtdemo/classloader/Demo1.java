package com.learn.javabasic.thread.sxtdemo.classloader;

public class Demo1 {

    static {
        System.out.println("静态初始化Demo1");
    }

    public static void main(String[] args) throws ClassNotFoundException {
/*        System.out.println("Demo1 的main方法");
        A a = new A();
        System.out.println(A.width);*/
        //System.out.println(A.width); //public static int width = 100; 主动引用，会初始化类
        //System.out.println(A.MAX); //public static final int MAX = 200; 被 动引用，不会初始化类
        //Class.forName("com.google.learn.javabasic.thread.sxtdemo.classloader.A"); //反射时会初始化类
        // A a; 不会初始化A
        //A[] as = new A[10]; 不会初始化A

        /**
         * width是在A中声明，子类访问时，会初始化父类，不会初始化子类
         */
        System.out.println(A_Son.width);

    }


}

class A_Father {
    static {
        System.out.println("静态初始化A_Father");
    }
}

class A extends A_Father {
    public static int width = 100;
    public static final int MAX = 200; //静态变量，静态域

    static {

        System.out.println("静态初始化A");
        width = 300;
    }

    public A() {
        System.out.println("创建A类的对象");
    }
}

class A_Son extends A {
    static {
        System.out.println("静态初始化A_Son");
    }
}