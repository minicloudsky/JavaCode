<%--
  Created by IntelliJ IDEA.
  User: qiyu
  Date: 2018-06-07
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         import="java.util.*" pageEncoding="UTF-8"
         import ="com.common.Utility"
         import="com.common.DataValidator"
         language="java" %>
<%
    String data = Utility.readCookie(request,"admin");
    if(DataValidator.isNullOrEmpty(data)){
        response.sendRedirect("login.jsp");
    }
%>
