<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head></head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>会员注册</title>
<link rel="shortcut icon" href="img/favicon.ico" />
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/messages_zh.js"></script>
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

font {
	color: #3164af;
	font-size: 18px;
	font-weight: normal;
	padding: 0 10px;
}

label.error {
	color: red;
	font-size: xx-small;
	
}
</style>
<script type="text/javascript">
	$(function() {
		$("#registForm").validate({
			rules:{
				username:{
					required:true,
					minlength:5
				},
				password:{
					required:true,
					digits:true,
					rangelength:[6,12]
				},
				repassword:{
					required:true,
					equalTo:"[name='password']"
				},
				email:{
					required:true,
					email:true
				},
				name:{
					required:true,
					maxlength:5
				}
			},
			messages:{
				username:{
					required:"用户名不能为空!",
					minlength:"用户名不得少于5位!"
				},
				password:{
					required:"密码不能为空!",
					digits:"密码必须是整数!",
					rangelength:"密码必须6~12位!"
				},
				repassword:{
					required:"确认密码不能为空!",
					equalTo:"两次输入密码不一致!"
				},
				email:{
					required:"邮箱不能为空!",
					email:"邮箱格式不正确!"
				},
				name:{
					required:"姓名不能为空!",
					maxlength:"姓名不得多于5位!"
				}
			},
			errorElement: "label", //用来创建错误提示信息标签,validate插件默认的就是label
			success: function(label) { //验证成功后的执行的回调函数
				//label指向上面那个错误提示信息标签label
				label.remove(); //清空错误提示消息
			}
		});
		$("lable").addClass("form-inline");

	});
</script>
</head>
<body>

	<!-- 引入header.jsp -->
	<jsp:include page="/header.jsp"></jsp:include>

	<div class="container"
		style="width: 85%; background: url('image/regist_bg.jpg');">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8"
				style="background: #fff; padding: 40px 80px; margin: 30px; border: 7px solid #ccc;">
				<font>会员注册</font>USER REGISTER
				<form id="registForm"
					action="userServlet?method=register" method="post"
					class="form-horizontal" style="margin-top: 5px;">
					<div class="form-group">
						<label for="username" class="col-sm-2 control-label text-right" style="width:90px;">用户名</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label text-right" style="width:90px;">密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="inputPassword3" name="password" placeholder="请输入密码">
						</div>
					</div>
					<div class="form-group">
						<label for="confirmpwd" class="col-sm-2 control-label text-right" style="width:90px;">确认密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="confirmpwd" placeholder="请输入确认密码">
						</div>
					</div>
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label text-right" style="width:90px;">Email</label>
						<div class="col-sm-6">
							<input type="email" class="form-control" id="inputEmail3"
								name="email" placeholder="Email">
						</div>
					</div>
					<div class="form-group">
						<label for="usercaption" class="col-sm-2 control-label text-right" style="width:90px;">姓名</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="usercaption"
								name="name" placeholder="请输入姓名">
						</div>
					</div>
					<div class="form-group opt">
						<label for="inlineRadio1" class="col-sm-2 control-label text-right" style="width:90px;">性别</label>
						<div class="col-sm-6">
							<label class="radio-inline"> <input type="radio"
								name="sex" id="inlineRadio1" value="男"> 男
							</label> <label class="radio-inline"> <input type="radio"
								name="sex" id="inlineRadio2" value="女"> 女
							</label>
						</div>
					</div>
					<div class="form-group">
						<label for="date" class="col-sm-2 control-label text-right" style="width:90px;">出生日期</label>
						<div class="col-sm-6">
							<input type="date" name="birthday" class="form-control" >
						</div>
					</div>

					<div class="form-group">
						<label for="date" class="col-sm-2 control-label text-right" style="width:90px;">验证码</label>
						<div class="col-sm-3">
							<input type="text" name="checkCode" class="form-control">

						</div>
						<div class="col-sm-2">
							<img style="border:1px black solid" src="${pageContext.request.contextPath }/checkImg" onclick="this.src='${pageContext.request.contextPath }/checkImg?'+Math.random();"/>
						</div>

					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="submit" width="100" value="注册" name="submit" style="background: url('./images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0); height: 35px; width: 100px; color: white;">
						</div>
					</div>
				</form>
			</div>

			<div class="col-md-2"></div>

		</div>
	</div>

	<!-- 引入footer.jsp -->
	<jsp:include page="/footer.jsp"></jsp:include>

</body>
</html>




