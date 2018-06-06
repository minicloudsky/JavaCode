<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath }/admin/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${pageContext.request.contextPath }/admin/js/jquery.js"></script>

<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	$("#welcome").click(function(){
		$(".menuson li.active").removeClass("active")
	});
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>
</head>

<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span><a id="welcome" href="${pageContext.request.contextPath }/admin/welcome.jsp" target="rightFrame" style="font-size: large;color: white;">首页</a></div>
    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    <span><img src="${pageContext.request.contextPath }/admin/images/leftico01.png" /></span>管理信息
    </div>
    	<ul class="menuson">
        <li><cite></cite><a href="${pageContext.request.contextPath }/admin/catagory.jsp" target="rightFrame">分类管理</a><i></i></li>
        <li><cite></cite><a href="${pageContext.request.contextPath }/admin/product_list.jsp" target="rightFrame">商品管理</a><i></i></li>
        <li><cite></cite><a href="${pageContext.request.contextPath}/admins?method=myOrders&page=3" target="rightFrame">订单管理</a><i></i></li>
        <li><cite></cite><a href="${pageContext.request.contextPath }/admin/add_product.jsp" target="rightFrame">添加商品</a><i></i></li>
        </ul>    
    </dd>
    <dd>
    <div class="title">
    <span><img src="${pageContext.request.contextPath }/admin/images/leftico02.png" /></span>用户管理
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="${pageContext.request.contextPath }/admin/userInfo.jsp" target="rightFrame">用户信息</a><i></i></li>
        <li><cite></cite><a href="${pageContext.request.contextPath }/admin/userAdd.jsp" target="rightFrame">用户添加</a><i></i></li>
    </dd> 
    <dd><div class="title"><span><img src="${pageContext.request.contextPath }/admin/images/leftico03.png" /></span>评论管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="${pageContext.request.contextPath }/admin/comments.jsp" target="rightFrame">评论列表</a><i></i></li>
    </ul>    
    </dd>  
    </dl>
</body>
</html>
