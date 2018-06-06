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
							<a href="${pageContext.request.contextPath }/Default.jsp"><i class="fa fa-dashboard"></i> 商城首页</a>
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
							<a class="active-menu" href="javascript:;"><i class="fa fa-edit"></i> 我的评论 </a>
						</li>
					</ul>
				</div>
			</nav>
			<div id="page-wrapper">
				<div id="page-inner">
					<div class="row">
						<div class="col-md-12">
							<h1 class="page-header">
                            我的 <small>商品评论</small>
                        </h1>
						</div>
					</div>
					<!-- /. ROW  -->
					<div class="row">
						<div class="col-md-12">
							<div class="panel panel-default">
								<div class="panel-heading">
									评论记录
								</div>
								<div class="panel-body">
									<div class="panel-group" id="accordion">
										<c:forEach items="${comments }" var="comment" varStatus="i">
											<div class="panel panel-default">
												<div class="panel-heading">
													<h5 class="panel-title">
	                                           			 <span>编号&nbsp;:&nbsp;${i.count }</span>&nbsp;&nbsp;&nbsp;&nbsp;<a data-toggle="collapse" data-parent="#accordion" href="#collapse${i.count }" class="collapsed">${comment.pname }</a>&nbsp;&nbsp;&nbsp;&nbsp;<span>日期&nbsp;:&nbsp;${comment.datetime }</span> 
	                                       			</h5>
												</div>
												<div id="collapse${i.count }" class="panel-collapse collapse" style="height: 0px;">
													<div class="panel-body">
														<p>评论:${comment.contents }</p>
														<p>回复:${comment.reply }</p>
													</div>
												</div>
											</div>
										</c:forEach>
									</div>
								</div>
							</div>
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
		</div>
		<!-- /. WRAPPER  -->
		<!-- JS Scripts-->
		<!-- jQuery Js -->
		<script src="${pageContext.request.contextPath }/usercenter/assets/js/jquery-1.10.2.js"></script>
		<!-- Bootstrap Js -->
		<script src="${pageContext.request.contextPath }/usercenter/assets/js/bootstrap.min.js"></script>
		<!-- Metis Menu Js -->
		<script src="${pageContext.request.contextPath }/usercenter/assets/js/jquery.metisMenu.js"></script>
		<!-- Custom Js -->
		<script src="${pageContext.request.contextPath }/usercenter/assets/js/custom-scripts.js"></script>
	</body>
</html>