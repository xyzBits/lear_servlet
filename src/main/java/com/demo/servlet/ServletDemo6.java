package com.demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

public class ServletDemo6 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 /*       String path = this.getServletContext().getRealPath("/download/IMG_1659.JPG");
        System.out.println(path);
        FileInputStream fileInputStream = new FileInputStream(path);
        String fileName = "李慧.JPG";
        System.out.println(fileName);

        resp.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));

        int len = 0;
        byte[] bytes = new byte[1024];
        ServletOutputStream servletOutputStream = resp.getOutputStream();
        while ((len = fileInputStream.read(bytes)) > 0) {
            servletOutputStream.write(bytes, 0, len);
        }

        servletOutputStream.close();
        fileInputStream.close();*/


        resp.getWriter().println(this.getServletContext().getAttribute("sharedData"));
    }
}
