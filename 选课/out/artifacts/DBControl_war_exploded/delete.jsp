<%--
  Created by IntelliJ IDEA.
  User: qiyu
  Date: 2017-12-20
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*"
pageEncoding="UTF-8" %>
<%@page import="com.ch6.dal.Student" %>
<%
    Student student = new Student();
    int result = 0;
    result = student.delete(request.getParameter("id"));
    if(result==1){
        out.print("删除成功");
    }
    else{
        out.print("删除失败");
    }
%>
<html>
<head>
    <title>delete</title>
</head>
<body>

</body>
</html>
