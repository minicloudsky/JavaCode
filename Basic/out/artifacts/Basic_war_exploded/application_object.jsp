<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>app_object</title>
</head>
<body>
<%
    String count = (String)application.getAttribute("count");
    if(count==null)
        count = "1";
    else
        count = Integer.parseInt(count)+1+"";
    application.setAttribute("count",count);
%>
<%="<h3>到目前为止，访问该企业网站的人数为: "+count+"</h3></br>"%>
</body>
</html>
