package com.classSelection.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.classSelection.dto.User;
import com.classSelection.util.DBConnection;

public class UserDao implements IntfUserDao {
    //根据用户名查找用户
    @Override
    public User getUserByName(String userName){
        //编写sql语句
        String sql = "SELECT * FROM Users WHERE UserName = ?";
        //获得连接
        Connection conn = DBConnection.getConnection();
        //返回数据集
        ResultSet rs = null;
        //实例化一个User对象
        User user = new User();
        try {
            //用来发送sql语句的
            PreparedStatement ps = conn.prepareStatement(sql);
            //设置要传入的参数，这里是userN
            ps.setString(1, userName);
            //执行sql语句
            rs=ps.executeQuery();
        
            if(rs.next()){
                //把找到的结果set进User对象中
                user.setUserName(rs.getString(1));
                user.setPasswordSHA1(rs.getString(2));
                user.setEmail(rs.getString(3));
                user.setUserRole(rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            //关闭连接
            DBConnection.closeConn(conn, null, rs);
        }
        return user;
    }


    //根据邮箱查找用户
    @Override
    public User getUserByEmail(String email) {
        // TODO Auto-generated method stub
        return null;
    }
}