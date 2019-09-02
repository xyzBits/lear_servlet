package com.learn.spring.ioc.bean;

public class Book {
    private String name;
    private String author;

    public void myInit() {
        System.out.println("Book类的初始化方法 。。。。。");
    }

    public void myDestory() {
        System.out.println("Book类的销毁方法。。。。。。");
    }

    public Book() {
        System.out.println("Book()的无参构造方法被 调用 。。。。。");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
