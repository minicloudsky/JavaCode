<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="islogin.jsp"%>
<%@page import="com.common.DataConverter" %>
<%@page import="com.dal.Users" %>
<%
	Users user = new Users();
	int result = 0;
	result = user.delete(request.getParameter("username"));
	if(result==1){
		out.println("<script>alert('用户删除成功');window.location.href('users-manage.jsp');</script>");
	} else{
		out.println("<script>alert('用户删除失败');window.location.href('users-manage.jsp');</script>");
	}
%>