package conn;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.*;
import java.sql.Connection;

public class Sql {
	Connection conn=null;
	Statement stmt=null;
	ResultSet rs=null;
	
	/*
	 * 加载驱动程序
	 */
	public void Conn()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(java.lang.ClassNotFoundException e)
		{
			System.err.println(e.getMessage());
		}
	}
	
	/*
	 * 执行查询操作
	 */
	public ResultSet select(String Sql) throws ClassNotFoundException
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/mymall";
			conn= DriverManager.getConnection(url,"root","");
			stmt= conn.createStatement();
			rs=stmt.executeQuery(Sql);
			
		}catch(SQLException ex){
			System.err.println(ex.getMessage());
		}
		return rs;
	}
	
	
	
	/*
	 * 执行更新操作
	 */
	public int update(String Sql) throws ClassNotFoundException  //(update,insert,delete)
	{
		int result=0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/mymall";
			conn= DriverManager.getConnection(url,"root","");
			stmt= conn.createStatement();
			result=stmt.executeUpdate(Sql);
		}catch(SQLException ex){
			System.err.println(ex.getMessage());
		}
		return result;
	}
	
	/*
	 * 关闭数据连接
	 */
	public void close()
	{
		try{
			if(rs!=null)
				rs.close();
		}catch(Exception e)
		{
			e.printStackTrace(System.err);
		}
		try{
			if(stmt!=null)
				stmt.close();
		}catch(Exception e)
		{
			e.printStackTrace(System.err);
		}
		try{
			if(conn!=null)
				conn.close();
		}catch(Exception e)
		{
			e.printStackTrace(System.err);
		}
	}

}
