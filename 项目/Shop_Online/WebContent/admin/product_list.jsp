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
						"${pageContext.request.contextPath}/admins?method=findAllProducts&page="
								+ page,
						function(data) {
							for (var i = 0; i < data.length; i++) {
								content += "<tr>"
										+ "<td width='10%'><img style='width:80px;height:80px;' src='../"+data[i].pimage+"' /></td>"
										+ "<td width='10%'><p>"
										+ data[i].pname
										+ "</p></td>"
										+ "<td width='20%'><p>"
										+ data[i].pdesc
										+ "</p></td>"
										+ "<td width='10%'>"
										+ data[i].market_price
										+ "</td>"
										+ "<td width='10%'>"
										+ data[i].shop_price
										+ "</td>"
										+ "<td width='10%'>"
										+ data[i].pdate
										+ "</td>"
										+ "<td width='10%'>"
										+ data[i].is_hot
										+ "</td>"
										+ "<td width='10%'><a href='javascript:;' onclick='show_modal(\""
										+ data[i].pid + "\",\"" + data[i].pname + "\",\"" + data[i].pdesc + "\",\"" + data[i].market_price+"\",\"" + data[i].shop_price+"\",\"" + data[i].is_hot
										+ "\",\""
										+ page
										+ "\")' class='tablelink'>修改</a> <a href='javascript:;' class='tablelink' onclick='del(\""
										+ data[i].pid
										+ "\")'> 删除</a></td>" + "</tr>"
							}
							$("#productList").empty().append(content);
						}, "json");
	}
	var id = "";
	function show_modal(pid,pname,pdesc,market,shop,hot,page){
		$('#myModal').modal('show');
		id=pid;
		$('#pname').val(pname);
		$('#pdesc').val(pdesc);
		$('#market_price').val(market);
		$('#shop_price').val(shop);
		$('#is_hot').val(hot);
	}
	function update() {
		var data=$("#updateProduct").serialize();
		var path = "${pageContext.request.contextPath }/admins?method=updateProduct&pid="+id;
		$.post(
			path,
			data,
			function(data) {
				show(1);
			}, 
			"json");
		$('#myModal').modal('hide');
	}
	function del(pid) {
		if (confirm("你确定删除该项?")){
			$.post(
				"${pageContext.request.contextPath}/admins?method=delProduct&pid="+pid, 
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
			<li><a href="#">商品列表</a></li>
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
								<th>缩略图</th>
								<th>商品名称</th>
								<th>商品描述</th>
								<th>市场价格</th>
								<th>商场价格</th>
								<th>上架日期</th>
								<th>是否热门</th>
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
		<div class="pagin">
			<ul class="paginList">
				<li class="paginItem"><a href="javascript:;"><span
						class="pagepre"></span></a></li>
				<li class="paginItem"><a href="javascript:;">1</a></li>
				<li class="paginItem current"><a href="javascript:;">2</a></li>
				<li class="paginItem"><a href="javascript:;">3</a></li>
				<li class="paginItem"><a href="javascript:;">4</a></li>
				<li class="paginItem"><a href="javascript:;">5</a></li>
				<li class="paginItem more"><a href="javascript:;">...</a></li>
				<li class="paginItem"><a href="javascript:;">10</a></li>
				<li class="paginItem"><a href="javascript:;"><span
						class="pagenxt"></span></a></li>
			</ul>
		</div>
		<!-- 模态框（Modal） -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">修改商品</h4>
					</div>
					<form role="form" id="updateProduct" method="post">
						<div class="modal-body">
							<div class="form-group">
				                  <label class="sr-only" for="contact-message">Message</label>
				                  <input id="pname" name="pname" placeholder="商品名" class="contact-message form-control" id="contact-message"/>
				            </div>
				            <div class="form-group">
				                  <label class="sr-only" for="contact-message">Message</label>
				                  <input id="market_price" name="market_price" placeholder="市场价格" class="contact-message form-control" id="contact-message"/>
				            </div>
				            <div class="form-group">
				                  <label class="sr-only" for="contact-message">Message</label>
				                  <input id="shop_price" name="shop_price" placeholder="商场价格" class="contact-message form-control" id="contact-message"/>
				            </div>
				            <div class="form-group">
				                  <label class="sr-only" for="contact-message">Message</label>
				                  <input id="is_hot" name="is_hot" placeholder="是否热门" class="contact-message form-control" id="contact-message"/>
				            </div>
				            <div class="form-group">
				                  <label class="sr-only" for="contact-message">Message</label>
				                  <textarea style="height:100px" id="pdesc" name="pdesc" placeholder="商品描述" class="contact-message form-control" id="contact-message"></textarea>
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
