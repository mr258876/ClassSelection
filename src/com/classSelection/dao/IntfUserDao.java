package com.classSelection.dao;

import com.classSelection.dto.User;

public interface IntfUserDao {
    
    public User getUserByName(String userName);     //根据用户名查找用户
    public User getUserByEmail(String email);       //根据邮箱查找用户
}