<%@ page import="com.model.UsersInfo" %>
<%@ page import="com.dal.Users" %>
<%@ page import="com.common.MD5" %><%--
  Created by IntelliJ IDEA.
  User: qiyu
  Date: 2018-06-08
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");
    String action = request.getParameter("action");
    UsersInfo info = new UsersInfo();
    Users user = new Users();
    if("reg".equals(action)){
        if(user.isExistUsersInfo(request.getParameter("txtUserName"))){
            out.println("<script>alert('用户已经存在');window.location.href('register.jsp');</script>");
        }else{
            info.setUsername(request.getParameter("txtUserName"));
            info.setPassword(MD5.Encrypt(request.getParameter("txtPassword")));
            info.setEmail(request.getParameter("txtEmail"));
            info.setPower("user");
            user.insert(info);
            out.println("<script>alert('注册成功');window.locaation.href('index.jsp');</script>");
        }
    }
%>
...
<!-- start content -->
<div id="content">
    <form id="form1" name="form1" method="post" action="register.jsp?action=reg">
        <table width="100%" border="0">
            <tr>
                <td>用户名</td>
                <td><input type="text" name="txtUserName" id="txtUserName" width="500px"/></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="txtPassword" id="txtPassword" width="500px"/></td>
            </tr>
            <tr><td>确认密码</td>
                <td><input type="password" name="txtPassword2" id="txtPassword2" width="500px"/></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" name="txtEmail" width="500px"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" name="button" id="button" value="注册"/>
                    <input type="reset" name="button2" id="button2" value="重置"/>
                </td>
            </tr>
        </table>
    </form>
</div>
<!-- -->