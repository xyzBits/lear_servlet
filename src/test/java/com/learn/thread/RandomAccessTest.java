package com.learn.thread;

import org.junit.Test;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessTest {
    private final String path = "D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet\\src\\main\\resources\\test\\baidu.html";

    @Test
    public void test001() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile(path, "r");
        RandomAccessFile raf2 = new RandomAccessFile(path.replace("baidu", "aili"), "rw");

        byte[] buffer = new byte[1024];
        int len;

        while ((len = raf1.read(buffer)) != -1) {
            raf2.write(buffer, 0, len);
        }

        raf1.close();
        raf2.close();


    }


    @Test
    public void test002() throws IOException {
        File file = new File(path.replace("baidu", "aili"));
        RandomAccessFile raf2 = new RandomAccessFile(file, "rw");

        System.out.println(raf2.getFilePointer());
        raf2.seek(file.length() - 2); //指针调到3
        raf2.write("xyz".getBytes());
        raf2.close();

    }

    @Test
    public void test003() throws IOException {
        File file = new File(path.replace("baidu", "aili"));
        RandomAccessFile raf2 = new RandomAccessFile(file, "rw");

        raf2.seek(3);

        byte[] buffer = new byte[20];
        int len = 0;
        StringBuilder builder = new StringBuilder((int) file.length());

        while ((len = raf2.read(buffer)) != -1) {
            builder.append(new String(buffer, 0, len));
        }

        raf2.seek(3);
        raf2.write("xyz".getBytes());
        raf2.write(builder.toString().getBytes());

        raf2.close();
    }

    @Test
    public void test004() throws IOException {
        FileCopyUtils.copy(new File(""),new File(""));
    }


}
