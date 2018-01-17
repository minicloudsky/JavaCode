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
    String username =
    if("update".equals(request.getParameter("action"))){
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
    <title>更新个人信息</title>
</head>
<body>
<form action="login.jsp?action=login" method="post">
    <label>用户名:&nbsp;</label>
    <input type="text" name="username" id="username"><br>
    <label>密码:&nbsp;</label>
    <input type="password" name="password" id="password"><br>
    <label>性别: </label>
    男<input type="radio" name="sex"  checked>
    女<input type="radio" name="sex"><br>
    <label>年龄:&nbsp;</label>
    <input type="text" name="age"><br>
    <label>地址:</label>
    <input type="text" name="address"><br>
    <label>手机号:&nbsp;</label>
    <input type="text" name="phone"><br>
    <label>出生日期:&nbsp;</label>
    <input type="date" name="born"><br>
    <input type="submit" name="submit" id = "submit" value="提交" onclick="date()">
    <input type="reset" name="reset" id="reset" value="重置">
</form>
</body>
</html>
