package com.demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class ServletConfigDemo1 extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramVal = getServletConfig().getInitParameter("name");
        PrintWriter out = resp.getWriter();
        out.print(paramVal);


        out.print("<hr/>");
        Enumeration<String> enumeration = getServletConfig().getInitParameterNames();
        while (enumeration.hasMoreElements()) {
            String name = enumeration.nextElement();
            String value = getServletConfig().getInitParameter(name);
            out.print("name = " + name + ", value = " + value);
            out.print("<br/>");
        }


    }
}
