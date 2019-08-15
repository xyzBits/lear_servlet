package com.learn.spring.helloioc;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Demo1 {
    public static void main(String[] args) throws UnsupportedEncodingException {
/*        ApplicationContext context = new FileSystemXmlApplicationContext("D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet\\src\\main\\resources\\bean-demo.xml");
        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
        helloWorld.sayHello();*/

/**
 *转成字节数组时，用什么编码，解码时，要用相应的编码，不然会出错
 */

        String data = "中国";
        byte[] buffer = data.getBytes("utf-8");
        System.out.println(Arrays.toString(buffer));
        System.out.println(new String(buffer, 0, buffer.length, "utf-8"));


        buffer = data.getBytes("GB2312");
        System.out.println(Arrays.toString(buffer));

        System.out.println(new String(buffer, 0, buffer.length, "GB2312"));
    }
}
