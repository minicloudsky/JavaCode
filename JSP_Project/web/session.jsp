<%--
  Created by IntelliJ IDEA.
  User: qiyu
  Date: 2017-11-07
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>session对象</title>
</head>
<body>
<%="session对象创建时间"%>
<%= session.getCreationTime()%><br>
<%="session id is :"%>
<%=session.getId()%>
</body>
</html>
