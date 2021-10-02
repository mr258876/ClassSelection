package com.classSelection.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.classSelection.service.LoginService;

public class Login extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String passwordSHA1 = req.getParameter("password");

        LoginService service = new LoginService();
        //调用service方法 把用户名 密码传入给service
        boolean flag = service.userLogin(userName, passwordSHA1);
 
        if(flag){
            resp.sendRedirect("welcome.html");
        }
        else{
            resp.sendRedirect("login.html");
        }
    }
}
