<%--
  Created by IntelliJ IDEA.
  User: qiyu
  Date: 2017-11-19
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
    <title>处理汉字信息</title>
</head>
<body>

</body>
<%
    String text = request.getRequestedSessionId();
    out.println(text);
%>
<%="hello"%>
<%=request.getProtocol()%><br>
<%
    int length = request.getContentLength();
    out.println(length);
%>
<%
    String method  = request.getMethod();
    out.println(method);
%>
<%
    String header = request.getHeader("User-Agent");
    out.println(header);
%>
<%
    String ip = request.getRemoteAddr();
    out.println("\nip: "+ip);
%>
</html>
