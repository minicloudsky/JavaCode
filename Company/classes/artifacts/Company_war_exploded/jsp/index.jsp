<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
	</head>
	<body>
		<table  width="1100px" align="center" >
		
			<jsp:include page="menu.jsp" flush="true"/>
			
			<tr>
				<td align="center"><img src="${pageContext.request.contextPath}/img/1.jpg" width="1100px;"/></td>
			</tr>

			<tr>
				<td>
					<table width="100%" height="500px" >
						<tr>
							<td colspan="3" align="center"><font size="4"><strong><a href="#" style="text-decoration:none;">公司简介</a></strong></font></td>
						</tr>
						<tr>
							<td colspan="3" align="center"><font size="3">安阳卫龙食品有限公司，属永益集团全资子公司。 卫龙，永益集团旗下子品牌，国内速冻辣条健康方便概念的首倡者。
</font></td>
						</tr>
						<tr>
							<td align="center"><a href="${pageContext.request.contextPath}/ShowServlet?count=<%=1%>" style="text-decoration:none;"><img src="${pageContext.request.contextPath}/img/index1.png" width="60%" height="60%"/></a></td>
							<td align="center"><a href="${pageContext.request.contextPath}/ShowServlet?count=<%=2%>" style="text-decoration:none;"><img src="${pageContext.request.contextPath}/img/index2.png" width="60%" height="60%"/></a></td>
							<td align="center"><a href="${pageContext.request.contextPath}/ShowServlet?count=<%=3%>" style="text-decoration:none;"><img src="${pageContext.request.contextPath}/img/index3.png" width="60%" height="60%"/></a></td>
						</tr>
						<tr>
							<td align="center"><a href="${pageContext.request.contextPath}/ShowServlet?count=<%=1%>" style="text-decoration:none;">绿色基地</a></td>
							<td align="center"><a href="${pageContext.request.contextPath}/ShowServlet?count=<%=2%>" style="text-decoration:none;">化验室</a></td>
							<td align="center"><a href="${pageContext.request.contextPath}/ShowServlet?count=<%=3%>" style="text-decoration:none;">生产车间</a></td>
						</tr>
						<tr>
							<td align="center" width="33.3%"><font>永益集团本着发展绿色产业为宗旨，于2001年开始导入ＴＢＳ溯源管理系统，所有辣条来自出入境检验检疫备案基地，并于2006年顺利通过“ＧＡＰ"认证，从源头上保证了所加工产品的安全性。</font></td>
							<td align="center" width="33.3%"><font>采用”一齐分析法“一次可分析检测460多种农药，以及重金属、营养成分等项目的检测。检测结果可与36个国家试验室的结果互认。</font></td>
							<td align="center" width="33.3%"><font>永益集团有完善的车间管理制度，严格按照SSOP、HACCP、7S、TBS追溯管理体系，根据不同产品品类，制定出详细完整的加工工艺书，确定质量关键控制点。</font></td>
						</tr>
					</table>
				</td>
			</tr>
			<!--6.热门商品-->
			<tr>
				<td>
					<table  width="100%" bgcolor="bisque" style="background-image: url(${pageContext.request.contextPath}/img/border.jpg)no-repeat;"> 
						<tr>
							<td colspan="2" align="center"><font size="4"><strong>新闻中心</strong></font></td>
						</tr>
						<tr>
							<td colspan="2" align="center">卫龙将在第一时间把工作部署和公司发展动向通知大家，给大家提供良好的工作环境和氛围！</td>
						</tr>
						<tr>
							<td align="center"><a href="${pageContext.request.contextPath}/GetUser" style="text-decoration:none;"><img src="${pageContext.request.contextPath}/img/index1.png" width="30%" height="40%"/></a></td>
							<td align="center"><a href="${pageContext.request.contextPath}/GetUser" style="text-decoration:none;"><img src="${pageContext.request.contextPath}/img/index1.png" width="30%" height="40%"/></a></td>
						</tr>
						<tr>
							<td align="center"><a href="${pageContext.request.contextPath}/GetUser" style="text-decoration:none;"><img src="${pageContext.request.contextPath}/img/index1.png" width="30%" height="40%"/></a></td>
							<td align="center"><a href="${pageContext.request.contextPath}/GetUser" style="text-decoration:none;"><img src="${pageContext.request.contextPath}/img/index1.png" width="30%" height="40%"/></a></td>
						</tr>
					</table>
				</td>
			</tr>	

			<tr>
				<td>
					<table>
						<tr>
							<td rowspan="6" ><img src="${pageContext.request.contextPath}/img/map.jpg" width="500px" height="250px"/></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td style="left:40px;">安阳卫龙食品有限公司</td>
						</tr>
						<tr>
							<td></td>
							<td ><strong>地址：</strong>安阳市普陀区谈家渡路28号盛泉大厦南区7Ｃ</td>
						</tr>
						<tr>
							<td></td>
							<td ><strong>电话：</strong>15716300548</td>
						</tr>
						<tr>
							<td></td>
							<td><strong>传真：</strong>+86-21-32552575</td>
						</tr>
						<tr>
							<td></td>
							<td><strong>邮箱：</strong>1556674733@qq.com</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
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