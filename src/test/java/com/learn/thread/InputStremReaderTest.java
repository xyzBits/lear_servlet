package com.learn.thread;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

/**
 * 每次调用一个InputStreamReader的read（）方法都可能导致从底层字节输入流中读取一个或多个字节
 * 字节流读取是单字节读取，但是不同字符集解码成字符需要不通过个数，因此字节流读取会报错
 */
public class InputStremReaderTest {
    private static final String filePath = "D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet\\src\\main\\resources\\test\\baidu.html";

    @Test
    public void test001() {
        try (FileInputStream fis = new FileInputStream(filePath);
             InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
             FileOutputStream fos = new FileOutputStream(filePath.replace("html", "txt"));
             OutputStreamWriter osw = new OutputStreamWriter(fos)) {

            char[] buffer = new char[20];
            int len = 0;
            while ((len = isr.read(buffer)) != -1) {
                System.out.println(new String(buffer, 0, len));
                osw.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        // 从键盘输入的是字节流
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.printf("please input string");
            String data = br.readLine();
            System.out.println(data.toUpperCase());
        }


    }

    @Test
    public void test002() throws IOException {
        InputStream is = new FileInputStream(filePath);
        System.setIn(is);

        OutputStream out = new FileOutputStream(filePath.replace("html", "txtt"));


        byte[] buffer = new byte[20];
        int len = 0;

        while ((len = is.read(buffer)) != -1) {
            System.out.println(new String(buffer, 0, len));
            out.write(buffer, 0, len);
        }
    }

    @Test
    public void test004() throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(filePath);
        PrintStream ps = new PrintStream(fos, true);
        System.setOut(ps);

        for (int i = 0; i < 255; i++) {
            System.out.println((char) i);
            if (i % 30 == 0) {
                System.out.println();
            }
        }
    }

    @Test
    public void test005() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {
            dos.writeUTF("li dongfang");
            dos.writeInt(33);
            dos.writeBoolean(false);
            dos.writeDouble(4.5D);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test006() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
            System.out.println(dis.readUTF());
            System.out.println(dis.readInt());
            System.out.println(dis.readBoolean());
            System.out.println(dis.readDouble());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
