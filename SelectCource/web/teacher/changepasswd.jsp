<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="base.jsp"%>
<%@ page import="lib.Model.User" %>
<html>
<head>
    <title></title>
</head>
<%
    String useremail = ((User)session.getAttribute("currentUser")).getEmail();
    String newpassword = "";
    int result = 0;
    TeacherDAO teacherDAO = new TeacherDAO();
    if("update".equals(request.getParameter("action"))){
        newpassword  = request.getParameter("new_password2");
       result = teacherDAO.updtaePassword(newpassword,useremail);
    }
%>
<body>
  <div class="container">
    <h5><b>当前位置</b>：个人信息 > 密码修改</h5>
    <hr>
    <div class="changepasswd">
      <form action="./changepasswd.jsp?action=update" method="post">
        <div>
          <label style="padding-left: 15px">旧密码</label>
          <input type="text" name="old_password"/>
        </div>
        <div>
          <label style="padding-left: 15px">新密码</label>
          <input type="text" name="new_password"/>
        </div>
        <div>
          <label>确认密码</label>
          <input type="text" name="new_password2"/>
        </div>
        <div style="padding-top: 15px">
          <button type="submit" class="btn btn-primary" onclick="alert('密码更新成功');">添加</button>
          <button type="reset" class="btn btn-warning">重置</button>
        </div>
      </form>
    </div>
  </div>
</body>
</html>
