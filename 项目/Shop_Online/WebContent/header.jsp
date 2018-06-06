<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 登录 注册 购物车... -->
<div class="container">
	<div class="row">
		<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 hidden-xs">
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 hidden-xs text-left">
				<img src="img/logo2.png" style="height:55px;width:300px"/>
			</div>
			<div class="col-lg-6 col-md-6 col-sm-6 hidden-sm hidden-xs text-center">
				<img src="img/header.png" />
			</div>
		</div>
		<div class="col-lg-6 col-md-6 col-sm-6 col-xs-9 text-right">
			<div class="btn-group" style="margin-top: 15px;">
				<c:if test="${empty user }">
					<a href="${pageContext.request.contextPath }/userServlet?method=login" class="btn btn-default" role="button">登录</a> 
					<a href="register.jsp" class="btn btn-default" role="button">注册</a> 
				</c:if>
				<c:if test="${!empty user }">
					<ul class="btn btn-default" style="list-style-type:none;">
						<li class="dropdown">
							<a style="color:red;text-decoration:none" class="dropdown-toggle" data-toggle="dropdown">欢迎您，${user.username } <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li>
									<a href="${pageContext.request.contextPath }/usercenter/index.jsp" class="btn">个人中心</a>
								</li>
								<li>
									<a class="btn" href="${pageContext.request.contextPath }/userServlet?method=loginOut">注销</a>
								</li>
							</ul>
						</li>
					</ul>
					   
				</c:if>
				<a href="cart.jsp" class="btn btn-default" role="button">购物车</a> 
				<a href="${pageContext.request.contextPath }/productServlet?method=myOrders&page=1" class="btn btn-default" role="button">我的订单</a>
			</div>
		</div>	
	</div>
</div>

<!-- 导航条 -->
<div class="container" style="margin-bottom: 2px;">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav" id="categoryUl">
					<li class="navbar-header">
						<a class="navbar-brand" href="productServlet?method=index">首页</a>
					</li>
				</ul>
			</div>
		</div>
		<script type="text/javascript">
			$(function(){
				var content = "";
				$.post(
					"${pageContext.request.contextPath}/productServlet?method=categoryList",
					function(data){
						for(var i=0; i<data.length; i++){
							content+="<li><a href='${pageContext.request.contextPath}/productServlet?method=productList&cid="+data[i].cid+"'>"+data[i].cname+"</a></li>";
						}
						$("#categoryUl").append(content);
					},
					"json"
				);
			});
		</script>
	</nav>
</div>