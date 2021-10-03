package com.classSelection.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

public class Auth extends HttpServlet {
    // Class Auth 用于处理用户短时间内使用有效SessionID登录
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 通过cokie获取SessionID
        Cookie[] cookies = null;
        cookies = req.getCookies();
        String sessionID = null;
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName() == "JSESSIONID") {
                    sessionID = c.getValue();
                    break;
                }
            }
        }

        // 创建JSON对象
        JsonObject json = new JsonObject();

        if (sessionID == null) {
            // 若Cookie中没有SessionID则登录失败
            json.addProperty("success", false);
            json.addProperty("message", "请登录");
        } else if (!((String) req.getSession().getId()).equals(sessionID)) {
            // 若当前SessionID不同于cookie中的SessionID同样登录失败
            json.addProperty("success", false);
            json.addProperty("message", "请重新登录");
        } else {
            // 若存在session则尝试访问attr，正常则登录成功
            if (req.getSession().getAttribute("userName") != null
                    && req.getSession().getAttribute("userRole") != null) {
                json.addProperty("success", true);
                json.addProperty("message", "登录成功");
            } else {
                json.addProperty("success", false);
                json.addProperty("message", "请重新登录");
            }
        }

        Cookie cookie = new Cookie("JSESSIONID", (String) req.getSession().getId());
        cookie.setMaxAge(600);
        resp.addCookie(cookie);

        PrintWriter out = resp.getWriter();
        out.println(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
