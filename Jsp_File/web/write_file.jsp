<%--
  Created by IntelliJ IDEA.
  User: qiyu
  Date: 2017-11-22
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
import="java.io.*" %>
<html>
<head>
    <title>写入文件</title>
</head>
<body>

<%
    String path = request.getRealPath("/");
    File file = new File(path,"file2.txt");
    FileWriter fileWriter = new FileWriter(file);
    FileWriter

    
%>
</body>
</html>
