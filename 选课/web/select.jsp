<%@page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@page import="com.ch6.model.StudentInfo,com.ch6.dal.Student" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>数据查询</title>
</head>
<body>
<table width="539" border="1">
    <tr>
        <td>学号</td>
        <td>姓名</td>
        <td>性别</td>
        <td>住址</td>
        <td>电话</td>
        <td>邮箱</td>
        <td>操作</td>
    </tr>
    <%
        Student student = new Student();
        List<StudentInfo> list = student.getList();
        for(StudentInfo info:list){
    %>
    <tr>
        <td><% out.print(info.getNumber()); %></td>
        <td><% out.print(info.getName()); %></td>
        <td><% out.print(info.getSex()); %></td>
        <td><% out.print(info.getAddress()); %></td>
        <td><% out.print(info.getPhone()); %></td>
        <td><% out.print(info.getEmail()); %></td>
        <td><a href="update.jsp?id=<%=info.getId()%>">编辑</a>|
            <a href="delete.jsp?id=<%=info.getId() %> ">删除</a>
        </td>
    </tr>
    <% } %>
</table>
</body>
</html>


