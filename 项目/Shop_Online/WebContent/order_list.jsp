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
</style>
</head>
<script type="text/javascript">
function delProOrder(oid){
	if(confirm("你确定删除该项?")){
		location.href="${pageContext.request.contextPath }/productServlet?method=delProOrder&oid="+oid;
	}
}
function payProOrder(oid){
	if(confirm("你确定结算?")){
		location.href="${pageContext.request.contextPath }/productServlet?method=payProOrder&oid="+oid;
	}
}
</script>
<body>
	<!-- 引入header.jsp -->
	<jsp:include page="/header.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<div style="margin: 0 auto; margin-top: 10px; width: 950px;">
				<strong>我的订单</strong>
				<table class="table table-bordered">
					<c:forEach items="${pageBean.list }" var="order">
						<tbody id="${order.oid}">
							<tr class="success">
								<th colspan="2">订单编号:${order.oid }</th>
								<th>总计:￥${order.total}</th>
								<th class="text-center"><a href="javascript:;" onclick="delProOrder('${order.oid}')" class="delete">删除</a></th>
								<c:if test="${order.state==0 }">
									<th class="text-center"><a href="javascript:;" onclick="payProOrder('${order.oid}')" class="delete">结算</a></th>	
								</c:if>
								<c:if test="${order.state!=0 }">
									<th class="text-center"><a href="javascript:;" class="delete"></a></th>	
								</c:if>
							</tr>
							<tr class="warning">
								<th>图片</th>
								<th>商品</th>
								<th>价格</th>
								<th>数量</th>
								<th>小计</th>
							</tr>
							<c:forEach items="${order.orderItems }" var="item">
								<tr class="active text-center">
									<td width="60" width="35%">
										<input type="hidden" name="id" value="22"/> 
										<img src="${pageContext.request.contextPath }/${item.product.pimage}" width="70" height="60">
									</td>
									<td width="30%"><a href="${pageContext.request.contextPath }/productServlet?method=productInfo&pid=${item.product.pid }">${item.product.pname }</a></td>
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
		</div>
		
		<div class="row text-center" style="width: 380px; margin: 0 auto; margin-top: 50px;">
			<ul class="pagination" style="text-align: center; margin-top: 10px;">
				<c:if test="${pageBean.currentPage <= 1 }">
					<li class="disable">
						<a href="javascript:void(0);" aria-label="Previous">
							<span aria-hidden="true">&laquo;</span>
						</a>
					</li>
				</c:if>
				<c:if test="${pageBean.currentPage > 1 }">
					<li>
						<a href="${pageContext.request.contextPath}/productServlet?method=myOrders&currentPage=${pageBean.currentPage-1 }" aria-label="Previous">
							<span aria-hidden="true">&laquo;</span>
						</a>
					</li>
				</c:if>
				<c:forEach begin="1" end="${pageBean.totalPage }" var="page">
					<c:if test="${page == pageBean.currentPage }">
						<li class="active"><a href="javascript:void(0);">${page }</a></li>
					</c:if>
					<c:if test="${page != pageBean.currentPage }">
						<li><a href="${pageContext.request.contextPath}/productServlet?method=myOrders&currentPage=${page }">${page }</a></li>
					</c:if>
				</c:forEach>
				<c:if test="${pageBean.currentPage < pageBean.totalPage }">
					<li>
						<a href="${pageContext.request.contextPath}/productServlet?method=myOrders&currentPage=${pageBean.currentPage+1 }" aria-label="Next"> 
							<span aria-hidden="true">&raquo;</span>
						</a>
					</li>
				</c:if>
				<c:if test="${pageBean.currentPage >= pageBean.totalPage }">
					<li class="disable">
						<a href="javascript:void(0);" aria-label="Next"> 
							<span aria-hidden="true">&raquo;</span>
						</a>
					</li>
				</c:if>
			</ul>
		</div>
	</div>

	<!-- 引入footer.jsp -->
	<jsp:include page="/footer.jsp"></jsp:include>
	
</body>

</html>