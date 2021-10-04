package com.ClassSelection.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ClassSelection.dto.User;
import com.ClassSelection.dto.UserRole;
import com.ClassSelection.util.DBConnection;

public class UserDao implements IntfUserDao {
    // 获取用户对象
    public User getUser(String field, String value) {
        // 编写sql语句
        String sql = "SELECT * FROM Users WHERE ? = ?";
        // 获得连接
        Connection conn = DBConnection.getConnection();
        // 返回数据集
        ResultSet rs = null;
        // 实例化一个User对象
        User user = new User();
        try {
            // 用来发送sql语句的
            PreparedStatement ps = conn.prepareStatement(sql);
            // 设置要传入的参数
            ps.setString(1, field);
            ps.setString(2, value);
            // 执行sql语句
            rs = ps.executeQuery();

            if (rs.next()) {
                // 把找到的结果set进User对象中
                user.setUserName(rs.getString(1));
                user.setPasswordSHA1(rs.getString(2));
                user.setEmail(rs.getString(3));
                user.setUserRole(UserRole.getRole(rs.getString(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭连接
            DBConnection.closeConn(conn, null, rs);
        }
        return user;
    }

    // 根据用户名查找用户
    @Override
    public User getUserByName(String userName) {
        return getUser("UserName", userName);
    }

    // 根据邮箱查找用户
    @Override
    public User getUserByEmail(String email) {
        return getUser("Email", email);
    }

    // 更新用户信息(密码、邮箱或权限)
    @Override
    public int updateUser(String userName, String field, String value) {
        // 编写sql语句
        String sql = "UPDATE Users SET ? = ? WHERE UserName = ?";
        // 获得连接
        Connection conn = DBConnection.getConnection();
        // 返回受影响行数
        int rowsAffected = 0;
        try {
            // 用来发送sql语句的
            PreparedStatement ps = conn.prepareStatement(sql);
            // 设置要传入的参数
            ps.setString(1, field);
            ps.setString(2, value);
            ps.setString(3, userName);
            // 执行sql语句
            rowsAffected = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭连接
            DBConnection.closeConn(conn, null);
        }
        return rowsAffected;
    }

    @Override
    public int updateUser(User user) {
        // 编写sql语句
        String sql = "UPDATE Users SET PasswordSHA1 = ?, Email = ?, UserRole = ? WHERE UserName = ?";
        // 获得连接
        Connection conn = DBConnection.getConnection();
        // 返回受影响行数
        int rowsAffected = 0;
        try {
            // 用来发送sql语句的
            PreparedStatement ps = conn.prepareStatement(sql);
            // 设置要传入的参数
            ps.setString(1, user.getPasswordSHA1());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getUserRole().toString());
            ps.setString(4, user.getUserName());
            // 执行sql语句
            rowsAffected = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭连接
            DBConnection.closeConn(conn, null);
        }
        return rowsAffected;
    }
}