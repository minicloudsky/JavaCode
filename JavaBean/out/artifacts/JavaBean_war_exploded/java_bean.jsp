<%--
  Created by IntelliJ IDEA.
  User: qiyu
  Date: 2017-11-22
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=gb2312" language="java"
import="javabean.User" %>
<html>
<head>
    <title>�û���Ϣ</title>
</head>
<body>
<!--ָ��javabeanʵ��������Ӧ�����淶Χ��ȫ�޶�����-->
<jsp:useBean id="userbean" scope= "page" class="User"></jsp:useBean>
<!--ʹ��jsp:setProperty����ָ������username����ֵ-->
<jsp:setProperty  name = "userbean" property= "username"  param="username" ></jsp:setProperty>
<jsp:setProperty name = "userbean" property="password" param="password"></jsp:setProperty>
�û���:
<jsp:getProperty name= "userbean" property= "username"></jsp:getProperty> </br>
����:
<jsp:getProperty name= "userbean" property= "password" ></jsp:getProperty>
<%
    out.println("�û���: "+userbean.getUsername() + "</br>");
    out.println("����: " + userbean.getPassword());
%>
</body>
</html>
