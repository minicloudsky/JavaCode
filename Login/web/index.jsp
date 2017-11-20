<%--
  Created by IntelliJ IDEA.
  User: qiyu
  Date: 2017-11-19
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
import="java.util.*"
pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body bgcolor="#f0f8ff">
<table width="673" height="301" border="1">
    <tr>
        <td height="87" colspan="2" valign="bottom">
            <!-- 包含menu.jsp页面到index.jsp中 -->
            <%@include file="menu.jsp"%>
        </td>
    </tr>
    <tr>
        <td width="231" valign="top">
            <%@include file="login.jsp"%>
        </td>
        <td width="372">
            <%@include file="main.jsp"%>
        </td>
    </tr>
</table>
</body>
</html>
