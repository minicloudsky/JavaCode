<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
<link rel="shortcut icon"
	href="${pageContext.request.contextPath }/img/favicon.ico" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/bootstrap.min.css"
	type="text/css" />
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"
	type="text/javascript"></script>
<script language="javascript">
	$(function() {
		//导航切换
		$(".imglist li").click(function() {
			$(".imglist li.selected").removeClass("selected")
			$(this).addClass("selected");
		})
	})
</script>
<script type="text/javascript">
	$(function() {
		$(".click").click(function() {
			$(".tip").fadeIn(200);
		});

		$(".tiptop a").click(function() {
			$(".tip").fadeOut(200);
		});

		$(".sure").click(function() {
			$(".tip").fadeOut(100);
		});

		$(".cancel").click(function() {
			$(".tip").fadeOut(100);
		});
		show(1);
	});
	function show(page) {
		var content = "";
		$
				.post(
						"${pageContext.request.contextPath}/admins?method=findAllUsers",
						function(data) {
							for (var i = 0; i < data.length; i++) {
								content += "<tr>"
										+ "<td width='10%'><p>"+(i+1)+"</p></td>"
										+ "<td width='10%'><p>"+data[i].username+"</p></td>"
										+ "<td width='10%'><p>"
										+ data[i].password
										+ "</p></td>"
										+ "<td width='20%'><p>"
										+ data[i].name
										+ "</p></td>"
										+ "<td width='10%'>"
										+ data[i].telephone
										+ "</td>"
										+ "<td width='10%'>"
										+ data[i].email
										+ "</td>"
										+ "<td width='10%'><a href='javascript:;' onclick='show_modal(\""
										+ data[i].uid + "\",\"" + data[i].username +"\",\"" + data[i].password + "\",\"" + data[i].name + "\",\"" + data[i].telephone+"\",\"" + data[i].email
										+ "\",\""
										+ page
										+ "\")' class='tablelink'>修改</a> <a href='javascript:;' class='tablelink' onclick='del(\""
										+ data[i].uid
										+ "\")'> 删除</a></td>" + "</tr>"
							}
							$("#productList").empty().append(content);
						}, "json");
	}
	var id = "";
	function show_modal(uid,username,password,name,telephone,email,page){
		$('#myModal').modal('show');
		id=uid;
		$('#username').val(username);
		$('#password').val(password);
		$('#name').val(name);
		$('#telephone').val(telephone);
		$('#email').val(email);
	}
	function update() {
		var data=$("#updateProduct").serialize();
		var path = "${pageContext.request.contextPath }/admins?method=updateUser&uid="+id;
		$.post(
			path,
			data,
			function(data) {
				show(1);
			}, 
			"json");
		$('#myModal').modal('hide');
	}
	function del(uid) {
		if (confirm("你确定删除该项?")){
			$.post(
				"${pageContext.request.contextPath}/admins?method=delUser&uid="+uid, 
				function(data) {
					if(data != "") alert(data);
					show(1);
				}, "json"
			);
		}
	}
</script>
</head>

<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">用户列表</a></li>
		</ul>
	</div>

	<div>
		<!--   Kitchen Sink -->
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table-responsive table-bordered text-center">
						<thead>
							<tr>
								<th>编号</th>
								<th>用户名</th>
								<th>密码</th>
								<th>姓名</th>
								<th>电话</th>
								<th>邮箱</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody id="productList" align='center'>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<!-- End  Kitchen Sink -->
		<!-- 模态框（Modal） -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">修改信息</h4>
					</div>
					<form role="form" id="updateProduct" method="post">
						<div class="modal-body">
							<div class="form-group">
				                  <label class="sr-only" for="contact-message">Message</label>
				                  <input id="username" name="username" placeholder="用户名" class="contact-message form-control" id="contact-message"/>
				            </div>
				            <div class="form-group">
				                  <label class="sr-only" for="contact-message">Message</label>
				                  <input id="password" name="password" placeholder="密码" class="contact-message form-control" id="contact-message"/>
				            </div>
				            <div class="form-group">
				                  <label class="sr-only" for="contact-message">Message</label>
				                  <input id="name" name="name" placeholder="姓名" class="contact-message form-control" id="contact-message"/>
				            </div>
				            <div class="form-group">
				                  <label class="sr-only" for="contact-message">Message</label>
				                  <input id="telephone" name="telephone" placeholder="电话" class="contact-message form-control" id="contact-message"/>
				            </div>
				            <div class="form-group">
				                  <label class="sr-only" for="contact-message">Message</label>
				                  <input id="email" name="email" placeholder="邮箱" class="contact-message form-control" id="contact-message" />
				            </div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">关闭
							</button>
							<button type="button" id="updateBtn" onclick="update();" class="btn btn-primary">提交更改</button>
						</div>
					</form>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>
		<script type="text/javascript">
			$('.imgtable tbody tr:odd').addClass('odd');
		</script>
</body>
</html>
