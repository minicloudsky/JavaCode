package com.ch6;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Conn
{
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    /*
     * 加载驱动程序*/
    public Conn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            // TODO: handle exception
            System.err.println(e.getMessage());
        }
    }
    /*执行查询操作: select*/
    public ResultSet executeQuery(String sql) {
        try {
            conn = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/testDB?useUnicode=true&characterEncoding=UTF-8",
                            "root","root");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            // TODO: handle exception
            System.err.println(e.getMessage());
        }
        return rs;
    }
    /*执行更新操作: insert,update,delete*/
    public int executeUpdate(String sql) {
        int result = 0;
        try {
            conn = DriverManager
                    .getConnection(
                            "jdbc:mysql://localhost:3306/testDB?useUnicode=true&characterEncoding=UTF-8",
                            "root","root");
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            result = 0;
        }
        return result;
    }
    /*关闭数据库连接*/
    public void close() {
        try {
            if(rs!=null)
                rs.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace(System.err);
        }
        try {
            if(stmt!=null)
                stmt.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace(System.err);
        }
        try {
            if(conn!=null) {
                conn.close();
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace(System.err);
        }
    }
}
