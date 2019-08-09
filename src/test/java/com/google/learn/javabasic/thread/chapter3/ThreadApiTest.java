package com.google.learn.javabasic.thread.chapter3;

import com.google.learn.javabasic.thread.chapter1.RunnableTicketWindow;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class ThreadApiTest {
    @Test
    public void test001() {
        ThreadGroup group = new ThreadGroup("test");
        group.setMaxPriority(7);

        Thread thread = new Thread(group, "test-thread");
        thread.setPriority(10);
        System.out.println(thread.getPriority());
    }

    @Test
    public void test002() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() == this);
                System.out.println(Thread.currentThread().getContextClassLoader());
            }
        };
        thread.start();
        String name = Thread.currentThread().getName();
        System.out.println("main".equals(name));
        System.out.println(Thread.currentThread().getContextClassLoader());

    }

    @Test
    public void test003() throws InterruptedException {
        Thread testThreead = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Yes, I am interrupted, but i am still running");
                        return;
                    } else {
                        System.out.println("not yet interrupted");
                    }
                }
            }
        }, "InterruptionInJava");

        testThreead.start();
        Thread.sleep(1000);
        testThreead.interrupt();

    }

    @Test
    public void test004() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
        Thread.sleep(100);
        System.out.println(thread.isInterrupted());

        thread.interrupt();
        System.out.println(thread.isInterrupted());
    }

    @Test
    public void test005() throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("Oh, I am be interrupted");
                e.printStackTrace();
            }
        });

        thread.start();

        TimeUnit.MILLISECONDS.sleep(2);
        thread.interrupt();
    }

    @Test
    public void test006() throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {

            }
        });

        thread.start();
        TimeUnit.MILLISECONDS.sleep(2);
        System.out.println("Thread is interrupted ? " + thread.isInterrupted());
        thread.interrupt();
        System.out.println(thread.isInterrupted());
    }

    /*public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {

            }
        });

        thread.start();
        TimeUnit.MILLISECONDS.sleep(2);
        System.out.println("Thread is interrupted ? " + thread.isInterrupted());
        thread.interrupt();
        System.out.println(thread.isInterrupted());
    }*/

    @Test
    public void test008() throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    TimeUnit.MINUTES.sleep(1);
                } catch (InterruptedException e) {
                    System.out.println("I am be interrupted " + isInterrupted());
                    e.printStackTrace();
                }
            }
        };

        thread.setDaemon(true);
        thread.start();

        TimeUnit.MILLISECONDS.sleep(2);
        System.out.println("145  " + thread.isInterrupted());

        thread.interrupt();
        TimeUnit.MILLISECONDS.sleep(2);
        System.out.println("149  " + thread.isInterrupted());

    }

    @Test
    public void test009() throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.interrupted());
                }
            }
        };
        thread.setDaemon(true);
        thread.start();

        TimeUnit.MILLISECONDS.sleep(2);
        thread.interrupt();
    }

    @Test
    public void test010() throws ClassNotFoundException {
        Class clazz = String.class;
        Class clazz1 = Class.forName("java.lang.String");
        Class clazz2 = "hello".getClass();
        System.out.println(clazz == clazz1);
        System.out.println(clazz1 == clazz2);
        System.out.println(clazz);
    }

    private void printClassInfo(Class clazz) {
        System.out.println("Class name " + clazz.getName());
        System.out.println("Simple name " + clazz.getSimpleName());

        if (clazz.getPackage() != null) {
            System.out.println("Package name " + clazz.getPackage().getName());
        }

        System.out.println("is interface " + clazz.isInterface());
        System.out.println("is enum: " + clazz.isEnum());
        System.out.println("is array " + clazz.isArray());
        System.out.println("is primitive " + clazz.isPrimitive());
    }

    @Test
    public void test011() throws IllegalAccessException, InstantiationException {
        printClassInfo(List.class);

        Class clazz = StringBuffer.class;
        StringBuffer sb = (StringBuffer) clazz.newInstance();
        sb.append("hello");
        System.out.println(sb);

        // clazz = Class.class;
        // Method method = clazz.getConstructor("Class");
    }

    class Person {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Person(String name) {
            this.name = name;
        }
    }

/*    class Student extends Person {
        public int score;
        private final int grade = 0;
    }*/

    @Test
    public void test012() throws NoSuchFieldException {
/*        Class stuClazz = Student.class;
        System.out.println(stuClazz.getField("score"));
        System.out.println(stuClazz.getField("name"));
        System.out.println(stuClazz.getDeclaredField("grade"));
        Field gradeField = stuClazz.getDeclaredField("grade");
        System.out.println(gradeField.getModifiers());
        System.out.println(gradeField.getType());*/
    }

    @Test
    public void test013() throws NoSuchFieldException {
        Field valueField = String.class.getDeclaredField("value");
        System.out.println(valueField.getName());
        System.out.println(valueField.getType());
        System.out.println(valueField.getModifiers());

        int m = valueField.getModifiers();
        System.out.println(Modifier.isFinal(m));
        System.out.println(Modifier.isPublic(m));
        System.out.println(Modifier.isProtected(m));
        System.out.println(Modifier.isPrivate(m));
        System.out.println(Modifier.isStatic(m));
    }

    @Test
    public void test014() throws NoSuchFieldException, IllegalAccessException {
        Object p = new Person("Xiao Ming");
        Class c = p.getClass();
        Field f = c.getDeclaredField("name");
        f.setAccessible(true);
        Object value = f.get(p);
        System.out.println(value);

        f.set(p, "Xiao Hong");
        System.out.println(((Person) p).getName());
    }

}