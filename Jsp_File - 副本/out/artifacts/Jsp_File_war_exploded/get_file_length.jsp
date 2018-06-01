<%--
  Created by IntelliJ IDEA.
  User: qiyu
  Date: 2017-11-22
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
import="java.io.*" %>
<html>
<head>
    <title>get_file_length</title>
</head>
<body>

<%
    File f = new File("D:\\Software\\idea\\code\\Jsp_File\\web\\","get_file_length.jsp");
%>
<p>文件get_file_length的长度
    <%=f.length()%>字节</p></br>
<p>get_length()的父目录为:</p>
<%=f.getParent()%><br>
<p>file的绝对路径为:</p>
<%=f.getAbsolutePath()%>
</body>
</html>
