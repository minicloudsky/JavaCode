<%@ page import="com.dal.Blog" %>
<%@ page import="com.common.DataConverter" %><%--
  Created by IntelliJ IDEA.
  User: qiyu
  Date: 2018-06-07
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@include file="islogin.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //创建对象
    Blog blog = new Blog();
    int result = 0;
    result = blog.delete(DataConverter.toInt(request.getParameter("id")));
    if(result==1){
        out.println("<script>alert('博文删除成功');window.location.href('blog-manage.jsp');</script>");
    }
    else{
        out.println("<script>alert('博文删除失败');window.location.href('blog-manage.jsp');</script>");
    }
%>