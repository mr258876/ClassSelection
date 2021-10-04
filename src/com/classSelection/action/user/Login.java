package com.ClassSelection.action.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ClassSelection.dao.UserDao;
import com.ClassSelection.dto.User;
import com.google.gson.JsonObject;

public class Login extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String passwordSHA1 = req.getParameter("password");
        String sensitiveAuth = req.getParameter("s-auth");
        // 查找用户并确认密码
        UserDao dao = new UserDao();
        User user = dao.getUserByName(userName);
        boolean flag = user != null && passwordSHA1.equals(user.getPasswordSHA1()) ? true : false;
        // 创建JSON对象
        JsonObject json = new JsonObject();

        if(flag){
            // 将用户名、权限添加至session
            req.getSession().setAttribute("userName", userName);
            req.getSession().setAttribute("userRole", user.getUserRole());
            if (sensitiveAuth != null){
                req.getSession().setAttribute("sensitiveAuth", sensitiveAuth);
            }
            // 将SESSIONID写入cookie
            Cookie cookie = new Cookie("JSESSIONID", (String)req.getSession().getId());
            cookie.setPath("/ClassSelection.Auth");
            cookie.setMaxAge(600);
            resp.addCookie(cookie);
            // 登陆成功返回json
            json.addProperty("loginStatus", true);
            json.addProperty("message", "登录成功");
        }
        else{
            // 登陆失败返回json
            json.addProperty("loginStatus", false);
            json.addProperty("message", "登录失败，请检查用户名与密码");
        }
        
        PrintWriter out = resp.getWriter();
        out.println(json);
    }
}
