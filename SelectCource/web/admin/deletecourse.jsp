<%@ page import="java.util.TreeMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="base.jsp"%>
<%
    String courcesid = request.getParameter("courcesid");
    AdminDAO adminDAO= new AdminDAO();
    int result =  adminDAO.deletecourses(courcesid);
    if(result==1){
%>

<div class="container">
    <label><%="删除成功!"%></label>
    <%} else{ %>
    <label><%="删除失败!"%></label>
    <%}%>
</div>

