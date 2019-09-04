package com.learn.spring.aop.transaction.service;

import com.learn.spring.aop.transaction.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;


    /**
     * 默认发生运行时异常回滚，编译时异常不会回滚
     *
     * 同一个类中的方法，都用一个事务
     * @param userName
     * @param isbn
     */
    @Transactional(timeout = 3,
    readOnly = true,
    propagation = Propagation.REQUIRED,
    rollbackFor = FileNotFoundException.class,
    noRollbackFor = {ArithmeticException.class, NullPointerException.class},
    isolation = Isolation.READ_COMMITTED) //提交后再读取
    public void checkout(String userName, String isbn) {
        bookDao.updateBookStock(isbn);

        int price = bookDao.getPrice(isbn);

        bookDao.updateBalance(userName, price);
    }



}
