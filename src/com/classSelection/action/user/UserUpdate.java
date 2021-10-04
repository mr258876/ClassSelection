package com.ClassSelection.action.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ClassSelection.dao.UserDao;
import com.google.gson.JsonObject;

public class UserUpdate extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (session == null || session.getAttribute("userName") == null || session.getAttribute("userRole") == null
                || session.getAttribute("sensitiveAuth") == null) {
            returnJSON(resp, false, "身份验证失败");
            return;
        }

        String userName = (String) session.getAttribute("userName");
        UserDao dao = new UserDao();
        String val = req.getParameter("val");
        if (val == null || val.equals("")) {
            returnJSON(resp, false, "操作失败");
            return;
        }

        int result = 0;
        if (session.getAttribute("sensitiveAuth").equals("updatePassword")) {
            result = dao.updateUser(userName, "Email", val);
        } else if (session.getAttribute("sensitiveAuth").equals("updateEmail")) {
            result = dao.updateUser(userName, "PasswordSHA1", val);
        } else {
            returnJSON(resp, false, "身份验证失败");
            return;
        }

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