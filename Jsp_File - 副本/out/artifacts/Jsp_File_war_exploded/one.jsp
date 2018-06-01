<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
    <jsp:include page="head.txt" />
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body >
<h1>马月华 15031210133</h1>
<form action="one.jsp" method=get name=form>
    请输入1~100之间的整数：<input type="text" name="number" />
    <br>
    <input type="submit" name="sub" value="送出"/>
</form>
<%
    String num=request.getParameter("number");
    if(num==null)
        num="0";
    try{
        int n=Integer.parseInt(num);
        if(n>=1&&n<=50)
        {
%>
<jsp:forward page="two.jsp" >
    <jsp:param name="number" value="<%=n %>"/>
</jsp:forward>
<%
}
else if(n>50&&n<=100)
{
%>
<jsp:forward page="three.jsp">
    <jsp:param name="number" value="<%=n %>"/>
</jsp:forward>
<%
}
else if(n>100)
{
%>
<jsp:forward page="error.jsp">
    <jsp:param name="number" value="<%=n %>"/>
</jsp:forward>
<%
    }
}
catch(Exception e)
{
%>
<jsp:forward page="error.jsp">
    <jsp:param name="mess" value="<%=e.toString() %>"/>
</jsp:forward>
<%
    }
%>
</body>
</html>