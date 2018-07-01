package test;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import model.Evaluateinfo;
import model.Productinfo;
import model.Userinfo;
import conn.Sql;
import dal.User;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int proid=1;
       
        User u=new User();    
        String p="0";
        try {
        
	           
			p=u.add_to_car(1,1);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
      //  HttpSession session=request.getSession(true);
      //  int userid=(int)session.getAttribute("userid");
     //   System.out.println(userid);
    
    	
	}

}
