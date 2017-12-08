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
    <title>jack</title>
</head>
<body>
<p>我是jack页面</p>
<%
    String s = session.getId();
%>
<P>你在jack页面的当前session id为:</P>
<%=s%>
<p>点击超链接，连接到Jerry的世界</p>
</br>
<a href="jerry.jsp">jerry</a>
<p>欢迎来到Jerry的世界</p>
</body>
</html>
