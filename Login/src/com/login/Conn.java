package com.login;
import com.sun.org.apache.regexp.internal.RE;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import java.sql.*;
public class Conn
{
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    public Conn(){
        try{
            Class.forName("com.jdbc.Driver");
        } catch(Exception e){
            System.err.println(e.getStackTrace());
        }
    }
    /**
     * 执行查询操作
     * select
     * */
    public ResultSet executeQuery(String sql){
        try{
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/login?useUnicode=true&characterEncoding=UTF-8","root","root");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return rs;
    }
    /**
     * 执行更新操作： insert,update delete
     * */
    public int executeUpdate(String sql){
        int result = 0;
        try{
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/login?useUnicode=true&characterEncoding=UTF-8",
                    "root",
                    "root"
            );
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            result = stmt.executeUpdate(sql);
        } catch(SQLException e){
            result = 0;
        }
        return result;
    }
    public void close(){
        try{
            if(rs!=null){
                rs.close();
            }
        } catch(Exception e){
            e.printStackTrace(System.err);
        }
        try{
            if(stmt!=null)
                stmt.close();
        } catch(Exception e){
            e.printStackTrace(System.err);
        }
        try{
            if(conn!=null)
                conn.close();
        } catch(Exception e){
            e.printStackTrace(System.err);
        }
    }
}
