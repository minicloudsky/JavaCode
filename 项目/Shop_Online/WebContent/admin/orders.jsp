<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>网站后台管理</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="shortcut icon"
	href="${pageContext.request.contextPath }/img/favicon.ico" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/bootstrap.min.css"
	type="text/css" />
<script
	src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
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

	});
</script>


</head>


<body>
	<div class="row">
					<div class="col-md-12">
						<h1 class="page-header">
							<small>所有订单</small>
						</h1>
					</div>
				</div>
	<div class="row">
		<div style="margin: 0 auto; margin-top: 10px; width: 950px;">
			<table class="table table-bordered">
				<c:forEach items="${pageBean.list }" var="order">
					<tbody id="${order.oid}">
						<tr class="success">
							<th colspan="3">订单编号:${order.oid }</th>
							<th>总计:￥${order.total}</th>
							<th class="text-center"><a href="javascript:;"
								onclick="delProOrder('${order.oid}')" class="delete">删除</a></th>
						</tr>
						<tr class="warning">
							<th>图片</th>
							<th>商品</th>
							<th>价格</th>
							<th>数量</th>
							<th>小计</th>
						</tr>
						<c:forEach items="${order.orderItems }" var="item">
							<tr class="text-center">
								<td width="60" width="35%"><input type="hidden" name="id"
									value="22" /> <img
									src="${pageContext.request.contextPath }/${item.product.pimage}"
									width="70" height="60"></td>
								<td width="30%"><a
									href="javascript:;">${item.product.pname }</a></td>
								<td width="20%">￥${item.product.shop_price }</td>
								<td width="15%">${item.count }</td>
								<td width="15%"><span class="subtotal">￥${item.subtotal }</span></td>
							</tr>
						</c:forEach>
					</tbody>
					<tbady></tbady>
				</c:forEach>
			</table>
		</div>
		<div class="row text-center"
			style="width: 380px; margin: 0 auto; margin-top: 50px;">
			<ul class="pagination">
				<c:if test="${pageBean.currentPage <= 1 }">
					<li class="disable"><a href="javascript:void(0);"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a></li>
				</c:if>
				<c:if test="${pageBean.currentPage > 1 }">
					<li><a
						href="${pageContext.request.contextPath}/admins?method=myOrders&page=3&currentPage=${pageBean.currentPage-1 }"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a></li>
				</c:if>

				<c:forEach begin="1" end="${pageBean.totalPage }" var="page">
					<c:if test="${page == pageBean.currentPage }">
						<li class="active"><a href="javascript:void(0);">${page }</a></li>
					</c:if>
					<c:if test="${page != pageBean.currentPage }">
						<li><a
							href="${pageContext.request.contextPath}/admins?method=myOrders&page=3&currentPage=${page }">${page }</a></li>
					</c:if>
				</c:forEach>

				<c:if test="${pageBean.currentPage < pageBean.totalPage }">
					<li><a
						href="${pageContext.request.contextPath}/admins?method=myOrders&page=3&currentPage=${pageBean.currentPage+1 }"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a></li>
				</c:if>
				<c:if test="${pageBean.currentPage >= pageBean.totalPage }">
					<li class="disable"><a href="javascript:void(0);"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a></li>
				</c:if>
			</ul>
		</div>
	</div>
	<!-- /. ROW  -->
	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>
