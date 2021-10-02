package com.classSelection.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.classSelection.dao.UserDao;
import com.classSelection.dto.User;

public class Login extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String passwordSHA1 = req.getParameter("password");

        UserDao dao = new UserDao();
        User user = dao.getUserByName(userName);
        boolean flag = user != null && passwordSHA1.equals(user.getPasswordSHA1()) ? true : false;

        if(flag){
            // 将用户名、权限添加至session
            req.getSession().setAttribute("userName", userName);
            req.getSession().setAttribute("userRole", user.getUserRole());
            // 将SESSIONID写入cookie
            Cookie cookie = new Cookie("JSESSIONID", (String)req.getSession().getId());
            cookie.setMaxAge(60*10);
            resp.addCookie(cookie);
            // 跳转至登录后首页
            resp.sendRedirect("welcome.html");
        }
        else{
            resp.sendRedirect("login.html?loginFail=true");
        }
    }
}
