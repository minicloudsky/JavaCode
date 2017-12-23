package Login;
import Information.Info;
import com.login.Conn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Login
{
    Conn conn =  new Conn();
    /**
     * 获取注册信息列表
     */
    public int insertLoginData(Info info) throws SQLException{
        List<Info> list = new ArrayList<Info>();
        String sql = "insert into login(username,password,sex,age,address,phone,born) values";
        sql = sql+"('" +info.getUsername() +"','"+info.getPassword()+"','"+info.getSex()+
               "','"+info.getAge()+"','"+info.getAddress()+"','"+info.getPhone()+"','"+
                info.getBorn()+"')";
        int result = 0;
        System.out.println(sql);
        result = conn.executeUpdate(sql);
        conn.close();
        return result;
    }
    public List<Info> getInfo(String username) throws SQLException{
        List<Info> list = new ArrayList<Info>();
        String sql = "select * from login where username='"+username +"'";
        ResultSet rs = conn.executeQuery(sql);
        while (rs.next()){
            Info info = new Info();
            info.setBorn(rs.getString("born"));
            info.setPhone(rs.getString("phone"));
            info.setAddress(rs.getString("address"));
            info.setAge(rs.getInt("age"));
            info.setSex(rs.getString("sex"));
            info.setPassword(rs.getString("password"));
            info.setUsername(rs.getString("username"));
            list.add(info);
        }
        conn.close();
        return list;
    }

}
