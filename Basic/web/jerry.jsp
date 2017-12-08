<%--
  Created by IntelliJ IDEA.
  User: qiyu
  Date: 2017-11-20
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jerry</title>
</head>
<body>
<%
    String s = session.getId();

%>
<p>在Jerry世界页面的session id为:</p>
<%=s%>
<p>点击超链接，连接到session对象的页面</p>
<a href="My_session.jsp"> session </a>
</body>
</html>
