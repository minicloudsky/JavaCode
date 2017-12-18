<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: qiyu
  Date: 2017-12-18
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="c" scope="page" class="com.ch6.Conn"/>
<html>
  <head>
    <title>查询数据库</title>
  </head>
  <body>
  <%
    String sqlstr = "select * from user order by id desc";
      ResultSet rs = c.executeQuery(sqlstr);
      while(rs.next()){
          out.println(rs.getString("name")+"\t");
          out.println(rs.getString("sex")+"\t");
          out.println(rs.getString("address")+"\t");
          out.println("<br>");
      }
  %>
  </body>
</html>
