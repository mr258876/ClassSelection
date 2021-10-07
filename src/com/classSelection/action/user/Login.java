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

public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String passwordSHA1 = req.getParameter("password");
        String sensitiveAuth = req.getParameter("s-auth");
        // 创建JSON对象
        JsonObject json = new JsonObject();
        PrintWriter out = resp.getWriter();
        if (userName == null || passwordSHA1 == null){
            json.addProperty("loginStatus", false);
            json.addProperty("message", "操作失败");
            out.println(json);
            return;
        }

        // 查找用户并确认密码
        UserDao dao = new UserDao();
        User user = dao.getUserByName(userName);
        boolean flag = user != null && user.getPasswordSHA1().equals(passwordSHA1) ? true : false;

        if (flag) {
            // 将用户名、权限添加至session
            req.getSession().setAttribute("user", user);
            if (sensitiveAuth != null) {
                req.getSession().setAttribute("sensitiveAuth", sensitiveAuth);
            }
            // 将SESSIONID写入cookie
            Cookie cookie = new Cookie("JSESSIONID", (String) req.getSession().getId());
            cookie.setMaxAge(600);
            resp.addCookie(cookie);
            // 登陆成功返回json
            json.addProperty("loginStatus", true);
            json.addProperty("message", "登录成功");
        } else {
            // 登陆失败返回json
            json.addProperty("loginStatus", false);
            json.addProperty("message", "用户名或密码错误");
        }

        out.println(json);
    }
}
