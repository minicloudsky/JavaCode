package com.dal;

import com.model.BlogInfo;
import com.common.Conn;
import com.common.DataValidator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Blog {
    Conn conn = new Conn();
    /**
     * 获取博文列表
     * @return
     * @throws java.sql.SQLException
     */
    public List<BlogInfo> getList(String keyword) throws SQLException{
        List<BlogInfo> list = new ArrayList<BlogInfo>();
        String sql = "select * from blog";
        if(DataValidator.isNullOrEmpty(keyword)){
            sql = sql + "order by id asc;";
        } else{
            sql =sql +" order by createdtime desc";
        }
        ResultSet rs = conn.executeQuery(sql);
        while (rs.next()){
            BlogInfo info = new BlogInfo();
            info.setId(rs.getInt("id"));
            info.setTitle(rs.getString("title"));
            info.setContext(rs.getString("context"));
            info.setCreatedtime(rs.getDate("createdtime"));
            info.setClassid(rs.getInt("classid"));
            info.setClassName(rs.getString("classname"));
            list.add(info);
        }
        conn.close();
        return list;
    }

    /**
     *获取某分类下面所有博文列表
     *@param classId
     *@return
     *@throws SQLException
     */
    public List<BlogInfo> getListByClassId(int classId) throws SQLException{
        List<BlogInfo> list = new ArrayList<BlogInfo>();
        String sql = "select b.*,c.name as ClassName from Blog b left join class c on b.classid=c.id where b.classId="
                + classId + " order by id desc";
        ResultSet rs = conn.executeQuery(sql);
        while (rs.next()){
            BlogInfo info = new BlogInfo();
            info.setId(rs.getInt("Id"));
            info.setTitle(rs.getString("title"));
            info.setContext(rs.getString("context"));
            info.setCreatedtime(rs.getDate("createdtime"));
            info.setClassName(rs.getString("ClassName"));
            info.setClassid(rs.getInt("ClassId"));
            list.add(info);
        }
        conn.close();
        return list;
    }
    /**
     * 获取单条博文
     * @return
     * @thorws SQLException
     */
    public BlogInfo getBlogInfo(int id) throws SQLException{
        BlogInfo info = new BlogInfo();
        String sql = "select b.*,c.name as ClassName from Blog b left join class c on b.classid=c.id where b.id="
                + id + "";
        ResultSet rs = conn.executeQuery(sql);
        if(rs.next()) {
            info.setId(rs.getInt("id"));
            info.setTitle(rs.getString("title"));
            info.setContext(rs.getString("context"));
            info.setCreatedtime(rs.getDate("createdtime"));
            info.setClassid(rs.getInt("classid"));
            info.setClassName(rs.getString("classname"));
        }
        conn.close();
        return info;
    }
    /**
     * 博文插入操作
     * @param info
     * @return
     */
    public int insert(BlogInfo info){
        String sql = "insert into Blog(Title,Context,CreatedTime,ClassId) values ";
        sql = sql +"('" + info.getTitle() + "','" +info.getContext() + "',now()," +info.getClassid() +")";
        int result = 0;
        System.out.println(sql);
        result = conn.executeUpdate(sql);
        return result;
    }
    /**
     * 博文修改
     * @param info
     * @return
     */
    public int update(BlogInfo info){
        String sql = "update Blog set " +"Title='" +info.getTitle()
                + "',Context='" +info.getContext() +"',ClassId='"
                +info.getClassid() + "',where id =" +info.getId() + "";
        int result = 0;
        System.out.println(sql);
        result = conn.executeUpdate(sql);
        conn.close();
        return result;
    }
    /**
     * 博文删除
     * @param id
     * @return
     */
    public int delete(int id){
        String sql = "delete from blog where id= " + id +"";
        int result = 0;
        result = conn.executeUpdate(sql);
        return result;
    }
}
