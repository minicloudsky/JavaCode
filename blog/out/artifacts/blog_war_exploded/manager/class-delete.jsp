<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="islogin.jsp"%>
<%@page import="com.common.DataConverter" %>
<%@page import="com.dal.Class"%>
<%
	Class cls = new Class();//创建对象
	int result =0;
	result = cls.delete(DataConverter.toInt(request.getParameter("id")));
	if(result==1){
		out.println("<script>alert('分类删除成功');window.location.href('class-manage.jsp');</script>");
	} else{
		out.println("<script>alert('分类删除失败');window.location.href=('class-manage.jsp');</script>");
	}

%>