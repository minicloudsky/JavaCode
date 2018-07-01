package dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Evaluateinfo;
import model.Productinfo;
import model.Userinfo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import conn.Sql;



public class User {
	  public int getid(String name,String pwd) throws SQLException, ClassNotFoundException
	  {
		String sql="select * from user where user_name='"+name+"' and user_pwd='"+pwd+"'";
		Sql s=new Sql();
		ResultSet rs=s.select(sql);
		while(rs.next()) {
			return rs.getInt("user_id");
			
		}
		   return 0;
	  }
	
		public String login(String name,String pwd) throws SQLException, ClassNotFoundException
		{
			String sql="select * from user where user_name='"+name+"' and user_pwd='"+pwd+"'";
			Sql s=new Sql();
			ResultSet rs=s.select(sql);
			while(rs.next()) {
				
				if(rs.getInt("user_isboss")==1)
					return "1";    
				else
					return "2";    
			}
			return "0";    //��¼ʧ��
		}
		public String register(String name,String pwd,String role) throws ClassNotFoundException 
		{
			int result=0;
			int Rrole;
			if(role=="1")          //�����
				Rrole=1;
			else if(role=="2")         //������
				Rrole=2;
			else
				return "2";            //ע��ʧ�ܣ�û�б������
			String sql="insert into user values(null,'"+name+"','"+pwd+"',"+Rrole+")";
			Sql s=new Sql();
			result=s.update(sql);
			if(result==1)       //����ɹ�
			{
				return "1";
			}
			else                //����ʧ��
			    return "2";
		}
		public List<Productinfo> index() throws ClassNotFoundException, SQLException{
			List<Productinfo> list=new ArrayList<Productinfo>();
			String sql="select * from products order by pro_sale asc";
			ResultSet rs=null;
			Sql s=new Sql();
			rs=s.select(sql);
				while(rs.next())
				{
					Productinfo info =new Productinfo ();
					info.setPro_id(rs.getInt("pro_id"));
					info.setPro_name(rs.getString("pro_name"));
					info.setPro_kind(rs.getString("pro_kind"));
					info.setPro_content(rs.getString("pro_content"));
					info.setPro_picture1(rs.getString("pro_picture1"));
					info.setPro_picture2(rs.getString("pro_picture2"));
					info.setPro_picture3(rs.getString("pro_picture3"));
					info.setPro_sale(rs.getInt("pro_sale"));
					info.setPro_shop(rs.getInt("pro_shop"));
					info.setPro_price(rs.getInt("pro_price"));
					list.add(info);
				}
			
			return list;
		}
		public List<Productinfo> Kind(String kind) throws SQLException, ClassNotFoundException{
			List<Productinfo> list=new ArrayList<Productinfo>();
			String sql="select * from products  order by pro_sale asc ";
			ResultSet rs=null;
			Sql s=new Sql();
			rs=s.select(sql);
				while(rs.next())
				{
					Productinfo info =new Productinfo ();
					if(rs.getString("pro_kind").equals(kind))
					{
						
						info.setPro_id(rs.getInt("pro_id"));
						info.setPro_name(rs.getString("pro_name"));
						info.setPro_kind(rs.getString("pro_kind"));
						info.setPro_content(rs.getString("pro_content"));
						info.setPro_picture1(rs.getString("pro_picture1"));
						info.setPro_picture2(rs.getString("pro_picture2"));
						info.setPro_picture3(rs.getString("pro_picture3"));
						info.setPro_sale(rs.getInt("pro_sale"));
						info.setPro_shop(rs.getInt("pro_shop"));
						info.setPro_price(rs.getInt("pro_price"));
						list.add(info);
					}
					
				}
				
			
			return list;
		}
		public List<Productinfo> shopcar(int id) throws SQLException, ClassNotFoundException{
			List<Productinfo> list=new ArrayList<Productinfo>();
			String sql="select * from shopcar,products where shopcar_userid="+id+" and shopcar.shopcar_proid=products.pro_id";
			ResultSet rs=null;
			Sql s=new Sql();
			rs=s.select(sql);
				while(rs.next())
				{
					Productinfo info =new Productinfo ();
					//if(rs.getString("shopcar_userid").equals(id))
					//{
						
						info.setPro_id(rs.getInt("pro_id"));
						info.setPro_name(rs.getString("pro_name"));
						info.setPro_kind(rs.getString("pro_kind"));
						info.setPro_content(rs.getString("pro_content"));
						info.setPro_picture1(rs.getString("pro_picture1"));
						info.setPro_picture2(rs.getString("pro_picture2"));
						info.setPro_picture3(rs.getString("pro_picture3"));
						info.setPro_sale(rs.getInt("pro_sale"));
						info.setPro_shop(rs.getInt("pro_shop"));
						info.setPro_price(rs.getInt("pro_price"));
						list.add(info);
				//	}
					
				}
				
			
			return list;
		}
		public String add_to_car(int userid,int pro_id) throws ClassNotFoundException 
		{
			
			String sql="insert into shopcar values(null,"+userid+","+pro_id+")";
			Sql s=new Sql();
			int result=0;
			result=s.update(sql);
			if(result==1)       //����ɹ�
			{
				return "1";
			}
			else                //����ʧ��
			    return "0";
		}
		public String add_pro(String name,String content,String shop,String kind) throws ClassNotFoundException 
		{
			
			String sql="insert into products values(null,'"+name+"','"+content+"')";
			Sql s=new Sql();
			int result=0;
			result=s.update(sql);
			if(result==1)       //����ɹ�
			{
				return "1";
			}
			else                //����ʧ��
			    return "0";
		}
		public String change_pwd(int userid,String oldpwd,String newpwd) throws ClassNotFoundException 
		{
			
			String sql="update user set user_pwd='"+newpwd+"' where user_id="+userid+" and user_pwd='"+oldpwd+"'";
			Sql s=new Sql();
			int result=0;
			result=s.update(sql);
			if(result==1)       //����ɹ�
			{
				return "1";
			}
			else                //����ʧ��
			    return "0";
		}
		public List<Productinfo> shop(int userid) throws SQLException, ClassNotFoundException{
			List<Productinfo> list=new ArrayList<Productinfo>();
			String sql="select * from products where pro_shop = (select shop_id from shop where shop_owner_id="+userid+")";
			ResultSet rs=null;
			Sql s=new Sql();
			rs=s.select(sql);
				while(rs.next())
				{
					Productinfo info =new Productinfo ();
					
						
						info.setPro_id(rs.getInt("pro_id"));
						info.setPro_name(rs.getString("pro_name"));
						info.setPro_kind(rs.getString("pro_kind"));
						info.setPro_content(rs.getString("pro_content"));
						info.setPro_picture1(rs.getString("pro_picture2"));
						info.setPro_picture2(rs.getString("pro_picture2"));
						info.setPro_picture3(rs.getString("pro_picture3"));
						info.setPro_sale(rs.getInt("pro_sale"));
						info.setPro_shop(rs.getInt("pro_shop"));
						info.setPro_price(rs.getInt("pro_price"));
						list.add(info);
					
				}
				
			
			return list;
		}
		public String delete_pro(int pro_id) throws ClassNotFoundException 
		{
			
			String sql="delete from products where pro_id="+pro_id+"";
			Sql s=new Sql();
			int result=0;
			result=s.update(sql);
			if(result==1)       //����ɹ�
			{
				return "1";
			}
			else                //����ʧ��
			    return "0";
		}
		public List<Productinfo> pro_detail(int proid) throws SQLException, ClassNotFoundException{
			List<Productinfo> list=new ArrayList<Productinfo>();
			String sql="select * from products where pro_id="+proid+"";
			ResultSet rs=null;
			Sql s=new Sql();
			rs=s.select(sql);
				while(rs.next())
				{
					Productinfo info =new Productinfo ();
					
						
						info.setPro_id(rs.getInt("pro_id"));
						info.setPro_name(rs.getString("pro_name"));
						info.setPro_kind(rs.getString("pro_kind"));
						info.setPro_content(rs.getString("pro_content"));
						info.setPro_picture1(rs.getString("pro_picture2"));
						info.setPro_picture2(rs.getString("pro_picture2"));
						info.setPro_picture3(rs.getString("pro_picture3"));
						info.setPro_sale(rs.getInt("pro_sale"));
						info.setPro_shop(rs.getInt("pro_shop"));
						info.setPro_price(rs.getInt("pro_price"));
						list.add(info);
					
				}
				
			
			return list;
		}
		public List<Evaluateinfo> evaluate(int proid) throws SQLException, ClassNotFoundException{
			List<Evaluateinfo> list=new ArrayList<Evaluateinfo>();
			String sql="select evaluate_content,user_name  from evaluate,user where evaluate_pro="+proid+" and evaluate.user_id=user.user_id";
			ResultSet rs=null;
			Sql s=new Sql();
			rs=s.select(sql);
				while(rs.next())
				{
					Evaluateinfo info =new Evaluateinfo ();
					
						
						//info.setEvaluate_id(rs.getInt("evaluate_id"));
						info.setUser_name(rs.getString("user_name"));
						info.setEvaluate_content(rs.getString("evaluate_content"));
						//info.setEvaluate_picture1(rs.getString("evaluate_picture1"));
						//info.setEvaluate_pro(rs.getInt("evaluate_pro"));
						
						list.add(info);
					
				}
				
			
			return list;
		}
		public String sum(int userid,String sum) throws ClassNotFoundException  //结算
		{
			 JSONArray pro=JSONArray.fromObject(sum);
			System.out.println(pro.toString());
			 for (int i = 0; i < pro.size(); i++) {
				
				 int pro_id=(int)pro.get(i);
				
				 String sql="delete from shopcar where shopcar_proid="+pro_id+"";
				 Sql s=new Sql();
				int result=0;
				result=s.update(sql);
				if(result!=1)       //����ɹ�
				{
					return "0";
				}
				
				   
			 } 
			return "1";
			
		}
}
