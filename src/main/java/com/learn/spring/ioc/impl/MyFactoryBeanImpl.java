package com.learn.spring.ioc.impl;

import com.learn.spring.ioc.bean.Book;
import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBeanImpl implements FactoryBean<Book> {
    @Override
    public Book getObject() throws Exception {
        System.out.println("MyFactoryBean创建对象");
        Book book = new Book();
        book.setName("京瓶梅");
        return book;
    }

    @Override
    public Class<?> getObjectType() {
        return Book.class;
    }

    @Override
    public boolean isSingleton() {
        return true; //就算是单实例，也不会在启动时创建，这是例外
    }
}
