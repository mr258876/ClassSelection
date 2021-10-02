package com.classSelection.util;

import java.sql.*;

public class DBConnection {
    // SQLServer驱动包名
    private static final String DRIVER_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    // 数据库连接地址
    private static final String URL = "jdbc:sqlserver://localhost:65232;integratedSecurity=false;DatabaseName=ClassSelection";
    // 用户名
    private static final String USER_NAME = "sa";
    // 密码
    private static final String PASSWORD = "123Aa.";

    public static Connection getConnection() {
        try {
            // 加载SQLServer的驱动类
            Class.forName(DRIVER_NAME);
            // 获取数据库连接
            return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void closeConn(Connection conn, Statement stm, ResultSet rs) {
        if (stm != null) {
            try {
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(getConnection());
    }
}
