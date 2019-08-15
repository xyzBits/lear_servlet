package com.learn.thread;

import org.junit.Test;

import java.lang.reflect.Field;

import static java.lang.Thread.*;

public class MemoryModelTest {
    private static boolean iniFlag = false;

    @Test
    public void test001() throws Exception {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("wait to prepare data");
                while (!iniFlag) {
                    System.out.println("running");
                }
                System.out.println("prepare data succeed");
            }
        }).start();

        sleep(3000L);

        new Thread(new Runnable() {
            @Override
            public void run() {
                prepare();
            }
        }).start();
    }

    private void prepare() {
        System.out.println("prepare data ");
        iniFlag = true;
        System.out.println("end prepare data");
    }

    @Test
    public void test002() {
        readFromDataBase();
        writeDataToFile();

    }

    public static void main(String[] args) {
        new MemoryModelTest().readFromDataBase();
        new MemoryModelTest().writeDataToFile();
    }

    @Test
    public void test03() {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("t1 i = " + i);
                }
            }
        };

        t1.start();

        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int j = 0; j < 500; j++) {
                    System.out.println("t2 j = " + j);
                }
            }
        };
        t2.start();
    }

    private void writeDataToFile() {
        try {
            System.out.println("Begin write data to file");
            Thread.sleep(1000 * 20L);
            System.out.println("End write data to file");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void readFromDataBase() {
        try {
            System.out.println("Begin read data from DB...");
            Thread.sleep(1000 * 10L);
            System.out.println("End read data from DB...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test004() {
        new Thread("READ-Thread") {
            @Override
            public void run() {
                readFromDataBase();
            }
        }.start();

        new Thread("WRITE-Thread") {
            @Override
            public void run() {
                writeDataToFile();
            }
        }.start();
    }

    @Test
    public void test005() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                readFromDataBase();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                writeDataToFile();
            }
        }).start();
    }

    @Test
    public void test006() {
        int i = 0;
        boolean result  = (1 < 2) || (i++ > 0);
        System.out.println(result);
        System.out.println(i);
    }

    @Test
    public void test007() throws Exception {
        String s = "hello world";
        System.out.println(" s == " + s);

        Field valueField = s.getClass().getDeclaredField("value");
        valueField.setAccessible(true);

        byte[] value = (byte[]) valueField.get(s);
        value[3] = 65;
        System.out.println(" s = " + s);

    }

    @Test
    public void test008() {
        String s1 = "hello";
        String s2 = "hello".intern();
        System.out.println(s1 == s2);
    }
}