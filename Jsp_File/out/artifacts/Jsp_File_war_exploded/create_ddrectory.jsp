<%--
  Created by IntelliJ IDEA.
  User: qiyu
  Date: 2017-11-22
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.io.*" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<font size="2">

    <%
        File dir = new File("D:\\Software\\tomcat8.0");
        File file[] = dir.listFiles();
    %>
    <p>列出root下长度大于800字节的文件和全部目录</p></br>
    root目录下的目录有:
    <% for(int i=0,number=0;(i<file.length)&&(number<=5);i++)
    {
        if(file[i].length()>=1000)
            out.println("<br>"+file[i].toString());
        number++;
    }
    %>
    <br>
    <%--
    <%
        File dir = new File("D:\\hello","Assembly");
    %>
    <p>在javaweb目录下创建一个新的目录,Assembly</p><br>
    <p>创建是否成功?</p>
    <%=dir.mkdir()%>
    <p>is dir ？</p>
    <%=dir.isDirectory()%>
    --%>
</font>
</body>
</html>
