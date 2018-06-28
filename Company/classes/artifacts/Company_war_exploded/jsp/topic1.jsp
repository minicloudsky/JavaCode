<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'topic1.jsp' starting page</title>
    
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
  		<table  width="1100px" align="center"  cellspacing="0">
			<tr>
				<td colspan="4">
					<table width="100%" >
						<tr height="50px">
							<td><img src="${pageContext.request.contextPath}/img/logo.jpg"/></td>
							<td style="left:30%;"><font size="6" face="黑体"><strong>国内辣条健康品牌</strong></font></td>
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
																		<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 卫龙（SUNICES）是国内速冻食品健康品牌，是营养健康、方便快捷概念的首倡者。<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 上海卫龙食品有限公司，成立于2012年，属永益集团全资子公司。卫龙专注于食品安全、营养与健康，三十年出口品质保证，纵横北美、欧洲与日本，卫龙不仅是消费者的食品安全保证，更是一种高品质的生活选择。<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 卫龙所有原料均来自专属基地， GAP（良好农业规范）覆盖整个种植管理流程，先进的快速冷冻技术最大程度保留了辣条的各种营养成分和自然风味，在您需要的时候，信手可得。<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 无论盛夏酷暑，还是冰天雪地，卫龙都将带你尽情领略辣条物语中的欧陆风情，触动味蕾间的极致感受。<br />
&nbsp;</p>
<p>&nbsp;</p>
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
