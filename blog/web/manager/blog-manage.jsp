<%--
  Created by IntelliJ IDEA.
  User: qiyu
  Date: 2018-06-07
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         import="com.model.BlogInfo,com.dal.Blog"
         language="java" %>
<%@include file="islogin.jsp"%>
<!-- 配置文件 -->
<script type="text/javascript" src="../ueditor/ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script type="text/javascript" src="../ueditor/ueditor.all.js"></script>
<!-- 实例化编辑器 -->
<%
    request.setCharacterEncoding("utf-8");
    Blog blog = new Blog();
    String keyword = request.getParameter("keyword");
    List<BlogInfo> list = blog.getList(keyword);
%>

<body>

<p>当前位置: 博文管理</p>
<form id="form1" name="form1" method="post" action="blog-manage.jsp">
    查询条件: 博文标题
    <input type="text" name="keyword" id="keyword"/>
    <input type="submit" name="button" id="button" value="查询"/>
</form>
<table width="98%" border="1">
    <tr>
        <td>博文标题</td>
        <td>博文分类</td>
        <td>发布时间</td>
        <td>操作</td>
    </tr>
    <%
        for(BlogInfo info: list){
    %>
    <tr>
        <td><%=info.getTitle()%></td>
        <td><%=info.getClassName()%></td>
        <td><%=info.getCreatedtime()%></td>
        <td> <a href="blog-edit.jsp?id=<%=info.getId()%>&action=edit">编辑</a> |
            <a href="blog-delete.jsp?id=<%=info.getId()%>">删除</a> |
            <a href="comment-manage.jsp?blogid=<%=info.getId()%>">评论</a>
        </td>
    </tr>
    <%}%>
</table>
</body>
