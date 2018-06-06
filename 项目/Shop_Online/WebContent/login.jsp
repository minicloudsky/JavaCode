<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>会员登录</title>
<link rel="shortcut icon" href="img/favicon.ico" />
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="css/style.css" type="text/css" />

<style>
body {
	margin-top: 20px;
	margin: 0 auto;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}

.container .row div {
	/* position:relative;
				 float:left; */
	
}

font {
	color: #666;
	font-size: 22px;
	font-weight: normal;
	padding-right: 17px;
}
</style>
<script type="text/javascript">
	$(function(){
		if(${empty user } == false) window.location.href="${pageContext.request.contextPath }/productServlet?method=index";
	});
	function closeTip(){
		$("#errorTip").text("");
	}
</script>
</head>
<body>

	<!-- 引入header.jsp -->
	<div class="container text-center">
		<div class="row">
			<jsp:include page="/header.jsp"></jsp:include>
		</div>
		<div class="row" style="margin-bottom:15px;background: #FF2C4C url('images/loginbg.jpg') no-repeat;">
			<div class="col-md-6">
				<!--<img src="./image/login.jpg" width="500" height="330" alt="会员登录" title="会员登录">-->
			</div>
			<div class="col-md-4 text-left" style="margin-left:15px;height: 460px;">
				<div style="width: 400px; height:325px; border: 1px solid #E7E7E7; padding: 20px 0px 20px 40px; border-radius: 5px; margin-top: 60px; background: #fff;">
					<font>会员登录</font>USER LOGIN
					<div>
						<c:if test="${!empty loginError }">
							<span id="errorTip" style="color:red">${loginError }</span>
						</c:if>&nbsp;
					</div>
					<form class="form-horizontal" method="post" action="${pageContext.request.contextPath }/userServlet?method=login">
						<div class="form-group">
							<label for="username" class="col-sm-2 control-label" style="width:75px">用户名</label>
							<div class="col-sm-6">
								<input type="text" onmousedown="closeTip()" class="form-control" id="username" name="username" placeholder="请输入用户名" style="width:185px">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label" style="width:75px">密码</label>
							<div class="col-sm-6">
								<input type="password" onmousedown="closeTip()" class="form-control" id="password" name="password" placeholder="请输入密码" style="width:185px">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label" style="width:75px">验证码</label>
							<div class="col-sm-3">
								<input type="text" onmousedown="closeTip()" class="form-control" id="checkCode" name="checkCode" placeholder="请输入验证码" style="width:110px">
							</div>
							<div class="col-sm-3" style="margin-left:25px">
								<img style="border:1px black solid" src="${pageContext.request.contextPath }/checkImg" onclick="this.src='${pageContext.request.contextPath }/checkImg?'+Math.random();"/>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<div class="checkbox">
									<label> <input type="checkbox" name="autoLogin"> 自动登录
									</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <label> <input
										type="checkbox"> 记住用户名
									</label>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<input type="submit" width="100" value="登录" name="submit"
									style="background: url('./images/login.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0); height: 35px; width: 100px; color: white;">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="row">
			<jsp:include page="/footer.jsp"></jsp:include>
		</div>
	</div>

	<!-- 引入footer.jsp -->
	

</body>
</html>