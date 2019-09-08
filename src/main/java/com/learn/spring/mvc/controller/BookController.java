package com.learn.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * rest请求
 */
@RequestMapping(value = "/shopping")
@Controller
public class BookController {

    @RequestMapping(value = "/book/{bookId}", method = RequestMethod.POST)
    public String addBook(@PathVariable("bookId") String bookId) {
        System.out.println("新增" + bookId + " 号图书...................");
        System.out.println(this.getClass());
        return "success";
    }

    @RequestMapping(value = "/book/{bookId}", method = RequestMethod.GET)
    public String getBook(@PathVariable("bookId") String bookId) {
        System.out.println("查询" + bookId + " 号图书...................");
        return "success";
    }

    @RequestMapping(value = "/book/{bookId}", method = RequestMethod.PUT)
    public String updateBoook(@PathVariable("bookId") String bookId) {
        System.out.println("更新" + bookId + " 号图书...................");

        return "success";
    }


    @RequestMapping(value = "/book/{bookId}", method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable("bookId") String bookId) {
        System.out.println("删除" + bookId + " 号图书...................");

        return "success";
    }


}
