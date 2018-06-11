<%@ page import="com.common.Utility" %>
<table width="256" border="0">
    <tr><td>博客系统后台</td></tr>
    <tr><td>欢迎您: <%=Utility.readCookie(request,"admin")%>
        <a href="logout.jsp" target="_parent">退出</a> </td></tr>
    <tr><td><a href="/blog/manager/blog-edit.jsp?action=add" target="rightFrame">发布博文</a> </td></tr>
    <tr><td><a href="/blog/manager/blog-manager.jsp">博文管理</a> </td></tr>
    <tr><td>&nbsp;</td></tr>
    <tr><td><a href="/blog/manager/class-edit.jsp?action=add">添加博文分类</a> </td></tr>
    <tr> <td><a href="/blog/manager/class-manage.jsp" target="rightFrame">博文分类管理</a> </td></tr>
    <tr><td>&nbsp;</td></tr>
    <tr><td><a href="/blog/manager/users-manage.jsp" target="rightFrame">用户管理</a> </td></tr>
</table>