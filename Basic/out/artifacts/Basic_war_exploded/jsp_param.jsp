<%--
  Created by IntelliJ IDEA.
  User: qiyu
  Date: 2017-11-22
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8" %>
<html>
<head>
    <title>jsp:param</title>
</head>
<body>
<p>转向user</p>
<jsp:forward page="user.jsp">
    <jsp:param name="username" value="xiaoxiaojia"></jsp:param>
    <jsp:param name="age" value="21"></jsp:param>
</jsp:forward>
</body>
</html>
