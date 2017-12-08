<%--
  Created by IntelliJ IDEA.
  User: qiyu
  Date: 2017-11-21
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>forward</title>
</head>
<body>
<%
    System.out.println("跳转前: ");
%>
<jsp:forward page="forwardpage.jsp"></jsp:forward>
<%
    System.out.println("跳转后: ");
%>
</body>
</html>
