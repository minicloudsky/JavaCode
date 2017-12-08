<%--
  Created by IntelliJ IDEA.
  User: qiyu
  Date: 2017-11-19
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" import="java.util.*" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<%
    if("LoginAction".equals(request.getParameter("action"))) {
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        if ("admin".equals(username)&&"1234".equals(pwd)) {
            session.setAttribute("CurrentUser", username);
            response.sendRedirect("index.jsp");
        }
        else
        {
            out.println("<script>alert('用户名或密码不正确');window.location.href('index.jsp)</script>");
        }
    }
%>
<% if(session.getValue("CurrentUser")!=null){ %>
<table width="200" border="0">
    <tr>
        <td>欢迎您:<%=session.getValue("CurrentUser")%></td>
    </tr>
    <tr>
        <td><a href="edit.jsp">编辑个人资料</a></td>
    </tr>
    <tr>
        <td><a href="logout.jsp" >退出登录</a> </td>
    </tr>
</table>
<%
    }else{
%>
<form id="form1" name = "form1" method="post" action="login.jsp?action=LoginAction">
<table width="199" border="0">
    <tr>
        <td colspan="2">登录窗口</td>
        <td><input name="username" type="text" size ="12"></td>
    </tr>
    <tr>
        <td>密码</td>
        <td><input name="pwd" type= "text" size="12"></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit"  name="button" id="button" value="登录">
            <input type="reset" name="button2" id="button2" value="重置">
        </td>
    </tr>
</table>
</form>
<% } %>
</body>
</html>
