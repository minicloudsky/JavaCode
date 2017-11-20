<%--
  Created by IntelliJ IDEA.
  User: qiyu
  Date: 2017-11-19
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
import="java.util.*" errorPage="" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<% int n=0;
    String s1 = request.getParameter("R");
    String s2 = request.getParameter("P");
    if(s1==null)
        s1 = "";
    if(s2==null)
        s2 = "";
    if(s1.equals("b"))
        n++;
    if(s2.equals("a"))
        n++;
%>
<p>您得了<%=n%>分</p>
</body>
</html>
