package com.learn.javabasic.thread.sxtdemo.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlDeo1 {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.baidu.com");
/*        InputStream is = url.openStream();

        byte[] flush = new byte[1024];
        int len = 0;

        while ((len = is.read(flush)) != -1) {
            System.out.println(new String(flush, 0, len));
        }

        is.close();*/

        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "utf-8"));
        String path = "D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet\\src\\main\\resources\\test\\baidu.html";
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "utf-8"));
        String msg = null;
        while ((msg = br.readLine()) != null) {
            /*System.out.println(msg);*/
            bw.write(msg);
            bw.newLine();
        }

        bw.flush();
        bw.close();

        br.close();


    }
}
