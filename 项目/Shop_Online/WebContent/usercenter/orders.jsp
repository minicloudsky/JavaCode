<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>订单</title>
<link rel="shortcut icon"
	href="${pageContext.request.contextPath }/img/favicon.ico" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/bootstrap.min.css"
	type="text/css" />
<script
	src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"
	type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/style.css"
	type="text/css" />

<!-- Bootstrap Styles-->
<link
	href="${pageContext.request.contextPath }/usercenter/assets/css/bootstrap.css"
	rel="stylesheet" />
<!-- FontAwesome Styles-->
<link
	href="${pageContext.request.contextPath }/usercenter/assets/css/font-awesome.css"
	rel="stylesheet" />
<!-- Morris Chart Styles-->

<!-- Custom Styles-->
<link
	href="${pageContext.request.contextPath }/usercenter/assets/css/custom-styles.css"
	rel="stylesheet" />
<!-- Google Fonts-->
<link href='https://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />
<!-- TABLE STYLES-->
<link
	href="${pageContext.request.contextPath }/usercenter/assets/js/dataTables/dataTables.bootstrap.css"
	rel="stylesheet" />
<script>
	function delProOrder(oid) {
		if (confirm("你确定删除该项?")) {
			location.href = "${pageContext.request.contextPath }/productServlet?method=delProOrder&page=2&oid="
					+ oid;
		}
	}
	function payProOrder(oid){
		if(confirm("你确定结算?")){
			location.href="${pageContext.request.contextPath }/productServlet?method=payProOrder&oid="+oid;
		}
	}
</script>


</head>

<body>
	<div id="wrapper">
		<nav class="navbar navbar-default top-navbar" role="navigation">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".sidebar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand"
					href="${pageContext.request.contextPath }/usercenter/index.jsp">个人中心</a>
			</div>

			<ul class="nav navbar-top-links navbar-right">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#" aria-expanded="false"> <i
						class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-user">
						<li><a
							href="${pageContext.request.contextPath }/usercenter/userInfo.jsp"><i
								class="fa fa-user fa-fw"></i> 用户信息</a></li>

						<li class="divider"></li>
						<li><a
							href="${pageContext.request.contextPath }/userServlet?method=loginOut"><i
								class="fa fa-sign-out fa-fw"></i> 注销</a></li>
					</ul> <!-- /.dropdown-user --></li>
				<!-- /.dropdown -->
			</ul>
		</nav>
		<!--/. NAV TOP  -->
		<nav class="navbar-default navbar-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav" id="main-menu">

					<li><a href="${pageContext.request.contextPath }/Default.jsp"><i
							class="fa fa-dashboard"></i>商城首页</a></li>
					<li><a
						href="${pageContext.request.contextPath }/usercenter/userInfo.jsp"><i
							class="fa fa-desktop"></i> 用户信息</a></li>
					<li><a
						href="${pageContext.request.contextPath }/usercenter/address.jsp"><i
							class="fa fa-bar-chart-o"></i> 收货地址</a></li>
					<li><a class="active-menu" href="javascript:;"><i
							class="fa fa-table"></i> 我的订单</a></li>
					<li><a
						href="${pageContext.request.contextPath}/userServlet?method=myComments"><i
							class="fa fa-edit"></i> 我的评论 </a></li>
				</ul>
			</div>
		</nav>
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<h1 class="page-header">
							订单页面 <small>我的订单</small>
						</h1>
					</div>
				</div>
				<!-- /. ROW  -->

				<div class="row">
					<div style="margin: 0 auto; margin-top: 10px; width: 950px;">
						<table class="table table-bordered">
							<c:forEach items="${pageBean.list }" var="order">
								<tbody id="${order.oid}">
									<tr class="success">
										<th colspan="2">订单编号:${order.oid }</th>
										<th>总计:￥${order.total}</th>
										<th class="text-center"><a href="javascript:;"
											onclick="delProOrder('${order.oid}')" class="delete">删除</a></th>
										<c:if test="${order.state==0 }">
											<th class="text-center"><a href="javascript:;"
												onclick="payProOrder('${order.oid}')" class="delete">结算</a></th>
										</c:if>
										<c:if test="${order.state!=0 }">
											<th class="text-center"><a href="javascript:;"
												class="delete"></a></th>
										</c:if>
									</tr>
									<tr class="warning">
										<th>图片</th>
										<th>商品</th>
										<th>价格</th>
										<th>数量</th>
										<th>小计</th>
									</tr>
									<c:forEach items="${order.orderItems }" var="item">
										<tr class="text-center">
											<td width="60" width="35%"><input type="hidden"
												name="id" value="22" /> <img
												src="${pageContext.request.contextPath }/${item.product.pimage}"
												width="70" height="60"></td>
											<td width="30%"><a
												href="${pageContext.request.contextPath }/productServlet?method=productInfo&pid=${item.product.pid }">${item.product.pname }</a></td>
											<td width="20%">￥${item.product.shop_price }</td>
											<td width="15%">${item.count }</td>
											<td width="15%"><span class="subtotal">￥${item.subtotal }</span></td>
										</tr>
									</c:forEach>
								</tbody>
								<tbady></tbady>
							</c:forEach>
						</table>
					</div>
					<div class="row text-center"
						style="width: 380px; margin: 0 auto; margin-top: 50px;">
						<ul class="pagination">
							<c:if test="${pageBean.currentPage <= 1 }">
								<li class="disable"><a href="javascript:void(0);"
									aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
								</a></li>
							</c:if>
							<c:if test="${pageBean.currentPage > 1 }">
								<li><a
									href="${pageContext.request.contextPath}/productServlet?method=myOrders&page=2&currentPage=${pageBean.currentPage-1 }"
									aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
								</a></li>
							</c:if>

							<c:forEach begin="1" end="${pageBean.totalPage }" var="page">
								<c:if test="${page == pageBean.currentPage }">
									<li class="active"><a href="javascript:void(0);">${page }</a></li>
								</c:if>
								<c:if test="${page != pageBean.currentPage }">
									<li><a
										href="${pageContext.request.contextPath}/productServlet?method=myOrders&page=2&currentPage=${page }">${page }</a></li>
								</c:if>
							</c:forEach>

							<c:if test="${pageBean.currentPage < pageBean.totalPage }">
								<li><a
									href="${pageContext.request.contextPath}/productServlet?method=myOrders&page=2&currentPage=${pageBean.currentPage+1 }"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span>
								</a></li>
							</c:if>
							<c:if test="${pageBean.currentPage >= pageBean.totalPage }">
								<li class="disable"><a href="javascript:void(0);"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span>
								</a></li>
							</c:if>
						</ul>
					</div>
				</div>
				<!-- /. ROW  -->
				<footer class="text-center">
					<p>Copyright &copy; 2018.Company name All rights reserved.</p>
				</footer>
			</div>
			<!-- /. PAGE INNER  -->
		</div>
		<!-- /. PAGE WRAPPER  -->
		<!-- /. WRAPPER  -->
		<!-- JS Scripts-->
		<!-- jQuery Js -->
		<script
			src="${pageContext.request.contextPath }/usercenter/assets/js/jquery-1.10.2.js"></script>
		<!-- Bootstrap Js -->
		<script
			src="${pageContext.request.contextPath }/usercenter/assets/js/bootstrap.min.js"></script>
		<!-- Metis Menu Js -->
		<script
			src="${pageContext.request.contextPath }/usercenter/assets/js/jquery.metisMenu.js"></script>
		<!-- DATA TABLE SCRIPTS -->
		<script
			src="${pageContext.request.contextPath }/usercenter/assets/js/dataTables/jquery.dataTables.js"></script>
		<script
			src="${pageContext.request.contextPath }/usercenter/assets/js/dataTables/dataTables.bootstrap.js"></script>
		<script>
			$(document).ready(function() {
				$('#dataTables-example').dataTable();
			});
		</script>
		<!-- Custom Js -->
		<script
			src="${pageContext.request.contextPath }/usercenter/assets/js/custom-scripts.js"></script>
</body>
</html>