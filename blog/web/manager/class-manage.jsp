<%@ page import="com.dal.Class" %>
<%@ page import="com.model.ClassInfo" %><%--
  Created by IntelliJ IDEA.
  User: qiyu
  Date: 2018-06-07
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="islogin.jsp"%>
<%
    request.setCharacterEncoding("UTF-8");
    Class cls = new Class();
    String keyword = request.getParameter("keyword");
    List<ClassInfo> list = cls.getList();
%>
...
<body>
<p>
    当前位置: 分类管理
</p>
<table width="98%" border="1">
    <tr>
        <td>名称</td>
        <td>排序</td>
        <td>操作</td>
    </tr>
    <%
        //遍历输出list集合中的数据
        for(ClassInfo info: list){
    %>
    <tr>
        <td><%=info.getName()%></td>
        <td><%=info.getSort()%></td>
        <td>
            <a href="class-edit.jsp?id=<%=info.getId()%>&action=edit">编辑</a>|
            <a href="class-delete.jsp?id=<%=info.getId()%>">删除</a>
        </td>
    </tr>
    <%
        }
    %>
</body>