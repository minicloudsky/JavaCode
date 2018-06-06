<%@ page import="java.util.TreeMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="base.jsp"%>
<%
    request.setCharacterEncoding("utf-8");
    String notesid = request.getParameter("notesid");
    AdminDAO adminDAO= new AdminDAO();
    TreeMap map =  adminDAO.getPerNotes(notesid);
    TreeMap data = new TreeMap();
    if("update".equals(request.getParameter("action")))
    {
        data.put("title",request.getParameter("title"));
        data.put("start_time",request.getParameter("start_time"));
        data.put("stop_time",request.getParameter("stop_time"));
        data.put("description",request.getParameter("description"));
    }
    String id = request.getParameter("id");
    int result = adminDAO.updatenotes(data,id);
%>
<div class="container">
    <h5><b>当前位置</b>：公告管理 > 公告管理</h5>
    <div class="navbar-form">
        <form action="update_notes.jsp?action=update" method="post">
            <table class="tab-content" style="border-collapse:separate; border-spacing:0px 10px;">
                <tr style="font-size: 30px;">请编辑下面的公告信息:</tr>
                <tr><td>标题:&nbsp;&nbsp;<input width="150" type="text" value="<%=map.get("title") %>" name="title"></td></tr>
                <tr> <td>开始时间:&nbsp;&nbsp;<input type="text" value="<%=map.get("start_time")%>" name="start_time"></td></tr>
                <tr>    <td>结束时间:&nbsp;&nbsp;<input type="text" value="<%=map.get("stop_time")%>" name="stop_time"> </td></tr>
                <tr><td>公告内容:&nbsp;&nbsp;<input width="150" type="text" value="<%=map.get("description")%>" name="description"></td></tr>
                </tr>
                <tr><td><input type="submit" name="提交"></td></tr>
                <tr><td><input type="reset" name="重置"></td></tr>
                <tr><td> <input type="hidden" name="id" value="<%= request.getParameter("notesid") %>"></td></tr>
            </table>
        </form>
    </div>
</div>



