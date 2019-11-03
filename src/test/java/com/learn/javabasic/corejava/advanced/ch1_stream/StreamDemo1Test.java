package com.learn.javabasic.corejava.advanced.ch1_stream;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StreamDemo1Test {
    @Test
    public void test001() throws IOException {
        String path = "D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet\\src\\main\\resources\\ioc1.xml";

        String contents = new String(Files.readAllBytes(
                Paths.get(path)), StandardCharsets.UTF_8); // Read file into string
    }

}

