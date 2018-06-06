<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎登录后台管理系统</title>
<link href="${pageContext.request.contextPath }/admin/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${pageContext.request.contextPath }/admin/js/jquery.js"></script>
<script src="${pageContext.request.contextPath }/admin/js/cloud.js" type="text/javascript"></script>

<script language="javascript">
	$(function() {
		$('.loginbox').css({
			'position' : 'absolute',
			'left' : ($(window).width() - 692) / 2
		});
		$(window).resize(function() {
			$('.loginbox').css({
				'position' : 'absolute',
				'left' : ($(window).width() - 692) / 2
			});
		})
	});
	function validate() {
		var validator = new Validator('theForm');
		validator.required('username', user_name_empty);
		//validator.required('password', password_empty);
		if (document.forms['theForm'].elements['captcha']) {
			validator.required('captcha', captcha_empty);
		}
		return validator.passed();
	}
</script>

</head>

<body
	style="background-color: #1c77ac; background-image: url(images/light.png); background-repeat: no-repeat; background-position: center top; overflow: hidden;">

	<div id="mainBody">
		<div id="cloud1" class="cloud"></div>
		<div id="cloud2" class="cloud"></div>
	</div>

	<div class="logintop">
		<span>欢迎登录后台管理界面平台</span>
		<ul>
			<li><a href="${pageContext.request.contextPath }/Default.jsp">回首页</a>
			</li>
			<li><a href="javascipt:;">帮助</a></li>
			<li><a href="javascipt:;">关于</a></li>
		</ul>
	</div>

	<div class="loginbody">

		<span class="systemlogo"></span>

		<div class="loginbox">
			<form method="post"
				action="${pageContext.request.contextPath }/admins?method=login"
				target="_parent" name='theForm' onsubmit="return validate()">
				<ul>
					<li><input name="username" type="text" class="loginuser" placeholder="用户名"/></li>
					<li><input name="password" type="text" class="loginpwd" placeholder="密码"/></li>
					<li><input name="" type="submit" class="loginbtn" value="登录" /> <label>${result }
					</label></li>
				</ul>
			</form>
		</div>
	</div>
	<div class="loginbm">Copyright &copy; 2018.Company name All
		rights reserved.</div>
</body>
</html>