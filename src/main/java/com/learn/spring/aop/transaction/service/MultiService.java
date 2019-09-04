package com.learn.spring.aop.transaction.service;

import com.learn.spring.aop.transaction.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MultiService {
    @Autowired
    private BookDao bookDao;

    /**
     * Propagation.REQUIRED 使用大事务的事务
     * Propagation。REQUIRES_NEW 开启新的事务
     * @param userName
     * @param isbn
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void checkout(String userName, String isbn) {
        bookDao.updateBookStock(isbn);

        int price = bookDao.getPrice(isbn);

        bookDao.updateBalance(userName, price);
    }
}
