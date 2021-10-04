package com.ClassSelection.action.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ClassSelection.dao.UserDao;
import com.ClassSelection.dto.User;
import com.google.gson.JsonObject;

public class UserUpdate extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null || session.getAttribute("sensitiveAuth") == null) {
            returnJSON(resp, false, "身份验证失败");
            return;
        }

        UserDao dao = new UserDao();
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        if ((password == null || password.isEmpty() || password.length() != 40) && (email == null || email.isEmpty())) {
            returnJSON(resp, false, "操作失败");
            return;
        }

        User user = (User) session.getAttribute("user");
        if (!password.isEmpty()){
            user.setPasswordSHA1(password);
        }
        if (!email.isEmpty()){
            user.setEmail(email);
        }

        int result = 0;
        result = dao.updateUser(user);

        if (result != 1) {
            returnJSON(resp, false, "操作失败");
        } else {
            returnJSON(resp, true, "操作成功");
        }
    }

    private void returnJSON(HttpServletResponse resp, boolean result, String message)
            throws ServletException, IOException {
        JsonObject json = new JsonObject();
        PrintWriter out = resp.getWriter();
        json.addProperty("success", result);
        json.addProperty("message", message);
        out.println(json);
    }
}