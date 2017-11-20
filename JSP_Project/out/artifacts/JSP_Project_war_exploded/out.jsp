<%--
  Created by IntelliJ IDEA.
  User: qiyu
  Date: 2017-11-07
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>out对象使用</title>
</head>
<body>
<%
    String name = "java server page";
    int a =100;
    out.print(a);
    out.println();
    out.print(name);
%>
</body>
</html>
