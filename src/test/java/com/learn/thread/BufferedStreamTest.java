package com.learn.thread;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 通过源码可以看到，如果用read()方法读取一个文件，每读取一个字节就要访问一次硬盘，
 * 这种读取的方式效率是很低的。即便使用read(byte b[])方法一次读取多个字节，当读取的文件较大时，也会频繁的对磁盘操作。
 * <p>
 * 为了提高字节输入流的工作效率，Java提供了BufferedInputStream类。
 * <p>
 * 首先解释一下BufferedInputStream的基本原理：
 * <p>
 * API文档的解释：在创建 BufferedInputStream时，会创建一个内部缓冲区数组。在读取流中的字节时，
 * 可根据需要从包含的输入流再次填充该内部缓冲区，一次填充多个字节。
 * <p>
 * 也就是说，Buffered类初始化时会创建一个较大的byte数组，一次性从底层输入流中读取多个字节来填充byte数组，
 * 当程序读取一个或多个字节时，可直接从byte数组中获取，当内存中的byte读取完后，会再次用底层输入流填充缓冲区数组。
 * <p>
 * 这种从直接内存中读取数据的方式要比每次都访问磁盘的效率高很多
 * ————————————————
 * 版权声明：本文为CSDN博主「Lukegwo」的原创文章，遵循CC 4.0 by-sa版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/dream_goon/article/details/37567597
 */
public class BufferedStreamTest {
    @Test
    public void testBuffered() throws IOException {
        long start = System.currentTimeMillis();

        String src = "D:\\ubuntu\\learn\\cpp\\yellow\\143.mp4";
        String dest = "D:\\ubuntu\\learn\\cpp\\yellow\\143_copy.mp4";

        File srcFile = new File(src);
        File destFile = new File(dest);

        FileInputStream fIn = new FileInputStream(srcFile);
        FileOutputStream fOut = new FileOutputStream(destFile);

        BufferedInputStream bufferedIn = new BufferedInputStream(fIn);
        BufferedOutputStream bufferedOut = new BufferedOutputStream(fOut);

        byte[] buffer = new byte[8192];
        int len;

        while ((len = bufferedIn.read(buffer)) != -1) {
            bufferedOut.write(buffer, 0, len);
        }

        bufferedOut.close();
        bufferedIn.close();


        long end = System.currentTimeMillis();

        System.out.println("total time = " + (end - start));
    }

    private void copyFileWithBuffer(String src, String dest) {
        File srcFile = new File(src);
        File destFile = new File(dest);

        try (FileInputStream fIn = new FileInputStream(srcFile);
             FileOutputStream fOut = new FileOutputStream(destFile);

             // 处理流套接在已有流的基础上
             BufferedInputStream bufferedIn = new BufferedInputStream(fIn);
             BufferedOutputStream bufferedOut = new BufferedOutputStream(fOut)
        ) {
            // 流中已经有一个缓冲，我们再从缓冲中拿
            byte[] buffer = new byte[8192];
            int len;

            while ((len = bufferedIn.read(buffer)) != -1) {
                bufferedOut.write(buffer, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void copyTextWithBuffer(String src, String dest) {
        File srcFile = new File(src);
        File destFile = new File(dest);

        try (FileReader in = new FileReader(srcFile);
             FileWriter out = new FileWriter(destFile, true);

             BufferedReader bufferedIn = new BufferedReader(in);
             BufferedWriter bufferedOut = new BufferedWriter(out)) {

/*            char[] buffer = new char[1024];
            int len = 0;

            while ((len = bufferedIn.read(buffer)) != -1) {
                bufferedOut.write(buffer, 0, len);
            }*/

            String data = null;
            while ((data = bufferedIn.readLine()) != null) {
                bufferedOut.write(data); //data中不包含换行符
                //bufferedOut.write(data + "\r\n");
                bufferedOut.newLine();
            }
            bufferedOut.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static final String filePath = "D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet\\src\\main\\resources\\test\\baidu.html";

    @Test
    public void test04() {

        copyTextWithBuffer(filePath, filePath.replace("baidu", "aili"));
    }
}
