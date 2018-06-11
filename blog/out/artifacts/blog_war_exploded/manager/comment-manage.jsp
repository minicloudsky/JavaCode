<%@ page import="com.dal.Comment" %>
<%@ page import="com.model.CommentInfo" %>
<%@ page import="com.common.DataConverter" %><%--
  Created by IntelliJ IDEA.
  User: qiyu
  Date: 2018-06-07
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="islogin.jsp"%>
<%
    request.setCharacterEncoding("UTF-8");
    Comment comment = new Comment();
    String keyword = request.getParameter("keyword");
    int blogid = DataConverter.toInt(request.getParameter("blogid"));
    List<CommentInfo> list = comment.getListByBlogId(blogid);
%>
...

<body>
<p>
    当前位置: 评论管理
</p>
<table width="98%" border="1">
    <tr>
        <td>评论内容</td>
        <td>评论人</td>
        <td>评论时间</td>
        <td>操作</td>
    </tr>
    <%
        //遍历输出list集合中的数据
        for(CommentInfo info: list){%>
    <tr>
        <td><%=Utility.SubString(
                DataValidator.removeHtml(info.getContext()),100)%></td>
    <td>
        <%=info.getUsername()%>
    </td>
        <td><%=info.getCreatedtime()%></td>
    <td>
        <a href="comment-delete.jsp?id=<%=info.getId()%>&blogid=<%=info.getBlogid()%>">删除</a>
    </td>
    </tr>
    <%
        }
    %>
</table>
</body>
