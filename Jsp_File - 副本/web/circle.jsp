<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
</head>
<body>
<%!
    public String Area(double r)
    {
        double area=r*r*3.1415926;
        return String.valueOf(area);
    }
%>
<%
    String r=request.getParameter("r");
    double s=Double.parseDouble(r);
    String A=Area(s);
%>
圆形的面积是：<%=A %>
</body>
</html>