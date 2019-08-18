package com.learn.thread;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

public class ObjectStreamTest {
    private final String path = "D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet\\src\\main\\resources\\test\\baidu.html";

    @Test
    public void test001() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
        oos.writeObject("hello");
        oos.writeObject(new int[]{1, 2, 3, 4, 5});
        oos.writeObject(new Person("lidongfang", 33));
        oos.flush();
        oos.close();
    }

    @Test
    public void test002() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        String str = (String) ois.readObject();
        int[] arr = (int[]) ois.readObject();

        Person person = (Person) ois.readObject();
        System.out.println(person);
        System.out.println(str);
        System.out.println(Arrays.toString(arr));

        ois.close();
    }
}

class Person implements Serializable {
    private static final long erialVersionUID = 65454265L;
    private String name;
    private int age;
    private int id;

    public Person(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}