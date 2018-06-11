package com.dal;

import com.model.UsersInfo;
import com.common.Conn;
import com.common.MD5;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Users {
    Conn conn = new Conn();
    /**
     * 获取用户列表
     * @return
     * @throws java.sql.SQLException
     */
    public List<UsersInfo> getList() throws SQLException{
        List<UsersInfo> list = new ArrayList<UsersInfo>();
        String sql = "select * from Users order by username asc";
        ResultSet rs = conn.executeQuery(sql);
        while (rs.next()){
            UsersInfo info = new UsersInfo();
            info.setUsername(rs.getString("UserName"));
            info.setPassword(rs.getString("Password"));
            info.setEmail(rs.getString("Email"));
            info.setPower(rs.getString("Power"));
            list.add(info);
        }
        conn.close();
        return list;
    }
    /**
     * 判断当前用户是否存在
     * @param UserName,password
     * @return
     * @throws SQLException
     */
    public boolean isExist(String UserName,String password) throws SQLException{
        boolean result = false;
        UsersInfo info = new UsersInfo();
        String sql = "select * from Users u where UserName='" +UserName
                +"' and password='" +password + "'";
        System.out.println(sql);
        ResultSet rs = conn.executeQuery(sql);
        if(rs.next()){
            info.setUsername(rs.getString("UserName"));
            info.setPassword(rs.getString("Password"));
            info.setEmail(rs.getString("Email"));
            info.setPower(rs.getString("Power"));
            result = true;
        }
        conn.close();
        return result;
    }
    /**
     * 获取单个用户信息
     * @param username
     * @return
     * @throws SQLException
     */
    public UsersInfo getUsersInfo(String username) throws SQLException{
        UsersInfo info = new UsersInfo();
        String sql = "select * from Users U where UserName='" +username+"'";
        ResultSet rs = conn.executeQuery(sql);
        if(rs.next()){
            info.setUsername(rs.getString("UserName"));
            info.setPassword(rs.getString("Password"));
            info.setEmail(rs.getString("Email"));
            info.setPower(rs.getString("Power"));
        }
        conn.close();
        return info;
    }
    /**
     * 判断注册用户是否已经存在
     * @param username
     * @return
     * @throws SQLException
     */
    public boolean isExistUsersInfo(String username) throws SQLException{
        boolean result = false;
        UsersInfo info = new UsersInfo();
        String sql = "select * from Users U where username='" +username +"'";
        ResultSet rs = conn.executeQuery(sql);
        if(rs.next()){
            info.setUsername(rs.getString("UserName"));
            info.setPassword(rs.getString("Password"));
            info.setEmail(rs.getString("Email"));
            info.setPower(rs.getString("Power"));
            result = true;
        }
        conn.close();
        return result;
    }
    /**
     * 用户插入
     * @param info
     * @return
     */
    public int insert(UsersInfo info){
        String sql = "insert into Users(UserName,Password,Email,Power) values ";
        sql = sql + "('" +info.getUsername() + "','" +info.getPassword() +"','" +info.getEmail()
                +"','" +info.getPower() +"')";
        int result = 0;
        result = conn.executeUpdate(sql);
        conn.close();
        return result;
    }
    /**
     * 用户修改
     * @param info
     * @return
     */
    public int update(UsersInfo info){
        String sql = "update Users set Password = '"
                + MD5.Encrypt(info.getPassword()) +"',Email='"
                +info.getEmail() +"',Power='" +info.getPower()
                +"' where UserName = '" +info.getUsername() +"'";
        int result = 0;
        result = conn.executeUpdate(sql);
        return result;
    }
    /**
     * 删除
     * @param username
     * @return
     */
    public int delete(String username){
        String sql = "delete from Users where UserName = '" +username+"'";
        int result = 0;
        result = conn.executeUpdate(sql);
        conn.close();
        return result;
    }
}
