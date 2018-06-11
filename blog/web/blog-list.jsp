<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.model.BlogInfo" %>
<%@page import="com.dal.Blog" %>
<%@page import="com.common.DataValidator" %>
<%@page import="com.common.Utility" %>
<%@page import="com.dal.Class" %>
<%@page import="com.model.ClassInfo" %>
<%@page import="com.common.DataConverter" %>
<%
	Blog blog = new Blog();
	int classid = DataConverter.toInt(request.getParameter("classid"));
	List<BlogInfo> list = blog.getListByClassId(classid);
	//获得博文分类
	Class cls = new Class();
	List<ClassInfo> clist = cls.getList();
%>
..
<!-- start content -->
<div id="content">
	<%
	//遍历输出list集合中的数据
	for(BlogInfo info: list){
	%>
	<div class="post">
		<h1 class="title">
		<a href="blog-information.jsp?id=<%=info.getId()%>"><%=info.getTitle()%></a>
		</h1>
		<p class="byline"><small><%=info.getCreatedtime()%></small></p>
		<div class="entry">
			<p><%=Utility.SubString(DataValidator.removeHtml(info.getContext()),300) %></p>
        </div>
        <p class="meta"> <a href="#" class="more">分类:<%=info.getClassName()%></a> &nbsp;&nbsp;&nbsp;
        <a href="#" class="more">详情</a>&nbsp;&nbsp;&nbsp;
        </p>
	</div>
    <%
            }
    %>
    <!-- end content -->



