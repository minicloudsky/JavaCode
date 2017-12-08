<%--
  Created by IntelliJ IDEA.
  User: qiyu
  Date: 2017-11-20
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>save</title>
</head>
<body>
<label>这里是你刚输入的信息:</label></br>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String confirm_pwd = request.getParameter("confirm");
    String sex = request.getParameter("sex");
    String hobby = request.getParameter("basketballl");
    String hobby2 = request.getParameter("football");
    String major = request.getParameter("major");
    String other = request.getParameter("other");
    out.println("你提交的用户名字为: "+username);
    out.println("密码为："+password);
    out.println("第二次确认后密码为: "+confirm_pwd);
    out.println("sex: "+sex);
    out.println("hobby : " +hobby );
    out.println("hobby2: "+hobby2);
    out.println("major: "+major);
    out.println("other: "+other);
%>
</body>
</html>
