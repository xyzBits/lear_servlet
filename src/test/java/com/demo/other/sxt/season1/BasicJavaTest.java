package com.demo.other.sxt.season1;


import org.junit.Test;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.math.BigDecimal;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class BasicJavaTest {
    @Test
    public void tets001() {
        final double PI = 3.14;
        System.out.println(PI);
        final List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        //list = new LinkedList<>();
        System.out.println(new ArrayList<Integer>().hashCode());
        System.out.println(new ArrayList<Integer>().hashCode());
    }

    @Test
    public void test002() {
        System.out.println(044);
        float f1 = 423432424f;
        float f2 = f1 + 1;
        System.out.println(f1 == f2);

        BigDecimal bd = BigDecimal.valueOf(1.0);
        bd = bd.subtract(BigDecimal.valueOf(0.1));
        bd = bd.subtract(BigDecimal.valueOf(0.1));
        bd = bd.subtract(BigDecimal.valueOf(0.1));
        bd = bd.subtract(BigDecimal.valueOf(0.1));
        bd = bd.subtract(BigDecimal.valueOf(0.1));
        System.out.println(bd);
        System.out.println(1.0 - 0.1 - 0.1 - 0.1 - 0.1 - 0.1);
        System.out.println('\u4e2d');

        System.out.println('\'');
        System.out.println('a' + 'b');
        byte ii = 2;
        byte jj = 4;
        System.out.println(ii + jj);
    }

    @Test
    public void test003() {
        byte a = 1;
        byte b = 2;
        //byte c = a + b;

        int d = 3;
        int e = 5;
        int f = d + e;

        short g = 4;
        short h = 7;
        //short i = g + h;

        //short k = a + g;

        float f1 = 3.3F;
        float f2 = 3.4F;
        float f3 = f1 + f2;


    }

    @Test
    public void test004() {
        int a = 1;
        int b = a++;
        System.out.println(b + "\t" + a);

        b = ++a;
        System.out.println(b + "\t" + a);

        System.out.println(b + "\n" + a);

        char a1 = 'a';
        System.out.println(a1 + 0);
    }

    @Test
    public void test() {
        try {
            Thread.sleep(100L);
            FileInputStream fileInputStream = new FileInputStream("");
        } catch (InterruptedException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test005() {
        System.out.println(3 << 2);
        System.out.println(3 + 2 + "2");
    }

    @Test
    public void test006() {
        int x = 1;
        int y = (x == 1) ? 2 : 3;
        System.out.println(y);
    }

    @Test
    public void test007() {
        System.out.println(1 / 0);
    }

    @Test
    public void test008() {
        FileReader reader = null;
        try {
            System.exit(0);
            reader = new FileReader("d:/a.txt");
            char c = (char) reader.read();
            char c2 = (char) reader.read();
            System.out.println("" + c + c2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test009() throws IllegalAgeException {
        Person person = new Person();
        person.setAge(-9);
    }

    @Test
    public void test010() {
        //System.out.println(File.separatorChar);
        String path = "D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet\\src\\main\\resources\\IMG_1530.CR2";
        File src = new File(path);
        System.out.println(src.length());

        src = new File("D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet\\src\\main\\", "resources\\IMG_1530.CR2");
        System.out.println(src.length());


        src = new File(new File("D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet\\src\\main\\"), "resources\\IMG_1530.CR2");
        System.out.println(src.length());
    }

    @Test
    public void test011() {
        String path = "D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet\\src\\main\\resources\\IMG_1530.CR2";
        File src = new File(path);
        System.out.println(src.getAbsolutePath());
        System.out.println(src.getPath());

        System.out.println("work dir = " + System.getProperty("user.dir"));

        src = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\IMG_1530.CR2");
        System.out.println(src.getPath());
        System.out.println(src.exists());

    }

    @Test
    public void test012() {
        String path = "src\\main\\resources\\IMG_1530.CR2";
        File src = new File(path);
        System.out.println(src.getName());
        System.out.println(src.getPath());
        System.out.println(src.getAbsolutePath());
        System.out.println(src.getParent());
        System.out.println(src.getParentFile().getName());
    }

    @Test
    public void test013() {
        String path = "D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet\\src\\main\\resources\\IMG_1530.CR2";
        File src = new File(path);
        System.out.println(src.exists());
        System.out.println(src.isFile());
        System.out.println(src.isDirectory());
        System.out.println(src.length() / 1024. / 1024.);
    }

    @Test
    public void test014() throws IOException {
        String path = "D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet\\src\\main\\resources\\IMG_1531.CR2";
        File src = new File(path);
        //System.out.println(src.createNewFile());
        System.out.println(src.delete());


    }

    @Test
    public void test015() {
        String path = "D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet\\src\\main\\resources\\test\\binv";
        File src = new File(path);
        System.out.println(src.mkdir());
        System.out.println(src.mkdirs());
        src.delete();
    }

    @Test
    public void test016() {
        String path = "D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet\\src\\main\\resources";
        File src = new File(path);
        String[] subNames = src.list();
        System.out.println(Arrays.toString(subNames));

        File[] subFile = src.listFiles();
        for (File file : subFile) {
            System.out.println(file.getAbsolutePath());
        }

        System.out.println(src.listRoots()[0]);

    }

    @Test
    public void test017() {
        String path = "D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet";
        File src = new File(path);
        printAllFile(src, 1);

    }

    private void printAllFile(File src, int deep) {
        System.out.println(src.getAbsolutePath());
        for (int i = 0; i <= deep; i++) {
            System.out.print("-");
        }

        if (src.isDirectory()) {
            File[] files = src.listFiles();
            for (File file : files) {
                printAllFile(file, deep++);
            }
        }
    }


    @Test
    public void test018() throws UnsupportedEncodingException {
        String msg = "性命生命使命a";
        byte[] datas = msg.getBytes();
        System.out.println(Arrays.toString(datas));
        System.out.println(datas.length);

        String decode = new String(datas, "UTF-8");
        System.out.println(decode);

        System.out.println("============");
        datas = msg.getBytes("UTF-16LE");
        System.out.println(Arrays.toString(datas));
        System.out.println(datas.length);

        datas = msg.getBytes("GBK");
        System.out.println(Arrays.toString(datas));
        System.out.println(datas.length);

    }

    @Test
    public void test019() {
        String path = "D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet\\src\\main\\resources\\test\\abc.txt";
        File src = new File(path);

        try {
            InputStream is = new FileInputStream(src);

            int data1 = is.read();
            int data2 = is.read();
            int data3 = is.read();
            int data4 = is.read();
            System.out.println((char) data1);
            System.out.println((char) data2);
            System.out.println((char) data3);
            System.out.println(data4);
            System.out.println(is.read());

            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test020() {
        String path = "D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet\\src\\main\\resources\\test\\abc.txt";
        File src = new File(path);
        InputStream is = null;

        try {
            is = new FileInputStream(src);

            int temp = 0;
            while ((temp = is.read()) != -1) {
                System.out.println(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @Test
    public void test021() {
        String path = "D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet\\src\\main\\resources\\test\\abc.txt";
        File src = new File(path);
        InputStream is = null;

        try {
            is = new FileInputStream(src);

            int temp = 0;

            while ((temp = is.read()) != -1) {
                System.out.println((char) temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test022() {
        String path = "D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet\\src\\main\\resources\\test\\abc.txt";
        File src = new File(path);

        InputStream is = null;

        try {
            is = new FileInputStream(src);
            byte[] fulsh = new byte[1024];
            int len = -1;

            while ((len = is.read(fulsh)) != -1) {
                System.out.println(len);
                System.out.println(new String(fulsh, 0, len));
                System.out.println("--------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test023() {
        String path = "D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet\\src\\main\\resources\\test\\def.txt";
        File dest = new File(path);

        OutputStream os = null;

        try {
            os = new FileOutputStream(dest, true);
            String msg = "IO is so easy\r\n";
            int temp = 0;
            byte[] datas = msg.getBytes("UTF-8");
            os.write(datas, 0, datas.length);
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void copyFile(String srcPath, String destPath) {
        File src = new File(srcPath);
        File dest = new File(destPath);

        InputStream is = null;
        OutputStream os = null;

        try {
            is = new FileInputStream(src);
            os = new FileOutputStream(destPath);

            byte[] flush = new byte[1024];
            int len = 0;

            while ((len = is.read(flush)) != -1) {
                os.write(flush, 0, len);
                os.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) {
                    os.close();
                }

                if (is != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test024() {
        String srcPath = "D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet\\src\\test\\java\\com\\demo\\other\\sxt\\season1\\BasicJavaTest.java";
        String destPath = "D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet\\src\\main\\resources\\test\\def.CR2";

        copyFile(srcPath, destPath);
    }

    @Test
    public void test025() {
        String srcPath = "D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet\\src\\main\\resources\\test\\abc.txt";
        File src = new File(srcPath);
        Reader reader = null;
        try {
            reader = new FileReader(src);
            char[] flush = new char[1024];
            int len = -1;

            while ((len = reader.read(flush)) != -1) {
                System.out.println(len);
                System.out.println(flush[0]);
                System.out.println(new String(flush, 0, len));
                System.exit(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test026() {
        String destPath = "D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet\\src\\main\\resources\\test\\abc.txt";
        File dest = new File(destPath);

        Writer writer = null;
        try {
            writer = new FileWriter(dest, true);
            String msg = "\r\n哈哈哈";
            writer.write(msg);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void cpFile(String srcpath, String destPath, boolean flag) {
        File src = new File(srcpath);
        File dest = new File(destPath);

        Reader reader = null;
        Writer writer = null;
        try {
            reader = new FileReader(src);
            writer = new FileWriter(dest, flag);

            char[] flush = new char[1024];
            int len = 0;
            while ((len = reader.read(flush)) != -1) {
                writer.write(flush);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test027() {
        String srcPath = "D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet\\src\\test\\java\\com\\demo\\other\\sxt\\season1\\BasicJavaTest.java";
        String destPath = "D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet\\src\\main\\resources\\test\\abc.txt";
        cpFile(srcPath, destPath, true);
    }

    @Test
    public void test028() {
        byte[] src = "talk is cheap, show me the code".getBytes();
        InputStream is = null;
        try {
            is = new ByteArrayInputStream(src);
            byte[] flush = new byte[5];
            int len = -1;
            while ((len = is.read(flush)) != -1) {
                System.out.println(new String(flush, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test029() {
        String srcPath = "D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet\\src\\main\\resources\\test\\abc.txt";
        File src = new File(srcPath);
        try (InputStream is = new FileInputStream(src)) {
            byte[] datas = new byte[9];
            System.out.println(is.read(datas, 2, 3));

            System.out.println(Arrays.toString(datas));
            System.out.println(new String(datas, "UTF-8"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test030() {
        char ch = '中';
        System.out.println(ch);
        String srcPath = "D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet\\src\\main\\resources\\test\\abc.txt";
        String destPath = "D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet\\src\\main\\resources\\test\\dddd.txt";


        File src = new File(srcPath);
        File dest = new File(destPath);
        try (InputStream is = new FileInputStream(src);
             Reader reader = new FileReader(src);
             OutputStream os = new FileOutputStream(dest);
             Writer writer = new FileWriter(dest)
        ) {
            char[] buff = new char[10];
            int len = reader.read(buff, 2, 6);
            System.out.println(len);
            System.out.println(Arrays.toString(buff));

            writer.write(buff, 4, 3);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test031() {
        try {
            URL url = new URL("https://www.dianping.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.157 Safari/537.36");
            InputStream is = connection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String msg = null;
            while ((msg = br.readLine()) != null) {
                System.out.println(msg);
            }

            br.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test032() {
        try {
            DatagramSocket client = new DatagramSocket(8888);
            String data = "你好东方";
            byte[] datas = data.getBytes();

            DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 9999));
            client.send(packet);
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test033() {
        try {
            DatagramSocket server = new DatagramSocket(8888);

            byte[] contatiner = new byte[1024 * 60];
            DatagramPacket packet = new DatagramPacket(contatiner, 0, contatiner.length);

            server.receive(packet);

            byte[] datas = packet.getData();
            String data = new String(datas, 0, datas.length);
            System.out.println(data);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test034() throws Exception {
        Class clazz = new Iphone().getClass();
        clazz = Iphone.class;
        clazz = Class.forName("com.demo.other.sxt.season1.Iphone");

        Iphone iphone = (Iphone) clazz.newInstance();
        iphone = (Iphone) clazz.getConstructor().newInstance();
        System.out.println(iphone);
    }

    @Test
    public void test035() throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        SAXParser parser = factory.newSAXParser();
        PersonHandler handler = new PersonHandler();
        InputStream is = new FileInputStream("D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet\\src\\main\\resources\\test\\person.xml");
        parser.parse(is, handler);


    }

    @Test
    public void test036() {
        Collection<String> coll = new ArrayList<>();
        coll.add("hello");
        coll.add("alex");
        System.out.println(coll.contains("hello"));
        System.out.println(coll);
        System.out.println(coll.toArray());
        coll.clear();
        System.out.println(coll);
    }

    private void getAllDir(File dir) {
        File[] files = dir.listFiles();
        for (File file: files) {
            if (file.isDirectory()) {
                getAllDir(file);
            } else {
                System.out.println(file);
            }
        }
    }
}

class PersonHandler extends DefaultHandler {
    @Override
    public void startDocument() throws SAXException {
        System.out.println("开始解析文档");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("结束解析文档");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println(qName + " 解析开始");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length).trim();
        if (content.length() > 0) {
            System.out.println("内容为 " + new String(ch, start, length));
        } else {
            System.out.println("内容为： " + "空");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println(qName + " 解析结束");
    }
}

class PersonXXX {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public PersonXXX() {
    }

    public PersonXXX(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Iphone {
    public Iphone() {

    }
}

class Person {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws IllegalAgeException {
        if (age < 0) {
            throw new IllegalAgeException("age should be great than zero");
        }
        this.age = age;
    }
}

class IllegalAgeException extends Exception {
    public IllegalAgeException() {

    }

    public IllegalAgeException(String message) {
        super(message);
    }
}