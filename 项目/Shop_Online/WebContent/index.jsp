<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>黑马商城首页</title>
		<link rel="shortcut icon" href="img/favicon.ico" />
		<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
		<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</head>

	<body>
		<div class="container-fluid">

			<!-- 引入header.jsp -->
			<jsp:include page="/header.jsp"></jsp:include>

			<!--轮播图-->
			<div class="container">
				<div id="carousel-example" class="carousel slide" data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#carousel-example" data-slide-to="0" class="active"></li>
						<li data-target="#carousel-example" data-slide-to="1"></li>
						<li data-target="#carousel-example" data-slide-to="2"></li>
					</ol>
					<div class="carousel-inner" role="list-box">
						<div class="item active">
							<img src="img/1.jpg" alt="..." />
						</div>
						<div class="item">
							<img src="img/2.jpg" alt="..." />
						</div>
						<div class="item">
							<img src="img/3.jpg" alt="..." />
						</div>
					</div>
					<a class="left carousel-control" href="#carousel-example" role="button" data-slide="prev">
						<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a>
					<a class="right carousel-control" href="#carousel-example" role="button" data-slide="next">
						<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
			</div>
			
			<!--热门商品-->
			<div class="container">
				 <!--上面文字-->
				<div class="row">
					<span id="" style="font-size: 30px;padding-left: 33px;">
						热门商品&nbsp;&nbsp;&nbsp;&nbsp;<img src="img/title2.jpg" alt="" />
					</span>
				</div>
				<!--图片内容-->
				<div class="row text-center">
					<!--左侧-->
					<div class="col-lg-2 col-md-2 col-sm-2 hidden-sm hidden-xs" style="height: 400px;">
						<img src="img/big01.jpg" height="98%"/>
					</div>
					<!--右侧-->
					<div class="col-lg-10 col-md-10 col-sm-10">
						<!--右上-->
						<div class="row">
							<div class="col-lg-6 col-md-6 hidden-sm hidden-xs" style="height: 200px;">
								<a href="#"><img src="img/middle01.jpg" style="width: 100%;height: 100%;"/></a>
							</div>
							<c:forEach items="${hotProductList }" var="hotPro" begin="0" end="2" step="1">
								<div class="col-lg-2 col-md-2 col-sm-4 col-xs-4" align="center" style="margin-top:15px">
									<a href="${pageContext.request.contextPath }/productServlet?method=productInfo&pid=${hotPro.pid}">
										<img src="${pageContext.request.contextPath }/${hotPro.pimage}" style="width:110px;height:110px;"/>
									</a>
									<p><a href="${pageContext.request.contextPath }/productServlet?method=productInfo&pid=${hotPro.pid}"><font color="gray">${hotPro.pname }</font></a></p>
									<p><font color="red">￥${hotPro.shop_price }</font></p>
								</div>
							</c:forEach>
						</div>
						<!--右下-->
						<div class="row" style="margin-top:10px">
							<c:forEach items="${hotProductList }" var="hotPro" begin="3" end="8" step="1">
								<div class="col-lg-2 col-md-2 col-sm-4 col-xs-4" align="center">
									<a href="${pageContext.request.contextPath }productServlet?method=productInfo&pid=${hotPro.pid}">
										<img src="${pageContext.request.contextPath }/${hotPro.pimage}" style="width:110px;height:110px;"/>
									</a>
									<p><a href="${pageContext.request.contextPath }/productServlet?method=productInfo&pid=${hotPro.pid}"><font color="gray">${hotPro.pname }</font></a></p>
									<p><font color="red">￥${hotPro.shop_price }</font></p>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
			
			<!--广告图片-->
			<div class="container" style="margin-bottom: 0px;">
				<div class="row">
					<div class="hidden-sm hidden-xs" style="padding-left: 14px;">
						<img src="img/ad.jpg" style="width: 98.8%; height: 100%;"/>
					</div>
				</div>
			</div>
			
			<!--最新商品-->
			<div class="container">
				<!--上面的文字内容-->
				<div class="row">
					<span style="font-size: 30px;padding-left: 33px;">
						最新商品&nbsp;&nbsp;&nbsp;&nbsp;<img src="img/title2.jpg"/>
					</span>
				</div>
				<!--图片内容-->
				<div class="row text-center">
					<!--左侧-->
					<div class="col-lg-2 col-md-2 hidden-sm hidden-xs" style="height: 400px;">
						<img src="img/big01.jpg" height="100%"/>
					</div>
					<!--右侧-->
					<div class="col-lg-10 col-md-10 col-sm-12 col-xs-12">
						<!--右上-->
						<div class="row">
							<div class="col-lg-6 col-md-6 hidden-sm hidden-xs">
								<img src="img/middle01.jpg" width="100%" height="200px"/>
							</div>
							<c:forEach items="${newProductList }" var="newPro" begin="0" end="2" step="1">
								<div class="col-lg-2 col-md-2 col-sm-4 col-xs-4" align="center" style="margin-top:15px">
									<a href="${pageContext.request.contextPath }/productServlet?method=productInfo&pid=${newPro.pid}">
										<img src="${pageContext.request.contextPath }/${newPro.pimage}" style="width:110px;height:110px;"/>
									</a>
									<p><a href="${pageContext.request.contextPath }/productServlet?method=productInfo&pid=${newPro.pid}"><font color="gray">${newPro.pname }</font></a></p>
									<p><font color="red">￥${newPro.shop_price }</font></p>
								</div>
							</c:forEach>
						</div>
						<!--右下-->
						<div class="row" style="margin-top:10px">
							<c:forEach items="${newProductList }" var="newPro" begin="3" end="8" step="1">
								<div class="col-lg-2 col-md-2 col-sm-4 col-xs-4" align="center">
									<a href="${pageContext.request.contextPath }/productServlet?method=productInfo&pid=${newPro.pid}">
										<img src="${pageContext.request.contextPath }/${newPro.pimage}" style="width:110px;height:110px;"/>
									</a>
									<p><a href="${pageContext.request.contextPath }/productServlet?method=productInfo&pid=${newPro.pid}"><font color="gray">${newPro.pname }</font></a></p>
									<p><font color="red">￥${newPro.shop_price }</font></p>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>			
			
			<!-- 引入footer.jsp -->
			<jsp:include page="/footer.jsp"></jsp:include>			
		</div>
	</body>

</html>