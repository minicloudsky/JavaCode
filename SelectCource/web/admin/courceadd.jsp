<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8"
%>
<%@include file="base.jsp"%>
<%@ page import="lib.Model.User,lib.Dao.AdminDAO" %>
<html>
<head>
    <title></title>
</head>
<%
    request. setCharacterEncoding("UTF-8");
    String course = "";
    int score = 0;
    String teacher = "";
    String schooltime = "";
    String classroom = "";
    int result = 0;
    AdminDAO studentDAO = new AdminDAO();
    AdminDAO adminDAO = new AdminDAO();
    if("add".equals(request.getParameter("action"))){
        course = request.getParameter("cource_name");
        score  = Integer.parseInt(request.getParameter("credit"));
        teacher = request.getParameter("teacher");
        schooltime = request.getParameter("school_time");
        classroom = request.getParameter("class_room");
        adminDAO.addCourse(course,score,teacher,schooltime,classroom);
    }
%>
<%=classroom%>
<body>
<div class="container">
    <h5><b>当前位置</b>：课程管理 > 添加课程</h5>
    <hr>
    <div class="courceadd">
        <form  action="./courceadd.jsp?action=add" method="post">
            <div>
                <label>课程名称</label>
                <input type="text" placeholder="如: Java,php" name="cource_name"/>
            </div>
            <div>
                <label id="credit">学分</label>
                <input type="text" placeholder="如：1.5" name="credit"/>
            </div>
            <div>
                <label>任课教师</label>
                <input type="text" placeholder="如: 3" name="teacher"/>
            </div>
            <div>
                <label>上课教室</label>
                <input type="text" placeholder="如：4" name="class_room"/>
            </div>
            <div>
                <label>上课时间</label>
                <input  type="text" placeholder="如：周三7,8节" name="school_time"/>
            </div>
            <br>
            <button type="submit" class="btn btn-primary">添加</button>
            <button type="reset" class="btn btn-warning">重置</button>
        </form>
    </div>
</div>
</body>
</html>
