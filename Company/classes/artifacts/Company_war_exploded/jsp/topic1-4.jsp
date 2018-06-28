<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'topic1-4.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <table  width="1100px" align="center" cellspacing="0">
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
			<tr align="center">
				<td style="margin-top:10px;" width="10%"><form action="${pageContext.request.contextPath}/jsp/topic1.jsp" method="post"><input type="submit" value="公司简介" style="height:30px;font-size:medium;font-weight:bold;background-color:forestgreen;color: white;border-radius:calc()"></form></td>
				<td width="10%"><form action="${pageContext.request.contextPath}/jsp/topic1-2.jsp" method="post"><input type="submit" value="企业文化" style="height:30px;font-size:medium;font-weight:bold;background-color:forestgreen;color: white;border-radius:calc()"></form></td>
				<td width="10%"><form action="${pageContext.request.contextPath}/jsp/topic1-3.jsp" method="post"><input type="submit" value="企业理念" style="height:30px;font-size:medium;font-weight:bold;background-color:forestgreen;color: white;border-radius:calc()"></form></td>
				<td><form action="${pageContext.request.contextPath}/jsp/topic1-4.jsp" method="post"><input type="submit" value="公司荣誉" style="height:30px;font-size:medium;font-weight:bold;background-color:forestgreen;color: white;border-radius:calc()"></form></td>
			</tr>
			<tr>
				<td colspan="4">
					<p>&nbsp; &nbsp;龙头企业</p>
					<p>&nbsp; &nbsp;2003AA信用企业</p>
					<p>&nbsp; &nbsp;理事单位</p>
					<p>&nbsp; &nbsp;乡镇重点企业</p>
					<p>&nbsp; &nbsp;诚信商贸企业</p>
					<p>&nbsp; &nbsp;明星企业</p>
					<p>&nbsp; &nbsp;理事单位</p>
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
