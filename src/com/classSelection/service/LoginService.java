package com.classSelection.service;

import com.classSelection.dto.User;
import com.classSelection.dao.UserDao;

public class LoginService {
    public boolean userLogin(String userName, String passwordSHA1){
        UserDao dao = new UserDao();
        User user = dao.getUserByName(userName);
        System.out.println(user);
        return user != null && passwordSHA1.equals(user.getPasswordSHA1()) ? true : false;
    }
}
