package com.ClassSelection.action.classes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

public class SearchClass extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JsonObject json = new JsonObject();
        json.addProperty("success", false);
        json.addProperty("message", "未定义");
        // json.addProperty("data", new ArrayList()<>);
        PrintWriter out = resp.getWriter();
        out.println(json);
    }
}
