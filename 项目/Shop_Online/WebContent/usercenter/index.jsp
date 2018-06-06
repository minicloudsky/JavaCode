<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>个人中心</title>
		<!-- Bootstrap Styles-->
		<link href="assets/css/bootstrap.css" rel="stylesheet" />
		<!-- FontAwesome Styles-->
		<link href="assets/css/font-awesome.css" rel="stylesheet" />
		<!-- Morris Chart Styles-->
		<link href="assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
		<!-- Custom Styles-->
		<link href="assets/css/custom-styles.css" rel="stylesheet" />
		<!-- Google Fonts-->
		<link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
	</head>

	<body>
		<div id="wrapper">
			<nav class="navbar navbar-default top-navbar" role="navigation">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
					<a class="navbar-brand" href="${pageContext.request.contextPath }/usercenter/index.jsp">个人中心</a>
				</div>

				<ul class="nav navbar-top-links navbar-right">
					<li class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
							<i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
						</a>
						<ul class="dropdown-menu dropdown-user">
							<li>
								<a href="${pageContext.request.contextPath }/usercenter/userInfo.jsp"><i class="fa fa-user fa-fw"></i> 用户信息</a>
							</li>

							<li class="divider"></li>
							<li>
								<a href="${pageContext.request.contextPath }/userServlet?method=loginOut"><i class="fa fa-sign-out fa-fw"></i> 注销</a>
							</li>
						</ul>
						<!-- /.dropdown-user -->
					</li>
					<!-- /.dropdown -->
				</ul>
			</nav>
			<!--/. NAV TOP  -->
			<nav class="navbar-default navbar-side" role="navigation">
				<div class="sidebar-collapse">
					<ul class="nav" id="main-menu">

						<li>
							<a class="active-menu" href="${pageContext.request.contextPath }/Default.jsp"><i class="fa fa-dashboard"></i> 商城首页</a>
						</li>
						<li>
							<a href="${pageContext.request.contextPath }/usercenter/userInfo.jsp"><i class="fa fa-desktop"></i> 用户信息</a>
						</li>
						<li>
							<a href="${pageContext.request.contextPath }/usercenter/address.jsp"><i class="fa fa-bar-chart-o"></i> 收货地址</a>
						</li>
						<li>
							<a href="${pageContext.request.contextPath}/productServlet?method=myOrders&page=2"><i class="fa fa-table"></i> 我的订单</a>
						</li>
						<li>
							<a href="${pageContext.request.contextPath}/userServlet?method=myComments"><i class="fa fa-edit"></i> 我的评论 </a>
						</li>
					</ul>
				</div>
			</nav>
			<!-- 右测  -->
			<div id="page-wrapper">
				<div id="page-inner">
					<div class="row">
						<div class="col-md-12">
							<h1 class="page-header">
                            欢迎  <small>${user.username } 进入个人中心</small>
                        </h1>
						</div>
					</div>
					<!-- 右上 -->
					<div class="row">
						<div class="col-md-3 col-sm-12 col-xs-12">
							<a href="${pageContext.request.contextPath}/productServlet?method=myOrders&page=2" style="text-decoration:none">
								<div class="panel panel-primary text-center no-boder bg-color-green">
									<div class="panel-body">
										<i class="fa fa-bar-chart-o fa-5x"></i>
									</div>
									<div class="panel-footer back-footer-green">
										我的订单
	
									</div>
								</div>
							</a>
						</div>
						<div class="col-md-3 col-sm-12 col-xs-12">
							<a href="${pageContext.request.contextPath }/usercenter/address.jsp" style="text-decoration:none">
								<div class="panel panel-primary text-center no-boder bg-color-blue">
									<div class="panel-body">
										<i class="fa fa-shopping-cart fa-5x"></i>
									</div>
									<div class="panel-footer back-footer-blue">
										收货地址
	
									</div>
								</div>
							</a>
						</div>
						<div class="col-md-3 col-sm-12 col-xs-12">
							<a href="${pageContext.request.contextPath}/userServlet?method=myComments" style="text-decoration:none">
								<div class="panel panel-primary text-center no-boder bg-color-red">
									<div class="panel-body">
										<i class="fa fa fa-comments fa-5x"></i>
									</div>
									<div class="panel-footer back-footer-red">
										我的评论
	
									</div>
								</div>
							</a>
						</div>
						<div class="col-md-3 col-sm-12 col-xs-12">
							<a href="${pageContext.request.contextPath }/usercenter/userInfo.jsp" style="text-decoration:none">
								<div class="panel panel-primary text-center no-boder bg-color-brown">
									<div class="panel-body">
										<i class="fa fa-users fa-5x"></i>
									</div>
									<div class="panel-footer back-footer-brown">
										用户信息
	
									</div>
								</div>
							</a>
						</div>
					</div>
					<footer class="text-center">
						<p>Copyright &copy; 2018.Company name All rights reserved.</p>
					</footer>
				</div>
			</div>
		</div>
		<!-- JS Scripts-->
		<!-- jQuery Js -->
		<script src="${pageContext.request.contextPath }/usercenter/assets/js/jquery-1.10.2.js"></script>
		<!-- Bootstrap Js -->
		<script src="${pageContext.request.contextPath }/usercenter/assets/js/bootstrap.min.js"></script>
		<!-- Metis Menu Js -->
		<script src="${pageContext.request.contextPath }/usercenter/assets/js/jquery.metisMenu.js"></script>
		<!-- Morris Chart Js -->
		<script src="${pageContext.request.contextPath }/usercenter/assets/js/morris/raphael-2.1.0.min.js"></script>
		<script src="${pageContext.request.contextPath }/usercenter/assets/js/morris/morris.js"></script>
		<!-- Custom Js -->
		<script src="${pageContext.request.contextPath }/usercenter/assets/js/custom-scripts.js"></script>
	</body>
</html>