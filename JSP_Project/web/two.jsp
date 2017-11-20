<%--
  Created by IntelliJ IDEA.
  User: qiyu
  Date: 2017-11-07
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
import="java.util.*" %>
<html>
<head>
    <title>two.jsp</title>
</head>
<body>
<%
    String content = "你提交的数据是: "+request.getParameter("boy");
%>
<%=content%>
</body>
</html>
