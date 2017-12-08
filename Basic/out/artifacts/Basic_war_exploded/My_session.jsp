<%--
  Created by IntelliJ IDEA.
  User: qiyu
  Date: 2017-11-20
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>session</title>
</head>
<body>
<%
    String s= session.getId();
%>
<p>你当前的session对象的标识ID是: </p>
<%=s%><br>
<p>输入你的名字连接到jack.jsp</p>
<form action="jack.jsp" method="post" name="form">
    <input type="text" name="boy">
    <input type="submit" value="提交" name="submit">
</form>
</body>
</html>
