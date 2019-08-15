package com.learn.javabasic.thread.sxtdemo.javaassist;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.NotFoundException;

import java.io.IOException;

/**
 * 测试使用javaassist生成一个新的类
 *
 */
public class Demo1 {
    public static void main(String[] args) throws CannotCompileException, NotFoundException, IOException {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.makeClass("com.bjsxt.bean.Emp");

        // 创建属性
        CtField f1 = CtField.make("private int empno;", cc);
        CtField f2 = CtField.make("private String ename;", cc);
        cc.addField(f1);
        cc.addField(f2);

        // 添加方法
        CtMethod m1 = CtMethod.make("public int getEmpno() { return empno;}", cc);
        CtMethod m2 = CtMethod.make("public void setEmpno(int empno) { this.empno = empno;}", cc);
        cc.addMethod(m1);
        cc.addMethod(m2);

        //添加构造器
        CtConstructor ctConstructor = new CtConstructor(new CtClass[]{CtClass.intType, pool.get("java.lang.String")}, cc);
        ctConstructor.setBody("{this.empno = empno; this.ename = ename;}");
        cc.addConstructor(ctConstructor);

        cc.writeFile("D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\simple\\"); // 将上面写好的类写入java文件中
        System.out.println("生成类成功");

    }
}
