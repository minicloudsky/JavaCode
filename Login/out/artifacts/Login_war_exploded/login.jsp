<%--
  Created by IntelliJ IDEA.
  User: qiyu
  Date: 2017-12-20
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.*" pageEncoding="UTF-8" %>
<%@page import="Information.Info,Login.Login" %>
<%
    request.setCharacterEncoding("UTF-8");
    Info info = new Info();
    Login logins = new Login();
    if("login".equals(request.getParameter("action"))){
        info.setUsername(request.getParameter("username"));
        info.setPassword(request.getParameter("password"));
        info.setSex(request.getParameter("sex"));
        info.setAge(Integer.parseInt(request.getParameter("age")));
        info.setAddress(request.getParameter("address"));
        info.setPhone(request.getParameter("phone"));
        info.setBorn(request.getParameter("born"));
       int result =  logins.insertLoginData(info);
       if(result==1)
           out.print("注册成功");
    }
    System.out.println();
%>
<html>
<head>
    <title></title>
</head>
<body>
</body>
</html>
