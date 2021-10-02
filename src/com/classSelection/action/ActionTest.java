package com.classSelection.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;


public class ActionTest extends HttpServlet {
    @Override
    public void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.io.IOException, javax.servlet.ServletException{
        response.setContentType("text/html; charset=GB 2312");
        PrintWriter pw= response.getWriter();
        pw.println("<h1>Hello Servlet!</h1>");
        pw.println("<h1>Servlet 测试！</h1>");
    }

    @Override
    public void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.io.IOException, javax.servlet.ServletException{

    }
}
