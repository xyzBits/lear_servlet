package com.learn.thread;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReadWriteTest {
    private static final String filePath = "D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet\\src\\main\\resources\\test\\baidu.html";

    @Test
    public void test001() {

        File file = new File(filePath);
        System.out.println(file.getAbsolutePath());
    }

    @Test
    public void test002() throws IOException {
        // 实例化file类的对象，指明要操作的对象
        File file = new File(filePath);

        // 提供具体的流
        FileReader fileReader = new FileReader(file);

        //System.out.print((char) fileReader.read());

        // 数据的读入
/*        int data = fileReader.read();
        while (data != -1) {
            System.out.print((char) data);
            data = fileReader.read(); // 就像循环中的i++一样
        }*/

        int data; // 先给data赋值，再看是不是-1
        while ((data = fileReader.read()) != -1) {
            System.out.print((char) data);

        }

        // 流的关闭
        fileReader.close(); // 物理上的资源，jvm无能为力
    }

    @Test
    public void test003() {
        File file = new File(filePath + "9");

        try (FileReader fileReader = new FileReader(file)) {

            int data;
            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);

            }


            fileReader.close();
        } catch (IOException e) {
            //System.out.println(e); //直接打异常，会打印文件的全部路径

            System.out.println(e.getClass());


            //e.printStackTrace();
        } finally {

        }

        // 已经try catch了，异常已经被处理了，所以后面的代码还会被 执行
        System.out.println("is executed?");
    }

    @Test
    public void test004() throws IOException {
        File file = new File(filePath);

        FileReader reader = new FileReader(file);

        char[] buffer = new char[5];
        int len;
        while ((len = reader.read(buffer)) != -1) {
            for (int i = 0; i < buffer.length/*最后一次读入时，如果文件中剩余个数不能填满数组，数组中原来的值还在*/; i++) {
                System.out.print(buffer[i]);
            }

            // 读入了几个，就输入几个，len就是每次读取时读入的个数
      /*      for (int i = 0; i < len*//*最后一次读入时，如果文件中剩余个数不能填满数组，数组中原来的值还在*//*; i++) {
                System.out.print(buffer[i]);
            }*/
            System.out.println();
            System.out.println(len);
        }
        /**
         * hello
         * 5
         * world
         * 5
         * 123ld
         * 3
         * 第三次读入时，原来是
         * world
         * 再次读入时，123覆盖wor，但是ld没有被 覆盖
         */

        reader.close();
    }

    @Test
    public void testFileWriter() throws IOException {
        File file = new File(filePath.replace("baidu", "google"));

        FileWriter out = new FileWriter(file, true);

        out.write("I have a dream");
        out.write("\r\n");
        out.write("you need to have a dream");
        out.write("\r\n");
        out.close();
    }

    @Test
    public void testCopy() throws IOException {
        File source = new File(filePath);
        System.out.println(source.length());
        File destination = new File(filePath.replace(".html", ".txt"));

        FileReader in = new FileReader(source);
        FileWriter out = new FileWriter(destination);

        char[] buffer = new char[5];
        int len = 0;
        while ((len = in.read(buffer)) != -1) {
            out.write(buffer, 0, buffer.length);
            System.out.println(new String(buffer));
        }

        in.close();
        out.close();
    }

    @Test
    public void testRead() throws IOException {
        File file = new File(filePath);
        FileReader in = new FileReader(file);
        char[] buffer = new char[5];
        int len = 0;
        while ((len = in.read(buffer)) != -1) {
            //System.out.println(new String(buffer));
            for (int i = 0; i < buffer.length ; i++) {
                System.out.print(buffer[i]);

            }
        }
    }
}
