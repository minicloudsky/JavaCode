<%--
  Created by IntelliJ IDEA.
  User: qiyu
  Date: 2017-12-21
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="Login.Login" %>
<%@page import="Information.Info" %>
<%@page import="java.util.*" %>
<%
    String username = request.getParameter("username");
    Login login = new Login();
    List<Info> list = login.getInfo(username);
    for (Info info:list){
%>
<html>
<head>
    <title>查询用户个人信息</title>
</head>
<body>
<label>你查询的用户信息如下:</label>
<table border="1">
    <tr>
        <td>用户名:</td>
        <td><% out.print(info.getUsername()); %></td>
    </tr>
    <tr>
        <td>密码:</td>
        <td><%out.print(info.getPassword());%></td>
    </tr>
    <tr>
        <td>性别:</td>
        <td><%out.print(info.getSex());%></td>
    </tr>
    <tr>
        <td>年龄:</td>
        <td><%out.print(info.getAge());%></td>
    </tr>
    <tr>
        <td>地址:</td>
        <td><%out.print(info.getAddress());%>/td>
    </tr>
    <tr>
        <td>手机号:</td>
        <td><%out.print(info.getPhone());%></td>
    </tr>
    <tr>
        <td>出生日期:</td>
        <td><%out.print(info.getBorn());%></td>
    </tr>
    <% } %>
</table>
</body>
</html>
