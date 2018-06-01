<%--
  Created by IntelliJ IDEA.
  User: qiyu
  Date: 2017-11-22
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
import="java.io.*" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    String path = request.getRealPath("");
    File file = new File(path,"File.txt");
    if(file.exists())
    {
        file.delete();
        out.println(path+"文件File.txt文件已经删除");
    }
    else
    {
        file.createNewFile();
        out.println(path+"文件File.txt创建成功");
    }
%>
</body>
</html>
