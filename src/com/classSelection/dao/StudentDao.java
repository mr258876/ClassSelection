package com.ClassSelection.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ClassSelection.dto.Student;
import com.ClassSelection.util.DBConnection;


public class StudentDao implements IntfStudentDao {
    // 获取学生对象
    public Student getStudent(SearchField field, String value) {
        // 编写sql语句
        String sql = null;
        switch (field){
            case SEARCH_UESRNAME:
                sql = "SELECT * FROM Users WHERE UserName = ?";
                break;
            case SEARCH_STUDENTID:
                sql = "SELECT * FROM Users WHERE Email = ?";
                break;
            default:
                break;
        }
        // 获得连接
        Connection conn = DBConnection.getConnection();
        // 返回数据集
        ResultSet rs = null;
        // 实例化一个Student对象
        Student student = null;
        try {
            // 准备sql语句
            PreparedStatement ps = conn.prepareStatement(sql);
            // 设置要传入的参数
            ps.setString(1, value);
            // 执行sql语句
            rs = ps.executeQuery();

            if (rs.next()) {
                // 把找到的结果set进User对象中
                student = new Student();
                student.setStudentID(rs.getString(1));
                student.setUserName(rs.getString(2));
                student.setStudentName(rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭连接
            DBConnection.closeConn(conn, null, rs);
        }
        return student;
    }


    @Override
    public Student getStudentByUserName(String UserName) {
        return getStudent(SearchField.SEARCH_UESRNAME, UserName);
    }

    @Override
    public Student getStudentBySID(String SID) {
        return getStudent(SearchField.SEARCH_STUDENTID, SID);
    }


    @Override
    public int updateStudent(Student student) {
        // 编写sql语句
        String sql = "UPDATE Users SET StudentID = ?, StudentName = ? WHERE UserName = ?";
        // 获得连接
        Connection conn = DBConnection.getConnection();
        // 返回受影响行数
        int rowsAffected = 0;
        try {
            // 用来发送sql语句的
            PreparedStatement ps = conn.prepareStatement(sql);
            // 设置要传入的参数
            ps.setString(1, student.getStudentID());
            ps.setString(2, student.getStudentName());
            ps.setString(3, student.getUserName());
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
