package com.dal;

import com.model.ClassInfo;
import com.common.Conn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Class {
    Conn conn =  new Conn();
    /**
     * 获取博文分类列表
     * @return
     * @throws java.sql.SQLException
     */
    public List<ClassInfo> getList() throws SQLException{
        List<ClassInfo> list = new ArrayList<ClassInfo>();
        String sql = "select * from class order by sort asc";
        ResultSet rs = conn.executeQuery(sql);
        while (rs.next()){
            ClassInfo info = new ClassInfo();
            info.setId(rs.getInt("Id"));
            info.setName(rs.getString("Name"));
            info.setSort(rs.getInt("Sort"));
            list.add(info);
        }
        conn.close();
        return list;
    }
    /**
     * 获得单条分类信息
     * @param id
     * @return
     * @throws SQLException
     */
    public ClassInfo getClassInfo(int id) throws SQLException{
        ClassInfo info = new ClassInfo();
        String sql = "select * from Class c where id=" + id + "";
        ResultSet rs = conn.executeQuery(sql);
        if(rs.next()){
            info.setId(rs.getInt("id"));
            info.setName(rs.getString("Name"));
            info.setSort(rs.getInt("Sort"));
        }
        conn.close();
        return info;
    }
    /**
     * 博文分类插入
     * @param info
     * @return
     */
    public int insert(ClassInfo info){
        String sql = "insert into Class(Name,Sort) values ";
        sql = sql +"('" +info.getName() +"','" +info.getSort() +"')";
        int result = 0;
        result = conn.executeUpdate(sql);
        conn.close();
        return result;
    }
    /**
     * 博文修改
     *@param info
     *@return
     */
    public int update(ClassInfo info){
        String sql = "update Class set" +" Name='" +info.getName()
                +"',Sort=" +info.getSort() +" where id = " +info.getId() +"";
        int result = 0;
        result  = conn.executeUpdate(sql);
        conn.close();
        return result;
    }
    /**
     * 博文分类删除
     * @param id
     * @return
     */
    public int delete(int id){
        String sql = "delete from Class where id = " +id + "";
        int result = 0;
        result = conn.executeUpdate(sql);
        conn.close();
        return result;
    }

}
