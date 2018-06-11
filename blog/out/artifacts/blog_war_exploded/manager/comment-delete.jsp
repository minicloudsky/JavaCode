<%@ page import="com.dal.Comment" %>
<%@ page import="com.common.DataConverter" %><%--
  Created by IntelliJ IDEA.
  User: qiyu
  Date: 2018-06-07
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@include file="islogin.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Comment comment = new Comment();
    int result = 0;
    result = comment.delete(DataConverter.toInt(request.getParameter("id")));
    if(result==1){
        out.println("<script>alert('博文评论删除成功');window.location.href('comment-manage.jsp?blogid="+request.getParameter("blogid")+"');</script>");
    } else {
        out.println("<script>alert('博文评论删除失败');window.location.href('comment-manage.jsp?blogid="+request.getParameter("blogid")+"');</script>");
    }
%>