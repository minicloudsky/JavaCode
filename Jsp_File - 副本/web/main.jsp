<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
</head>
<body>
<h1>马月华&nbsp; &nbsp;&nbsp; 15031210133</h1>
<form action="main.jsp" method="post">
    计算圆的面积:<br>
    半径：<input type="text" name="r"><br>
    计算梯形的面积：<br>
    长：<input type="text" name="a"><br>
    宽：<input type="text" name="b"><br>
    高：<input type="text" name="h"><br>
    <input type="submit" value="计算"><br>
</form>
<%
    String r=request.getParameter("r");
    String a=request.getParameter("a");
    String b=request.getParameter("b");
    String h=request.getParameter("h");
    if(r!=null)
    {
%>
<jsp:include page="circle.jsp">
    <jsp:param value="<%=r %>" name="r"/>
</jsp:include><br>
<%
    }
    if(a!=null&&b!=null&&h!=null)
    {
%>
<jsp:include page="ladder.jsp">
    <jsp:param value="<%=a %>" name="a"/>
    <jsp:param value="<%=b %>" name="b"/>
    <jsp:param value="<%=h %>" name="h"/>
</jsp:include>
<%
    }
%>
</body>
</html>