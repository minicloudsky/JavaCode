<%--
  Created by IntelliJ IDEA.
  User: qiyu
  Date: 2017-11-20
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp计数器</title>
</head>
<body>
<%
    int i= 0;
%>
<%@include file="index.jsp" %>
<%
    i++;
<%-- 这是jsp注释--%>
%>
<!-- 这是html注释 -->
<p>您是第<%= i %>个访问本站的用户</p>
</body>
</html>
