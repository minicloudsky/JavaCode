<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>网站后台管理</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/admin/js/jquery.js"></script>
<link rel="shortcut icon"
	href="${pageContext.request.contextPath }/img/favicon.ico" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/bootstrap.min.css"
	type="text/css" />
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"
	type="text/javascript"></script>

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

		show();
		$("#addCategory").click(
				function() {
					var categoryName = $("#categoryName").val();
					if (categoryName == "")
						return;
					$.post(
							"${pageContext.request.contextPath}/admins?method=addCategory&categoryName="
									+ categoryName, function(data) {
								if (data == "success")
									$("#add_result").text("添加成功").css("color",
											"red");
								show();
							}, "json");
				});
	});
	function del(cid) {
		if (confirm("你确定删除该项?")) {
			$.post(
					"${pageContext.request.contextPath}/admins?method=delCategory&cid="
							+ cid, function(data) {
						if (data == "success")
							show();
					}, "json");
		}
	}
	function show() {
		var content = "";
		$.post(
			"${pageContext.request.contextPath}/admins?method=findAllCategory",
			function(data) {
				for (var i = 0; i < data.length; i++) {
					content += "<tr id='"+data[i].cid+"'>"
							+ "<td>"
							+ (i + 1)
							+ "</td>"
							+ "<td><input id='"+data[i].cid+"' disabled='disabled' type='text' value='"+data[i].cname+"' ></td>"
							+ "<td>"
							+ "<a href='javascript:;' onclick='del(\""
							+ data[i].cid
							+ "\")' class='tablelink'> 删除</a>"
							+ "</td>" + "</tr>";
				}
				$("#category").empty().append(content);
			},
			"json"
		);
	}
</script>

</head>

<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">分类管理</a></li>
			<li><a href="#">基本内容</a></li>
		</ul>
	</div>

	<div class="rightinfo">

		<div class="tools">

			<ul class="seachform">
				<li><input id="addCategory" type="button" class="scbtn"
					value="添加" /></li>
				<li><input id="categoryName" type="text" class="scinput"
					placeholder="分类名称" /></li>
				<li><lable id="add_result text-center"></lable></li>
			</ul>
		</div>

		<table class="tablelist">
			<thead>
				<tr>
					<th>编号<i class="sort"><img
							src="${pageContext.request.contextPath}/admins/images/px.gif" /></i></th>
					<th>分类名称</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody id="category">
			</tbody>
		</table>
	</div>
	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>