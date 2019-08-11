package com.google.learn.javabasic.thread.sxtdemo.javaassist;

import javassist.CannotCompileException;
import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Demo2 {
    /**
     * 处理类的基本方法
     */
    private static void test01() throws IOException, CannotCompileException, NotFoundException {
        Emp model = new Emp();
        ClassPool pool = ClassPool.getDefault();
        ClassClassPath ccpath = new ClassClassPath(model.getClass());
        pool.insertClassPath(ccpath);


        //ClassPool pool = ClassPool.getDefault();
        Emp emp = new Emp();
        CtClass cc = pool.get(emp.getClass().getName());

        byte[] bytes = cc.toBytecode();
        System.out.println(Arrays.toString(bytes));
        //System.out.println(new String(bytes, 0, bytes.length));
        System.out.println(cc.getName());
        System.out.println(cc.getSimpleName());
        System.out.println(cc.getSuperclass());
        System.out.println(cc.getInterfaces());
    }

    /**
     * 在类中加入新的方法
     * @throws CannotCompileException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    private static void test02() throws CannotCompileException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NotFoundException {
        Emp model = new Emp();
        ClassPool pool = ClassPool.getDefault();
        ClassClassPath ccpath = new ClassClassPath(model.getClass());
        pool.insertClassPath(ccpath);
        //CtClass ctClass = pool.get("com.project.Model");

        //ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("com.google.learn.javabasic.thread.sxtdemo.javaassist.Emp");

/*        CtMethod m = CtMethod.make("public int addd(int a, int b) {" +
                "return a + b;" +
                "}", cc);*/

        CtMethod m = new CtMethod(CtClass.intType, "add",
                new CtClass[]{CtClass.intType, CtClass.intType}, cc);
        m.setModifiers(Modifier.PUBLIC);
        m.setBody("{return $1 + $2;}");
        cc.addMethod(m);

        //通过反射调用新生成的方法
        Class clazz = model.getClass();
        Object object = clazz.newInstance();

        Method method = clazz.getDeclaredMethod("add", int.class, int.class);
        Object result = method.invoke(object, 200, 500);
        System.out.println(result);

    }

    /**
     * 修改已有方法的信息，修改方法体的内容
     * @param
     * @throws
     */
    private static void test03() throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Emp model = new Emp();
        ClassPool pool = ClassPool.getDefault();
        ClassClassPath ccpath = new ClassClassPath(model.getClass());
        pool.insertClassPath(ccpath);
        //CtClass ctClass = pool.get("com.project.Model");

        //ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("com.google.learn.javabasic.thread.sxtdemo.javaassist.Emp");

        CtMethod cm = cc.getDeclaredMethod("sayHello", new CtClass[]{CtClass.intType});
        cm.insertBefore(" System.out.println(\"在调用sayHello方法之前 \" + $1);");
        cm.insertAt(8, "int b = 3; System.out.println(\"b = \" + b);");
        cm.insertAfter("System.out.println(\"在调用sayHello方法之后\");");


        //通过反射调用修改后的方法
        Class clazz = cc.toClass();
        Object object = clazz.newInstance();

        Method method = clazz.getDeclaredMethod("sayHello", int.class);
        Object result = method.invoke(object, 500);
        System.out.println(result);
    }

    public static void main(String[] args) throws Exception {
        test03();
    }
}
