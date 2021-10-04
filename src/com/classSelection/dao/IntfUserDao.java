package com.ClassSelection.dao;

import com.ClassSelection.dto.User;

public interface IntfUserDao {
    public User getUserByName(String userName);     //根据用户名查找用户
    public User getUserByEmail(String email);       //根据邮箱查找用户
    public int updateUser(User user);               //更新用户信息(密码、邮箱或权限)
    public int updateUser(String userName, String field, String value);
}