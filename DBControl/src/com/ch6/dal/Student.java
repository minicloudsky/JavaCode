package com.ch6.dal;
import com.ch6.Conn;
import com.ch6.model.StudentInfo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class Student
{
    Conn conn = new Conn();
    /*获取学生列表
    * @return
    * @throws SQLException*/
    public List<StudentInfo> getList() throws SQLException{
        List<StudentInfo> list = new ArrayList<StudentInfo>();
        String sql = "select * from student;";
        ResultSet rs = conn.executeQuery(sql);
        while (rs.next()){
            StudentInfo info = new StudentInfo();
            info.setId(rs.getInt("id"));
            info.setNumber(rs.getString("number"));
            info.setName(rs.getString("name"));
            info.setAddress(rs.getString("address"));
            info.setPhone(rs.getString("phone"));
            info.setSex(rs.getString("sex"));
            info.setEmail(rs.getString("email"));
            list.add(info);
        }
        conn.close();
        System.out.println(list);
        return list;
    }
    /*
    * 添加
    * @param info
    * @return
    * */
    public int insert(StudentInfo info){
        String sql = "insert into student(number,name,address,phone,sex,email) values ";
        sql = sql+"('" +info.getNumber()+"','" +info.getName() +"','" +info.getAddress()
                +"','" +info.getPhone()+"','"+info.getSex() +"','" +info.getEmail()+"');";
        int result = 0;
        System.out.println(sql);
        result = conn.executeUpdate(sql);
        conn.close();
        return result;
    }
    public int update(StudentInfo info){
        String sql = "update student set"
                + " number='"+info.getNumber()+"',name='"+info.getName()+
                "',address='"+info.getAddress()
                +"',phone='"+info.getPhone()+"',sex='"+info.getSex()+"',email='"
                +info.getEmail()+"' where id ='" +info.getId() +"'";
        int result = 0;
        System.out.println(sql);
        result = conn.executeUpdate(sql);
            conn.close();
        return result;
    }
    /**
     * 获取单个学生信息
     *@param id
     * @return
     * @thorws SQLException
     * */
    public StudentInfo getStudent(String id) throws SQLException{
        StudentInfo info = new StudentInfo();
        String sql = "select * from student s where id='" + id +"'";
        ResultSet rs = conn.executeQuery(sql);
        if(rs.next()){
            info.setId(rs.getInt("id"));
            info.setNumber(rs.getString("number"));
            info.setName(rs.getString("name"));
            info.setAddress(rs.getString("address"));
            info.setPhone(rs.getString("phone"));
            info.setSex(rs.getString("sex"));
            info.setEmail(rs.getString("email"));
        }
        conn.close();
        return info;
    }
    /**
     * 删除
     * @param id
     * @return
     */
    public int delete(String id){
        String sql = "delete from student where id = '" +id+"'";
        int result = 0;
        System.out.println(sql);
        result = conn.executeUpdate(sql);
        conn.close();
        return result;
    }
}
