package com.demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Date;

public class ServletDemo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.setHeader("Content-Type", "text/html;charset=UTF-8");
        //OutputStream outputStream = resp.getOutputStream();
        //outputStream.write("<meta http-equiv='content-type' content='text/html;charset=UTF-8'>".getBytes());
        //outputStream.write("hello".getBytes("UTF-8"));
        //outputStream.write("你好".getBytes("UTF-8"));
        //resp.setContentType("text/html;charset=UTF-8");
        //PrintWriter out = resp.getWriter();
        //out.write("China");
        //out.write("中国");

        resp.setHeader("Refresh", "3");
        resp.getWriter().write("time is " + new Date(System.currentTimeMillis()));

        String ss = "fsdfhsdfhuisdhfusdhfuidsfsdfhsdfhuisdhfusdhfuidsfsdfhsdfhuisdhfusdhfuids"
                + "fsdfhsdfhuisdhfusdhfuidsfsdfhsdfhuisdhfusdhfuidsfsdfhsdfhuisdhfusdhfuids"
                + "fsdfhsdfhuisdhfusdhfuidsfsdfhsdfhuisdhfusdhfuidsfsdfhsdfhuisdhfusdhfuids"
                + "fsdfhsdfhuisdhfusdhfuidsfsdfhsdfhuisdhfusdhfuidsfsdfhsdfhuisdhfusdhfuids"
                + "fsdfhsdfhuisdhfusdhfuidsfsdfhsdfhuisdhfusdhfuidsfsdfhsdfhuisdhfusdhfuids"
                + "fsdfhsdfhuisdhfusdhfuidsfsdfhsdfhuisdhfusdhfuidsfsdfhsdfhuisdhfusdhfuids"
                + "fsdfhsdfhuisdhfusdhfuidsfsdfhsdfhuisdhfusdhfuidsfsdfhsdfhuisdhfusdhfuids"
                + "fsdfhsdfhuisdhfusdhfuidsfsdfhsdfhuisdhfusdhfuidsfsdfhsdfhuisdhfusdhfuids"
                + "fsdfhsdfhuisdhfusdhfuidsfsdfhsdfhuisdhfusdhfuidsfsdfhsdfhuisdhfusdhfuids"
                + "fsdfhsdfhuisdhfusdhfuidsfsdfhsdfhuisdhfusdhfuidsfsdfhsdfhuisdhfusdhfuids"
                + "fsdfhsdfhuisdhfusdhfuidsfsdfhsdfhuisdhfusdhfuidsfsdfhsdfhuisdhfusdhfuids"
                + "fsdfhsdfhuisdhfusdhfuidsfsdfhsdfhuisdhfusdhfuidsfsdfhsdfhuisdhfusdhfuids"
                + "fsdfhsdfhuisdhfusdhfuidsfsdfhsdfhuisdhfusdhfuidsfsdfhsdfhuisdhfusdhfuids"
                + "fsdfhsdfhuisdhfusdhfuidsfsdfhsdfhuisdhfusdhfuidsfsdfhsdfhuisdhfusdhfuids"
                + "fsdfhsdfhuisdhfusdhfuidsfsdfhsdfhuisdhfusdhfuidsfsdfhsdfhuisdhfusdhfuids"
                + "fsdfhsdfhuisdhfusdhfuidsfsdfhsdfhuisdhfusdhfuidsfsdfhsdfhuisdhfusdhfuids"
                + "fsdfhsdfhuisdhfusdhfuidsfsdfhsdfhuisdhfusdhfuidsfsdfhsdfhuisdhfusdhfuids"
                + "fsdfhsdfhuisdhfusdhfuidsfsdfhsdfhuisdhfusdhfuidsfsdfhsdfhuisdhfusdhfuids"
                + "fsdfhsdfhuisdhfusdhfuidsfsdfhsdfhuisdhfusdhfuidsfsdfhsdfhuisdhfusdhfuids"
                + "fsdfhsdfhuisdhfusdhfuidsfsdfhsdfhuisdhfusdhfuidsfsdfhsdfhuisdhfusdhfuids";

        resp.getWriter().println("length = " + ss.length());
        resp.getWriter().println(ss);
    }
}
