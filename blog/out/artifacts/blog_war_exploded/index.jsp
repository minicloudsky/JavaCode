<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page import="com.model.BlogInfo,com.dal.Blog" %>
<%@ page import="com.common.DataValidator" %>
<%@ page import="com.common.Utility" %>
<%@ page import="com.dal.Class" %>
<%@ page import="com.model.ClassInfo" %>
<%
	Blog blog = new Blog();
	List<BlogInfo> list = blog.getList("java");
	//获取博文分类
	Class cls = new Class();
	List<ClassInfo> clist = cls.getList();
%>
...
<!-- start content -->
<div class="content">
	<%
		for(BlogInfo info: list){
	%>
	<div class="post">
		<h1 class="title"><a href="blog-information.jsp?id=<%=info.getId()%> "><%=info.getTitle()%></a></h1>
		<p class="byline"><small><%=info.getCreatedtime()%></small></p>
		<div class="entry">
			<p><%=Utility.SubString(DataValidator.removeHtml(info.getContext()),300) %></p>
		</div>
		<p class="meta"><a href="#" class="more">分类:<%=info.getClassName()%></a>
			&nbsp;&nbsp;&nbsp;<a href="#" class="more">详情</a>&nbsp;&nbsp;&nbsp;
			<a href="blog-information.jsp?id=<%=info.getId()%>#comment" class="comments">我要评论</a></p>
	</div>
	<%
		}
	%>
</div>
<!-- end content -->
...
<!-- start sidebar -->
<div id="sidebar">
	<ul>
		<li>
			<h2>日志分类</h2>
			<ul>
				<% for(ClassInfo cinfo: clist) {%>
				<li><a href="blog-list.jsp?classid=<%=cinfo.getId()%>">
					<%=cinfo.getName()%></a></li>
				<%}%>
			</ul>
		</li>
	</ul>
</div>
<!-- end sidebar -->











