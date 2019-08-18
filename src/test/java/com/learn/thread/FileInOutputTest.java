package com.learn.thread;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FileInOutputTest {
    private static final String filePath = "D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet\\src\\main\\resources\\test\\baidu.html";

    @Test
    public void testFileInputStream() throws IOException {
        File file = new File(filePath);
        System.out.println(file.length());

        FileInputStream in = new FileInputStream(file);

        // 使用fileInputStream读取字符文本时，极大概率会出现 乱码，汉字 的UTF-8是三个字节，
        // 读取时一次读取一个字节，会在边界刚好将一个汉字的三个字节拆开，慌到乱码
        byte[] buffer = new byte[300];
        int len = 0;

        while ((len = in.read(buffer)) != -1) {
            // String 内部会有一套翻译的机制，第一次读，读一个字节，
            /**
             * I 01001001
             * t 01110100
             * ' 00100111
             * s 01110011
             *   00100000
             * 知 11100111 10011111 10100101
             * 乎 11100100 10111001 10001110
             * 日 11100110 10010111 10100101
             * 报 11100110 10001010 10100101
             */
            System.out.print(new String(buffer, "UTF-8"));
        }

        in.close();
    }


    @Test
    public void testFileInputStream1() throws IOException {
        File file = new File(filePath);
        System.out.println(file.length());

        FileInputStream in = new FileInputStream(file);

        int data = 0;
        byte[] buffer = new byte[12];
        int k = 0;

        while ((data = in.read()) != -1) {
            System.out.println(Integer.toBinaryString(data));
            System.out.println(data);
            buffer[k] = (byte) data;
            k++;
            //break;
            // String 内部会有一套翻译的机制，第一次读，读一个字节，
            /**
             * I 01001001
             * t 01110100
             * ' 00100111
             * s 01110011
             *   00100000
             * 知 11100111 10011111 10100101
             * 乎 11100100 10111001 10001110
             * 日 11100110 10010111 10100101
             * 报 11100110 10001010 10100101
             */

        }
        String[] binaryBuffer = new String[buffer.length];
        k = 0;
        for (byte b : buffer) {
            binaryBuffer[k] = Integer.toBinaryString(b);
            k++;
        }

        System.out.println(Arrays.toString(binaryBuffer));
        // [-25, -97, -91, -28, -71, -114, -26, -105, -91, -26, -118, -91] 这就是字节数组，把这个放到string中，就能翻译成字符串
        System.out.println(Arrays.toString(buffer)); //
        System.out.println(new String(buffer, 0, buffer.length));

        in.close();
    }


    @Test
    public void testBinary() {
        String binaryStr = "111001101000101010100101";
        int num = 0B111001101000101010100101;
        System.out.println(Integer.toBinaryString(num).equals(binaryStr));

    }

    private void copyFile(String src, String dest) {
        File srcfile = new File(src);
        File destFile = new File(dest);

        try (FileInputStream input = new FileInputStream(srcfile);
             FileOutputStream output = new FileOutputStream(destFile)) {

            /**
             * 251 MB (263,704,145 字节)
             * 143.mp4
             * buffer太小，就要重复读取很多次，太大了占用内存很大，有一个适中的
             * buffer 字节数组为10的时候，复制时间为145100ms
             * buffer 字节数组为1024的时候，复制时间为2192，10 倍关系
             * buffer 字节数组为1024 * 100的时候，复制时间为463
             * 1024 * 1000 485
             * 8192 855
             *
             */
            byte[] buffer = new byte[8192];
            int len;

            while ((len = input.read(buffer)) != -1) {
                output.write(buffer, 0, len);
            }

            System.out.println("copy file from " + src + " to " + dest + " successfully");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Test
    public void testCopyFile() {
        long start = System.currentTimeMillis();

        String src = "D:\\ubuntu\\learn\\cpp\\yellow\\143.mp4";
        String dest = "D:\\ubuntu\\learn\\cpp\\yellow\\143_copy.mp4";
        copyFile(src, dest);

        long end = System.currentTimeMillis();

        System.out.println("total time = " + (end - start));
    }

    String src = "D:\\ubuntu\\learn\\cpp\\yellow\\143.mp4";
    String dest = "D:\\ubuntu\\learn\\cpp\\yellow\\143_copy.mp4";

    private void endoce(String src, String dest) {
        try (FileInputStream in = new FileInputStream(src);
             FileOutputStream out = new FileOutputStream(dest)) {

/*            int data;

            while ((data = in.read()) != -1) {
                out.write(data ^ 5);
            }*/

            byte[] buffer = new byte[1024];
            int len;

            while ((len = in.read(buffer)) != -1) {
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }
                out.write(buffer, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test011() {
        try (Reader reader = new FileReader(filePath);
             BufferedReader in = new BufferedReader(reader);
             BufferedWriter out = new BufferedWriter(new FileWriter(filePath.replace("baidu.html", "count.txt")))) {

            char[] buffer = new char[1024];
            int len = 0;
            Map<Character, Integer> map = new HashMap<>();

            while ((len = in.read(buffer)) != -1) {
                for (int i = 0; i < len; i++) {
                    if (map.containsKey(buffer[i])) {
                        map.put(buffer[i], map.get(buffer[i]) + 1);
                    } else {
                        map .put(buffer[i], 1);
                    }
                }
            }

            Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
            for (Map.Entry<Character, Integer> entry: entrySet) {
                out.write(entry.getKey() + ": " + entry.getValue());
                out.newLine();
            }

            System.out.println(map);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test013() throws IOException {
        String str = "hello中国";
        byte[] data = str.getBytes("UTF-8");

        ByteArrayInputStream bais = new ByteArrayInputStream(data);

        InputStreamReader isr = new InputStreamReader(bais, "GBK");

        FileOutputStream fos = new FileOutputStream(filePath);
        OutputStreamWriter osw = new OutputStreamWriter(fos);

        char[] buffer = new char[200];
        int len = 0;

        while ((len = isr.read(buffer)) != -1) {
            System.out.println(new String(buffer, 0, len));
            osw.write(buffer, 0, len);
        }
        osw.flush();
    }

}



