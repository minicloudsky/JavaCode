<%@page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@page import="com.model.BlogInfo"%>
<%@page import="com.dal.Blog"%>
<%@page import="com.common.DataValidator"%>
<%@page import="com.common.Utility"%>
<%@page import="com.dal.Class"%>
<%@page import="com.model.ClassInfo"%>
<%@page import="com.common.DataConverter"%>
<%@page import="com.model.CommentInfo"%>
<%@page import="com.dal.Comment"%>
<%
	int id = DataConverter.toInt(request.getParameter("id"));
	Blog blog = new Blog();
	BlogInfo info = blog.getBlogInfo(id);
	if(info == null){
	out.println("<script>alert('博文id有误');window.location.href('index.jsp');</script>");
}

%>
...
<!-- start content -->
<div id="content">
	<div class="post">
		<h1 class="title"><%=info.getTitle() %></h1>
		<p class="byline"> <small><%=info.getCreatedtime()%></small></p>
		<div class="entry">
			<p><%=DataValidator.serverHtmlDecode(info.getContext()) %></p>
		</div>
		<p class="meta"><a href="#" class="more">分类: <%=info.getClassName()%></a></p>
	</div>
	<a name="comment" id="comment"></a>
	<p class="meta">评论:</p><br>
	<%
	Comment comment = new Comment();
	List<CommentInfo> cmlist = comment.getListByBlogId(id);
	for(CommentInfo cminfo: cmlist){
	out.println(cminfo.getContext() + "<br>");
	out.println(cminfo.getCreatedtime() + "&nbsp;&nbsp;&nbsp;&nbsp;" + cminfo.getUsername() + "<br><hr>");
}

%>
<jsp:include page="comment.jsp">
<jsp:param value="<%=id%>" name="id"/>
</jsp:include>
</div>
<!-- end content -->