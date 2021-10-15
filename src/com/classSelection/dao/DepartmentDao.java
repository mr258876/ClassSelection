package com.ClassSelection.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ClassSelection.dto.Department;
import com.ClassSelection.util.DBConnection;

public class DepartmentDao implements IntfDepartmentDao{
    // 获取学生对象
    public Department getDepartment(SearchField field, String value) {
        // 编写sql语句
        String sql = null;
        switch (field){
            case SEARCH_UESRNAME:
                sql = "SELECT * FROM Department WHERE UserName = ?";
                break;
            case SEARCH_DEPARTMENTID:
                sql = "SELECT * FROM Department WHERE DepartmentID = ?";
                break;
            default:
                break;
        }
        // 获得连接
        Connection conn = DBConnection.getConnection();
        // 返回数据集
        ResultSet rs = null;
        // 实例化一个Department对象
        Department Department = null;
        try {
            // 准备sql语句
            PreparedStatement ps = conn.prepareStatement(sql);
            // 设置要传入的参数
            ps.setString(1, value);
            // 执行sql语句
            rs = ps.executeQuery();

            if (rs.next()) {
                // 把找到的结果set进User对象中
                Department = new Department();
                Department.setDepartmentID(rs.getString(1));
                Department.setUserName(rs.getString(2));
                Department.setDepartmentName(rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭连接
            DBConnection.closeConn(conn, null, rs);
        }
        return Department;
    }


    @Override
    public Department getDepartmentByUserName(String UserName) {
        return getDepartment(SearchField.SEARCH_UESRNAME, UserName);
    }

    @Override
    public Department getDepartmentBySID(String DeptID) {
        return getDepartment(SearchField.SEARCH_DEPARTMENTID, DeptID);
    }


    @Override
    public int updateDepartment(Department Department) {
        // 编写sql语句
        String sql = "UPDATE Department SET DepartmentID = ?, DepartmentName = ? WHERE UserName = ?";
        // 获得连接
        Connection conn = DBConnection.getConnection();
        // 返回受影响行数
        int rowsAffected = 0;
        try {
            // 用来发送sql语句的
            PreparedStatement ps = conn.prepareStatement(sql);
            // 设置要传入的参数
            ps.setString(1, Department.getDepartmentID());
            ps.setString(2, Department.getDepartmentName());
            ps.setString(3, Department.getUserName());
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
