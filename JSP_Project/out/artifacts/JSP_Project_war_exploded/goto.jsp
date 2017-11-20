<%--
  Created by IntelliJ IDEA.
  User: qiyu
  Date: 2017-11-07
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>goto.jsp</title>
</head>
<body>
<%
    String address = request.getParameter("where");
    if(address!=null)
    {
        if(address.equals("baidu"))
            response.sendRedirect("http://www.baidu.com");
        else if(address.equals("taobao"))
            response.sendRedirect("http://www.taobao.com");
        else if(address.equals("sun"))
            response.sendRedirect("http://www.sun.com");
    }
%>
<h1>response 对象使用</h1>
<b>Please select:</b><br>
<form action="goto.jsp" method="post">
    <select name="where">
        <option value="baidu" selected> go to baidu</option>
        <option value="taobao">got to taobao</option>
        <option value="sun">go tot sun</option>
    </select>
    <input type="submit" value="go">
</form>
</body>
</html>
