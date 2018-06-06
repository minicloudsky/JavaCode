<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Dream</title>
<!-- Bootstrap Styles-->
<link href="${pageContext.request.contextPath }/usercenter/assets/css/bootstrap.css" rel="stylesheet" />
<!-- FontAwesome Styles-->
<link href="${pageContext.request.contextPath }/usercenter/assets/css/font-awesome.css" rel="stylesheet" />
<!-- Custom Styles-->
<link href="${pageContext.request.contextPath }/usercenter/assets/css/custom-styles.css" rel="stylesheet" />
<!-- Google Fonts-->
<link href='https://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />
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
							class="fa fa-dashboard"></i> 商城首页</a></li>
					<li><a
						href="${pageContext.request.contextPath }/usercenter/userInfo.jsp"><i
							class="fa fa-desktop"></i> 用户信息</a></li>
					<li><a class="active-menu" href="javascript:;"><i
							class="fa fa-bar-chart-o"></i> 收货地址</a></li>
					<li><a
						href="${pageContext.request.contextPath}/productServlet?method=myOrders&page=2"><i
							class="fa fa-table"></i> 我的订单</a></li>
					<li><a
						href="${pageContext.request.contextPath}/userServlet?method=myComments"><i
							class="fa fa-edit"></i> 我的评论 </a></li>
				</ul>
			</div>
		</nav>
		<!-- /. NAV SIDE  -->
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<h1 class="page-header">
							用户<small>收货地址 </small>
						</h1>
					</div>
				</div>
				<!-- /. ROW  -->
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">收货信息</div>
							<div class="panel-body">
								<div class="row">
									<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"></div>
									<!-- /.col-lg-6 (nested) -->
									<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
										<div class="row">
											<div class="row">
												<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
													<h4>基本信息</h4>
												</div>
												<c:if test="${address_result == 'success' }">
													<div
														class="col-lg-4 col-md-4 col-sm-4 col-xs-4 text-center">
														<span style="color: red">保存成功</span>
													</div>
												</c:if>
											</div>
											<form role="form" method="post" action="${pageContext.request.contextPath }/userServlet?method=updateUserInfo&page=2">
												<div class="form-group input-group">
													<span class="input-group-addon">收货人</span> <input type="text" class="form-control"
														name="receiver" value="${user.receiver }">
												</div>
												<div class="form-group input-group">
													<span class="input-group-addon">地址&nbsp;&nbsp;&nbsp;&nbsp;</span>
													<input type="text" class="form-control" name="address"
														value="${user.address }">
												</div>
												<div class="form-group input-group">
													<span class="input-group-addon">电话&nbsp;&nbsp;&nbsp;&nbsp;</span>
													<input type="text" class="form-control" name="telephone"
														value="${user.telephone }">
												</div>
												<div class="row">
													<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 text-right">
														<button type="submit" class="btn btn-default">提交</button>
													</div>
													<div>
														<button type="reset" class="btn btn-default">重置</button>
													</div>
												</div>

											</form>
										</div>
										<div class="row" style="height: 50px;"></div>
									</div>
									<!-- /.col-lg-6 (nested) -->
									<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"></div>
								</div>
								<!-- /.row (nested) -->
							</div>
							<!-- /.panel-body -->
						</div>
						<!-- /.panel -->
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<footer class="text-center">
					<p>Copyright &copy; 2016.Company name All rights reserved.</p>
				</footer>
			</div>
			<!-- /. PAGE INNER  -->
		</div>
		<!-- /. PAGE WRAPPER  -->
	</div>
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
	<!-- Custom Js -->
	<script
		src="${pageContext.request.contextPath }/usercenter/assets/js/custom-scripts.js"></script>
</body>
</html>