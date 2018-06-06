<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>无标题文档</title>
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" type="text/css" href="../css/bootstrap.css" />
		<script src="../js/jquery-1.11.3.min.js"></script>
		<script src="../js/bootstrap.min.js"></script>
	</head>

	<body style="background:url(images/topbg.gif) repeat-x;">

		<div class="topleft">
			<a href="main.html" target="_parent"><img src="images/logo.png" title="系统首页" /></a>
		</div>

		<ul class="nav" style="margin-top: 20px;">
			<li><img src="images/icon01.png" /></li>
			<li><img src="images/icon02.png" /></li>
			<li><img src="images/icon03.png" /></li>
			<li><img src="images/icon04.png" /></li>
			<li><img src="images/icon05.png" /></li>
			<li><img src="images/icon06.png" /></li>
		</ul>

		<div class="topright">

			<div class="user">
				<span>admin&nbsp;:</span>
				<i>${admin }</i>
			</div>
			<div>
				<ul>
					<li>
						<a href="${pageContext.request.contextPath }/admins?method=loginOut" target="_parent">退出</a>
					</li>
				</ul>
			</div>
		</div>
	</body>

</html>