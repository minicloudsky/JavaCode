<%--
  Created by IntelliJ IDEA.
  User: qiyu
  Date: 2018-06-07
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="com.dal.Users" import="com.model.UsersInfo" import="com.common.MD5"
         import="com.common.DataValidator"
         import="com.common.DataValidator,com.common.Utility"
%>
<%
    Users users = new Users();
    String username = request.getParameter("AdminName");
    String password = MD5.Encrypt(request.getParameter("Password"));
    if(!users.isExist(username,password)){
        out.println("<script>alert('用户名密码有误');window.location.href('login.jsp');</script>");
    } else{
        Utility.writeCookie(response,"admin",username);
        response.sendRedirect("index.html");
    }
%>

