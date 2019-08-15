package com.learn.javabasic.net.inetaddress;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

public class OReillyByNameTest {
    @Test
    public void test001() {
        try {
            InetAddress ip = InetAddress.getByName("www.huawei.com");
            System.out.println(ip.isReachable(2000));

            System.out.println(ip.getHostAddress());
            System.out.println(ip.getHostName());

            System.out.println("========");
            System.out.println(ip.getCanonicalHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test002() throws UnknownHostException {
        InetAddress ip = InetAddress.getByAddress(new byte[]{127, 0, 0, 0});
        System.out.println(ip.getHostName());
        System.out.println(ip.getHostAddress());
    }

    @Test
    public void test003() {
        try {
            String keyWord = URLDecoder.decode("%E6%9D%8E%E5%88%9A+j2ee", "UTF-8");
            System.out.println(keyWord);

            String urlStr = URLEncoder.encode(keyWord, "UTF-8");
            System.out.println(urlStr);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void download(int first, int last) {
        String savedPath = "D:\\ubuntu\\learn\\cpp\\yellow";
        for (int i = first; i < last; i++) {
            String url = "http://qwe2665.oss-cn-beijing.aliyuncs.com/" + i + ".mp4";
            saveUrlAs(url, savedPath, "GET", i);
        }
    }

    public File saveUrlAs(String url, String filePath, String method, int num) {
        //System.out.println("fileName---->"+filePath);
        //创建不同的文件夹目录
        File file = new File(filePath);
        //判断文件夹是否存在
        if (!file.exists()) {
            //如果文件夹不存在，则创建新的的文件夹
            file.mkdirs();
        }
        FileOutputStream fileOut = null;
        HttpURLConnection conn = null;
        InputStream inputStream = null;
        try {
            // 建立链接
            URL httpUrl = new URL(url);
            conn = (HttpURLConnection) httpUrl.openConnection();
            //以Post方式提交表单，默认get方式
            conn.setRequestMethod(method);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            // post方式不能使用缓存
            conn.setUseCaches(false);
            //连接指定的资源
            conn.connect();
            //获取网络输入流
            inputStream = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(inputStream);
            //判断文件的保存路径后面是否以/结尾
            if (!filePath.endsWith("/")) {

                filePath += "/";

            }
            //写入到文件（注意文件保存路径的后面一定要加上文件的名称）
            fileOut = new FileOutputStream(filePath + num + ".mp4");
            BufferedOutputStream bos = new BufferedOutputStream(fileOut);

            byte[] buf = new byte[409600];
            int length = bis.read(buf);
            //保存文件
            while (length != -1) {
                bos.write(buf, 0, length);
                length = bis.read(buf);
            }
            bos.close();
            bis.close();
            conn.disconnect();
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("抛出异常！！");
        }

        return file;

    }

    @Test
    public void test004() throws IOException {
        URL url = new URL("http://images.china-pub.com/ebook35001-40000/35850/shupi.jpg");
        InputStream is = url.openStream();
        URLConnection con = url.openConnection();
        long length = con.getContentLength();
        System.out.println(length);

    }

    private String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;

        try {
            String urlName = url + "?" + param;
            URL realUrl = new URL(urlName);

            URLConnection conn = realUrl.openConnection();
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1");

            conn.connect();

            Map<String, List<String>> map = conn.getHeaderFields();
            for (String key : map.keySet()) {
                System.out.println(key + "------>" + map.get(key));
            }

            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += "\n" + line;
            }
        } catch (Exception e) {
            System.out.println("send get with exception " + e);
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return result;
        }
    }

    @Test
    public void teest005() {
        String url = "https://www.baidu.com/s";
        String param = "wd=李东方&rsv_spt=1&rsv_iqid=0xb95e32180037d9c0&issp=1&f=8&rsv_bp=1&rsv_idx=2&ie=utf-8&tn=96898934_s_hao_pg&rsv_enter=1&rsv_dl=tb&rsv_sug3=10&rsv_sug1=9&rsv_sug7=100&rsv_t=aae5d7xIAygsSwJOVj6RsWFBSQCHYrYecDafoHgKAt%2BMXDEUZUtoYWiYTO%2BdZbmydoBJzQQQJQE&rsv_sug2=0&inputT=10634&rsv_sug4=10634";
        String result = sendGet(url, param);
        System.out.println(result);
    }

    class Student extends Person {
        public int getScore(String type) {
            return 99;
        }

        private int getGrade(int year) {
            return 1;
        }
    }

    @Report
    class Person {
        public String getName() {
            return "Person";
        }


    }

    @Test
    public void test006() throws NoSuchMethodException {

        Class stdClass = Student.class;

        System.out.println(stdClass.getMethod("getScore", String.class));
        System.out.println(stdClass.getMethod("getName"));

        System.out.println(stdClass.getDeclaredMethod("getGrade", int.class));

        Method method = stdClass.getDeclaredMethod("getGrade", int.class);

        System.out.println(method.getName());
        System.out.println(method.getModifiers());
        System.out.println(method.getReturnType());
        System.out.println(method.getParameterTypes());
        System.out.println(method.getParameterCount());
    }

    @Test
    public void test007() throws NoSuchMethodException {
        Class clazz = Runnable.class;
        Method method = clazz.getDeclaredMethod("run", void.class);
        System.out.println(method.getParameterAnnotations());
    }


    @Test
    public void test008() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String s = "Hello World";
        Method method = String.class.getMethod("substring", int.class);

        String r = (String) method.invoke(s, 6);
        System.out.println(r);

        System.out.println("========");

        Method m = Integer.class.getMethod("parseInt", String.class);

        Integer n = (Integer) m.invoke(null, "2435");
        System.out.println(n);
    }

    @Test
    public void test009() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        class Person {
            public void hello() {
                System.out.println("Person:hello");
            }
        }

        class Student extends Person {
            public void hello() {
                System.out.println("Student:hello");
            }
        }

        Method h = Person.class.getMethod("hello");
        h.invoke(new Person());
    }

    @Test
    public void test010() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor cons1 = Integer.class.getConstructor(int.class);
        Integer n1 = (Integer) cons1.newInstance(123);
        System.out.println(n1);

        System.out.println("=======");

        Class i = Integer.class;
        Class n = i.getSuperclass();
        System.out.println(n);
        System.out.println(n.getSuperclass());
        System.out.println();

        System.out.println("**********");
        System.out.println(Integer.class.isAssignableFrom(Integer.class));


    }

    interface Hello {
        void morning(String name);
    }

    @Test
    public void test011() {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);
                if (method.getName().equals("morning")) {
                    System.out.println("Good morning, " + args[0]);
                }
                return null;
            }
        };

        Hello hello = (Hello) Proxy.newProxyInstance(Hello.class.getClassLoader(), new Class[]{Hello.class}, handler);
        hello.morning("Bob");
    }

    /*@Resource("hello")
    class Hello {
        @Inject
        int n;

        @PostConstruct

    }*/

    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @interface Report {
        int type() default 0;

        String level() default "info";

        String value() default "";
    }


    @Test
    public void test012() {
        System.out.println(Person.class.isAnnotationPresent(Report.class));

        Report report = Person.class.getAnnotation(Report.class);
        int type = report.type();
        String level = report.level();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface Range {
        int min() default 0;

        int max() default 255;
    }

    public class Person1 {
        @Range(min=1, max=3)
        public String name;

        @Range(max=10)
        public String city;

        public int age;

        public Person1(String name, String city, int age) {
            this.name = name;
            this.city = city;
            this.age = age;
        }
    }

    private void check(Person1 person1) throws IllegalAccessException {
        for (Field field: person1.getClass().getFields()) {
            Range range = field.getAnnotation(Range.class);
            if (range != null) {
                Object value = field.get(person1);
                if (value instanceof String) {
                    String s = (String) value;

                    if (s.length() < range.max() || s.length() > range.max()) {
                        throw new IllegalArgumentException("Invalid field " + field.getName());
                    }
                }

            }
        }
    }

    @Test
    public void test013() throws IllegalAccessException {
        Person1 p1 = new Person1("Bob", "Beijing", 20);
        Person1 p2 = new Person1("", "Shanghai", 20);
        Person1 p3 = new Person1("Alice", "Shanghai", 199);
        for (Person1 p : new Person1[] { p1, p2, p3 }) {
            try {
                check(p);
                System.out.println("Person " + p + " checked ok.");
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                System.out.println("Person " + p + " checked failed: " + e);
            }
        }
    }
}
