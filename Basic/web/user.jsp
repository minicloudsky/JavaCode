<%--
  Created by IntelliJ IDEA.
  User: qiyu
  Date: 2017-11-22
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>获取的用户信息如下：</p><br>
<%
    String username = request.getParameter("username");
    String age = request.getParameter("age");
%>
<%="用户名为: "+username%>
<%="年龄为:"+age%>
</body>
</html>
