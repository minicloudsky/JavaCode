<%@ page import="java.util.TreeMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="base.jsp"%>
<%
    String notesid = request.getParameter("notesid");
    AdminDAO adminDAO= new AdminDAO();
    int result =  adminDAO.deletenotes(notesid);
    if(result==1){
%>

<div class="container">
    <label><%="删除成功!"%></label>
    <%} else{ %>
    <label><%="删除失败!"%></label>
    <%}%>
</div>

