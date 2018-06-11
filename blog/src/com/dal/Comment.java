package com.dal;

import com.model.CommentInfo;
import com.common.Conn;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Comment {
    Conn conn = new Conn();
    /**
     * 获取博文评论列表
     *@return
     *@thorws SQLException
     */
    public List<CommentInfo> getList() throws SQLException{
        List<CommentInfo> list = new ArrayList<CommentInfo>();
        String sql = "select * from Comment order by id desc";
        ResultSet rs  = conn.executeQuery(sql);
        while (rs.next()){
            CommentInfo info = new CommentInfo();
            info.setId(rs.getInt("Id"));
            info.setContext(rs.getString("Context"));
            info.setBlogid(rs.getInt("Blogid"));
            info.setCreatedtime(rs.getDate("CreatedTime"));
            info.setUsername(rs.getString("UserName"));
            list.add(info);
        }
        conn.close();
        return list;
    }
    /**
     * 获得单条评论信息
     * @param id
     * @return
     * @throws SQLException
     */
    public CommentInfo getCommentInfo(int id) throws SQLException
    {
        CommentInfo info = new CommentInfo();
        String sql = "select * from Comment c where id=" + id +"";
        ResultSet rs = conn.executeQuery(sql);
        if(rs.next()){
            info.setId(rs.getInt("Id"));
            info.setContext(rs.getString("Context"));
            info.setBlogid(rs.getInt("BlogId"));
            info.setCreatedtime(rs.getDate("CreatedTime"));
            info.setUsername(rs.getString("UserName"));
        }
        conn.close();
        return info;
    }
    /**
     * 获得某博文的所有评论
     * @param blogid
     * @return
     * @throws SQLException
     */
    public List<CommentInfo> getListByBlogId(int blogid) throws SQLException{
        List<CommentInfo> list = new ArrayList<CommentInfo>();
        String sql = "select * from Comment where blogid=" +blogid +
                " order by id desc";
        ResultSet rs = conn.executeQuery(sql);
        while (rs.next()){
            CommentInfo info = new CommentInfo();
            info.setId(rs.getInt("Id"));
            info.setContext(rs.getString("Context"));
            info.setBlogid(rs.getInt("BlogId"));
            info.setCreatedtime(rs.getDate("CreatedTime"));
            info.setUsername(rs.getString("UserName"));
            list.add(info);
        }
        conn.close();
        return list;
    }
    /**
     * 博文评论插入
     * @param info
     * @return
     */
    public int insert(CommentInfo info){
        String sql = "insert into Comment(Context,BlogId,CreatedTime,UserName) values ";
        sql = sql +"('" +info.getContext() +"'," +info.getBlogid() +"',now(),'"
                +info.getUsername() +"')";
        int result = 0;
        System.out.println(sql);
        result = conn.executeUpdate(sql);
        conn.close();
        return result;
    }
    /**
     * 博文评论修改
     * @param info
     * @return
     */
    public int update(CommentInfo info){
        String sql = "update Comment set" +"Context='" +info.getContext()
                + "',BlogId=" +info.getBlogid() + ",CreatedTime='" +info.getCreatedtime()
                +"',UserName = '" +info.getUsername()+ "',where id=" +info.getId() + "";
        int result = 0;
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
        String sql = "delete from Comment where id =" + id + "";
        int result = 0;
        result = conn.executeUpdate(sql);
        conn.close();
        return result;
    }

}
