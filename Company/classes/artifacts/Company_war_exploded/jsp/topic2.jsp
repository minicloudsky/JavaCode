<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="com.domain.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'topic2.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <%
  	List<Product> list=(List<Product>)request.getAttribute("productlist");
   %>
  <body>
    		<table  width="1100px" align="center" 
 cellspacing="0">
			<tr>
				<td colspan="4">
					<table width="100%" >
						<tr height="50px">
							<td><img src="${pageContext.request.contextPath}/img/logo.jpg"/></td>
							<td style="left:30%;"><font size="6" face="黑体"><strong>国内绿色辣条健康品牌</strong></font></td>
						</tr>
					</table>
				</td>
			</tr>
			<!--2.导航栏-->
			<tr>
				<td bgcolor="forestgreen" height="50px" colspan="4">
									&nbsp;
					<a href="${pageContext.request.contextPath}/jsp/index.jsp" style="text-decoration:none;"><font size="5" color="white">首页</font></a>&nbsp;&nbsp;&nbsp;
					<a href="${pageContext.request.contextPath}/jsp/topic1.jsp" style="text-decoration:none;"><font size="3" color="white">企业概况</font></a>&nbsp;&nbsp;&nbsp;
					<a href="${pageContext.request.contextPath}/jsp/topic2.jsp"style="text-decoration:none;"><font size="3" color="white">产品中心</font></a>&nbsp;&nbsp;&nbsp;
					<a href="${pageContext.request.contextPath}/GetUser"style="text-decoration:none;"><font size="3" color="white">新闻中心</font></a>&nbsp;&nbsp;&nbsp;
					<a href="${pageContext.request.contextPath}/jsp/topic4.jsp"style="text-decoration:none;"><font size="3" color="white">客户反馈</font></a>&nbsp;&nbsp;&nbsp;
					<a href="${pageContext.request.contextPath}/jsp/topic5.jsp"style="text-decoration:none;"><font size="3" color="white">质量保证</font></a>&nbsp;&nbsp;&nbsp;
					<a href="${pageContext.request.contextPath}/jsp/topic6.jsp"style="text-decoration:none;"><font size="3" color="white">招商信息</font></a>&nbsp;&nbsp;&nbsp;
					<a href="${pageContext.request.contextPath}/jsp/topic7.jsp"style="text-decoration:none;"><font size="3" color="white">联系我们</font></a>
				</td>
			</tr>
			<tr>
				<td align="center" colspan="4"><img src="${pageContext.request.contextPath}/img/1.jpg" width="1100px;"/></td>
			</tr>
			<tr align="center" style="margin-top:10px;">
				<td style="margin-top:10px;"><form action="${pageContext.request.contextPath}/ProductServlet?classify=<%=1 %>" method="post"><input type="submit" value="绿色辣条系列" style="height:30px;font-size:medium;font-weight:bold;background-color:forestgreen;color: white;border-radius:calc()"></form></td>
				<td><form action="${pageContext.request.contextPath}/ProductServlet?classify=<%=2 %>" method="post"><input type="submit" value="绿色蔬菜系列" style="height:30px;font-size:medium;font-weight:bold;background-color:forestgreen;color: white;border-radius:calc()"></form></td>
				<td><form action="${pageContext.request.contextPath}/ProductServlet?classify=<%=3 %>" method="post"><input type="submit" value="冻吧系列" style="height:30px;font-size:medium;font-weight:bold;background-color:forestgreen;color: white;border-radius:calc()"></form></td>
				<td><form action="${pageContext.request.contextPath}/ProductServlet?classify=<%=4 %>" method="post"><input type="submit" value="冻菜系列" style="height:30px;font-size:medium;font-weight:bold;background-color:forestgreen;color: white;border-radius:calc()"></form></td>
			</tr>
			<tr>
				<td colspan="4">
					<table align="center" width="90%">
						<tr>
						<%
							if(list!=null)
							{
								for(int i=0;i<list.size();i++)
								{
						%>
							<td width="30%"><div><a href="${pageContext.request.contextPath}/DetailServlet?id=<%=list.get(i).getPid()%>"><img src="${pageContext.request.contextPath}/<%=list.get(i).getImg()%>" width="200px" height="200px"><br/><font style="text-align:center;"><strong><%=list.get(i).getPname()%></strong></font></a></div></td>
						<%}}%>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="4">
									<table align="center" bgcolor="black" width="100%" style="text-align: center;">  
						<tr>
							<td><font color="white">版权所有：安阳市卫龙食品有限公司</font></td>
						</tr>
						<tr>
							<td><font color="white">&nbsp;技术支持</font></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
  </body>
</html>
