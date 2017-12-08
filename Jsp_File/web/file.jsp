<%--
  Created by IntelliJ IDEA.
  User: qiyu
  Date: 2017-11-22
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.io.*" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    byte buf[] = new byte[10000];
    try{
        String path = request.getRealPath("/");
        File fp = new File(path,"file1.txt");
        FileReader fileReader = new FileReader(fp);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String str_line = bufferedReader.readLine();
        while(str_line!=null)
        {
            out.println(str_line);
            out.println("<br>");
            str_line = bufferedReader.readLine();
        }
        bufferedReader.close();
        fileReader.close();
    }
    catch (IOException e)
    {
        out.println("文件读取失败!");
    }
%>
</body>
</html>
