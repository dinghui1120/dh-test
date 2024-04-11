package com.dh.spi.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * JdbcDemo
 * @author: dh
 * @date: 2024年03月24日
 **/
public class JdbcDemo {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/数据库名称?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false";
        String user = "用户名";
        String password = "密码";
        String sql = "";
        // 从JDBC 4.0（Java 6）开始，JDBC驱动程序会通过服务提供者机制自动加载，所以通常不需要手动加载JDBC驱动类
        //Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "值1");
            pstmt.setInt(2, 123);
            int affectedRows = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
