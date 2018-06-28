<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'topic6.jsp' starting page</title>
    
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
			<tr>
				<td colspan="4">
				<h1><strong>招商须知</strong> </h1>
				<p>为更好的了解我公司招商的规定及细节，凡XXX全体人员都务必牢记此份（招商细则须知）:</p>
				<p>  一、 开发新客户需与客户双方交换资质证明，需真实、合法、有效。 1. 营业执照<副本>复印件； 2. 税务登记<副本>复印件； 3. 食品流通许可证复印件； 4.法人身份证复印件；  5.客户联系电话以及详细收货地址； </p>
				<p> 二、 公司坚持以“款到发货”为原则，统一货款汇至刘想珍董事长账户 （也可汇至对公帐号、支付宝）。 </p>
				<p> 三、 发货流程：提交新客户资料客户报单客户支付货款仓库备货（客户货款到账的2-7天内仓库安排发货，如遇特殊情况延长发货的需向客户解释）      排单员打印销售单据     会计签字审核     主管签字审核     仓库将货品出仓      送至物流站      跟单员通知客户已发货       业务员跟进。</p>
				<p>  四、 凡是首次合作的客户，拿货满50件（含50件）可赠送一件试尝品。</p>
				<p> 五、 客户下订单100件以下至货运站自提货品，满100件（含100件） 以上送至指定仓库。 </p> 
				<p>六、 凡是首次合作的客户，如有某单品不畅销可在保质期两个月内更换， 仅限一批。 </p> 
				<p>七、 凡是我公司产品在保质期内出现质量问题，如漏气、胀包、发霉 ,未标生产日期等，我公司无条件更换，并承担相应的物流费用，但人为损坏、鼠患、以及快过期、已过期的产品我公司一律不负责。</p> 
				<p>八、 更换产品必须经得业务主管及财务的批准后，再通知客户退回更换 产品，必须确保我公司仓管签收更换产品入仓后，方可通知排单员将更换产品发出。</p>  
				<p>九、 我公司出售后的产品，禁止退货。 </p> 
				<p>十、 更换的产品以及补质量问题的产品禁止抵扣货款。</p> 
				<p>十一、 公司不定期的会有产品促销活动，凡是参与活动的客户必须款到 发货。</p> 
				<p> 十二、 凡是超出正常搭赠的产品（如试尝品等）以及活动搭赠产品都有 公司统一安排。</p>
				<p> 十三、 网络招商、电话招商如遇特别有意向客户可向客户寄样品，样品 分为“定量装样品”和“散装产品样品”，由公司文员统一寄出，如有特殊要求，可向文员备注。（定量装样品单：一元产品各2袋、两元产品各1袋；散装产品各4袋、产品介绍单页1份、价格表1份、装订要求、寄样品业务的名片）</p>
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
