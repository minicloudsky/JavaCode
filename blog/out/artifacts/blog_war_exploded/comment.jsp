<%@ page import="com.dal.Users" %>
<%@ page import="com.common.MD5" %>
<%@ page import="com.common.DataConverter" %>
<%@ page import="com.common.Utility" %>
<%@ page import="com.dal.Comment" %>
<%@ page import="com.model.CommentInfo" %>
<%@ page import="com.common.DataValidator" %><%--
  Created by IntelliJ IDEA.
  User: qiyu
  Date: 2018-06-08
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if("login".equals(request.getParameter("action"))) {
        Users users = new Users();
        String username = request.getParameter("txtUserName");
        String password = MD5.Encrypt(request.getParameter("txtPassword"));
        if (!users.isExist(username, password)) {
            out.println("<script>alert('用户名密码错误');window.location.href('blog-information.jsp?id='" +
                    DataConverter.toInt(request.getParameter("id")) + "');</script>");
        } else {
            Utility.writeCookie(response, "user", username);
            response.sendRedirect("blog-information.jsp?id=" + DataConverter.toInt(request.getParameter("id")));
        }
    }
    if("save".equals(request.getParameter("action"))){
        Comment comment = new Comment();
        CommentInfo info = new CommentInfo();
        info.setBlogid(DataConverter.toInt(request.getParameter("id")));
        info.setContext(request.getParameter("txtContext"));
        info.setUsername(Utility.readCookie(request,"user"));
        comment.insert(info);
        response.sendRedirect("blog-information.jsp?id=" +DataConverter.toInt(request.getParameter("id")));
    }
%>
<%
    String data = Utility.readCookie(request,"user");
    if(DataValidator.isNullOrEmpty(data)){
%>
<form id="form1" name="form1" method="post" action="comment.jsp?action=login">
    <table width="400" border="0">
        <tr>
            <td>用户名:</td>
          <td><input type="hidden" name="id" id="userid" value="<%=request.getParameter("userid")%>"/></td>
        <td><input type="text" name="txtUserName" id="txtUserName" size="12"/></td>
            <td>密码</td>
            <td><input type="password" name="txtPassword" id="txtPassword" size="12"></td>
            <td><input type="submit" name="button" id="button" value="提交"/><a href="register.jsp">注册</a> </td>
        </tr>
    </table>
</form>
<%
    }else{
%>
欢迎您: <%=Utility.readCookie(request,"user")%><a href="logout.jsp">退出</a>
<form name="commentForm" method="post" action="comment.jsp?action=save">
    <input type="hidden" name="id" id="id" value="<%=request.getParameter("id")%>"/>
    <textarea rows="4" cols="50" name="txtContext"></textarea>
    <input type="submit" name="button" value="回复">
</form>
<%}%>