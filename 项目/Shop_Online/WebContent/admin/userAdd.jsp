<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>无标题文档</title>
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/jquery.form.js"></script>
		<script>
			$(function(){
				$("#submit").click(function(){
					var data = $("#form").serialize();
					alert(data);
					$.post(
						"${pageContext.request.contextPath}/admins?method=addUserInfo",
						$("#form").serialize(),
						function(data) {
							if (data == "success")
								alert("添加成功");
						}, "json");
				});
			});
		</script>
	</head>

	<body>

		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li>
					<a href="#">首页</a>
				</li>
				<li>
					<a href="#">用户添加</a>
				</li>
			</ul>
		</div>

		<div class="formbody">

			<div class="formtitle"><span>基本信息</span></div>
			<form method="post" id="form">
			<ul class="forminfo">
				<li>
					<label>用户名</label>
					<input name="username" type="text" class="dfinput" /><i>标题不能少于3个字符</i>
				</li>
				<li>
					<label>密码</label>
					<input name="password" type="text" class="dfinput" /><i>不能少于4位</i>
				</li>
				<li>
					<label>性别</label>
					<cite>
						<input name="sex" type="radio" value="1" checked="checked" />男&nbsp;&nbsp;&nbsp;&nbsp;
						<input name="sex" type="radio" value="0" />女
					</cite>
				</li>
				<li>
					<label>姓名</label>
					<input name="name" type="text" class="dfinput" value="" /><i>例：李四</i>
				</li>
				<li>
					<label>电话</label>
					<input name="telephone" type="text" class="dfinput" value="" /><i>例：1783919xxxx</i>
				</li>
				<li>
					<label>邮箱</label>
					<input type="text" name="email" id="email" class="dfinput" value="" /><i>例：zhangsan@163.com</i>
				</li>
				<li>
					<label>&nbsp;</label>
					<input id="submit" type="button" class="btn" value="确认保存" />
				</li>
			</ul>
			</form>
		</div>
	</body>
</html>