<%--
  Created by IntelliJ IDEA.
  User: qiyu
  Date: 2017-11-22
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=gb2312" language="java"
import="javabean.User" %>
<html>
<head>
    <title>用户信息</title>
</head>
<body>
<!--指定javabean实例，其相应的生存范围及全限定类名-->
<jsp:useBean id="userbean" scope= "page" class="User"></jsp:useBean>
<!--使用jsp:setProperty动作指令设置username属性值-->
<jsp:setProperty  name = "userbean" property= "username"  param="username" ></jsp:setProperty>
<jsp:setProperty name = "userbean" property="password" param="password"></jsp:setProperty>
用户名:
<jsp:getProperty name= "userbean" property= "username"></jsp:getProperty> </br>
密码:
<jsp:getProperty name= "userbean" property= "password" ></jsp:getProperty>
<%
    out.println("用户名: "+userbean.getUsername() + "</br>");
    out.println("密码: " + userbean.getPassword());
%>
</body>
</html>
