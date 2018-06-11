<%@ page import="java.util.TreeMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="base.jsp"%>
<%
    request.setCharacterEncoding("utf-8");
    String courseid = request.getParameter("courseid");
    AdminDAO adminDAO= new AdminDAO();
    TreeMap map =  adminDAO.getPerCourse(courseid);
    TreeMap data = new TreeMap();
    if("update".equals(request.getParameter("action")))
    {
        data.put("course_name",request.getParameter("course_name"));
        data.put("credit",request.getParameter("credit"));
        data.put("teacher",request.getParameter("teacher"));
        data.put("classroom",request.getParameter("classroom"));
        data.put("schooltime",request.getParameter("schooltime"));
    }
    String id = request.getParameter("course_id");
    int result = adminDAO.updatenotes(data,id);
%>
<div class="container">
    <h5><b>当前位置</b>：课程管理 > 课程管理</h5>
    <div class="navbar-form">
        <form action="updatecourse.jsp?action=update" method="post">
            <table class="tab-content" style="border-collapse:separate; border-spacing:0px 10px;">
                <tr style="font-size: 30px;">请编辑下面的课程信息:</tr>
                <tr><td>课程名:&nbsp;&nbsp;<input width="150" type="text" value="<%=map.get("course_name") %>" name="course_name"></td></tr>
                <tr> <td>学分:&nbsp;&nbsp;<input type="text" value="<%=map.get("credit")%>" name="credit"></td></tr>
                <tr>    <td>教师编号:&nbsp;&nbsp;<input type="text" value="<%=map.get("teacher")%>" name="teacher"> </td></tr>
                <tr><td>教室:&nbsp;&nbsp;<input width="150" type="text" value="<%=map.get("classroom")%>" name="classroom"></td></tr>
                <tr>    <td>上课时间:&nbsp;&nbsp;<input type="text" value="<%=map.get("school_time")%>" name="school_time"> </td></tr>
                </tr>
                <tr><td><input type="submit" name="提交"></td></tr>
                <tr><td><input type="reset" name="重置"></td></tr>
                <tr><td> <input type="hidden" name="id" value="<%= request.getParameter("course_id") %>"></td></tr>
            </table>
        </form>
    </div>
</div>



