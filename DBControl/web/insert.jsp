<%--
  Created by IntelliJ IDEA.
  User: qiyu
  Date: 2017-12-20
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
import="java.util.*" pageEncoding="UTF-8"
%>
<%@page import="com.ch6.model.StudentInfo,com.ch6.dal.Student" %>
<%
    //设置编辑，中文数据保存不会乱码
    request.setCharacterEncoding("utf-8");
    StudentInfo info = new StudentInfo();
    Student student = new Student();
    //如果获得参数action的值为add，则表示操作者已经单击了"提交"按钮，那么将执行下面代码实现数据保存
    if("add".equals(request.getParameter("action"))){
       info.setEmail(request.getParameter("email"));
       info.setPhone(request.getParameter("phone"));
       info.setAddress(request.getParameter("address"));
       info.setName(request.getParameter("name"));
       info.setSex(request.getParameter("sex"));
       info.setNumber(request.getParameter("number"));
       //把学生信息插入列表
        student.insert(info);
    }
%>
<html>
<head>
    <title>数据添加</title>
</head>
<body>
<form id="form1" name="form1" method="post" action="insert.jsp?action=add">
    <table width="384" height="289" border="1">
        <tr>
            <td>学号</td>
            <td><input type="text" name="number" id="number"></td>
        </tr>
        <tr>
            <td>姓名</td>
            <td><input type="text" name="name" id="name"></td>
        </tr>
        <tr>
            <td>性别</td>
            <td><input type="radio" name="sex"  value="男" checked />男
                <input type="radio" name="sex"  value="女" />女
            </td>
        </tr>
        <tr>
            <td>住址</td>
            <td><input type="text" name="address" id="address"></td>
        </tr>
        <tr>
            <td>电话</td>
            <td><input type="text" name="phone" id="phone"></td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td><input type="text" name="email" id="email"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" name="button" id="button" value="提交">
                <input type="reset" name="button2" id="button2" value="重置">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
