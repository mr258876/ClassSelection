package com.ClassSelection.service;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ClassSelection.dto.User;
import com.ClassSelection.dto.UserRole;

public class LoginStatusFilter implements Filter {
    
    // protected UserRole role = null;
    // protected FilterConfig filterConfig = null;

    public void init(FilterConfig filterConfig) throws ServletException {
        // this.filterConfig = filterConfig;
        // String roleStr = filterConfig.getInitParameter("role");
        // if (roleStr != null && !roleStr.isEmpty()){
        //     this.role = UserRole.getRole(roleStr);
        // }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        
        if (user == null){
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }
        chain.doFilter(request, response);
    }

    public void destroy() {
        // this.role = null;
        // this.filterConfig = null;
    }
}
