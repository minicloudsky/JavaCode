<%@ page import="com.common.Utility" %>
<%@ page import="com.common.DataValidator" %><%--
  Created by IntelliJ IDEA.
  User: qiyu
  Date: 2018-06-08
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String data = Utility.readCookie(request,"user");
    if(DataValidator.isNullOrEmpty(data)){
        response.sendRedirect("index.jsp");
    } else {
        Utility.writeCookie(response,"user",data,0);
        response.sendRedirect("index.jsp");
    }
%>
