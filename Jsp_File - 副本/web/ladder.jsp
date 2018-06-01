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
    public String Area(double a,double b,double c)
    {
        double area=((a+b)*c)/2;
        return String.valueOf(area);
    }
%>
<%
    String a=request.getParameter("a");
    String b=request.getParameter("b");
    String h=request.getParameter("h");
    double s1=Double.parseDouble(a);
    double s2=Double.parseDouble(b);
    double s3=Double.parseDouble(h);
    String A=Area(s1,s2,s3);
%>
梯形的面积是：<%=A %>
</body>
</html>