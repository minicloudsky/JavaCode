package com.ch6;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ch6.Conn;
import com.ch6.model.StudentInfo;
public class Student
{
    Conn conn = new Conn();
    /*获取学生列表
    * @return
    * @throws SQLException*/
    public List<StudentInfo> getList() throws SQLException{
        List<StudentInfo> list = new ArrayList<StudentInfo>();
        String sql = "select * from student order by ";
        return list;
    }
}
