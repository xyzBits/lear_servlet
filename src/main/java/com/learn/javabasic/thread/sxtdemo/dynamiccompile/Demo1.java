package com.learn.javabasic.thread.sxtdemo.dynamiccompile;


import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class Demo1 {
    public static void main(String[] args) throws IOException {
        // 通过io流，将字符 串转换成一个临时文件，HelloWorld.java 再调用动态编译方法
        String str = "public class HelloWorld {\n" +
                "\tpublic static void main(String[] args) {\n" +
                "\t\tSystem.out.println(\"Hello World\");\n" +
                "\t}\n" +
                "}";


        // 动态编译类
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        String path = "D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\simple\\HelloWorld.java";
        int result = compiler.run(null, null, null, path);
        System.out.println(result == 0 ? "编译成功" : "编译失败");

        System.out.println("开通执行");

        // 动态运行类
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("java -cp D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\simple HelloWorld");

        InputStream is = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String info = "";
        while ((info = reader.readLine()) != null) {
            System.out.println(info);
        }

        // 使用反射动态运行
        System.out.println("使用反射动态运行----------->");
        try {
            URL[] urls = new URL[]{new URL("file:\\" + "D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\simple\\")};
            URLClassLoader loader = new URLClassLoader(urls);
            Class clazz = loader.loadClass("HelloWorld");
            // 调用加载类的main方法
            Method mainMethod = clazz.getMethod("main", String[].class);
            mainMethod.invoke(null, (Object) new String[]{});
            // 由于可变参数是jdk5.0之后 才有的，上面的代码传动编译时mainMethod.invoke(null, "aa", "bb")，就发生参数个数 不匹配
            // 因此，要加上(Object)参数转型，避免这个问题
            // public static void mm(String[] a, String[] b)
            // public static void main(String[] args)
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
