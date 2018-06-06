<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加商品</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/jquery.form.js"></script>
<link rel="shortcut icon" href="${pageContext.request.contextPath }/img/favicon.ico" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css" type="text/css" />
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function(){
		$.post("${pageContext.request.contextPath}/admins?method=findAllCategory",
			function(data){
				var option = $("#catagoryid");
				for(var i=0; i<data.length; i++){
					option.append("<option value='"+data[i].cid+"'>"+data[i].cname+"</option>");
				}
			},"json"
		);
		$("#submit").click(function(){
			 $("#form").ajaxSubmit({  
		            url : "${pageContext.request.contextPath}/adminAddProduct",  
		            type : "post",  
		            dataType : 'json',  
		            success : function(result) {  
		            	if(result == "success")
				    		alert("添加成功");
		            },  
		            error : function(data) {  
		                alert("error:" + data.responseText);  
		            }  
		        });
		});
	});
</script>
</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">商品添加</a></li>
		</ul>
	</div>
	<div class="formbody">

		<div class="formtitle" id="formtitle">
			<span>基本信息</span>
		</div>
		<form  id="form" method="post" enctype="multipart/form-data">
			<ul class="forminfo">
				<li><label>商品名</label> <input name="pname" type="text"
					class="dfinput" /></li>
				<li><label>商场价格</label> <input name="market_price" type="text"
					class="dfinput" /></li>
				<li><label>市场价格</label> <input name="shop_price" type="text"
					class="dfinput" /></li>
				<li><label>是否热门</label> <cite> <input name="is_hot"
						type="radio" value="1" checked="checked" />是&nbsp;&nbsp;&nbsp;&nbsp;
						<input name="is_hot" type="radio" value="0" />否
				<li><label>商品分类</label> <cite> <select name="cid" id="catagoryid"
						style="border: 1px solid;">
					</select>
				</cite></li>
				<li><label>商品图片</label> <cite> <input type="file"
						name="pimage" />
				</cite></li>
				<li><label>商品描述</label> <textarea name="pdesc" class="textinput"></textarea>
				</li>
				<li>
					<label>&nbsp;</label>
					<input id="submit" type="button" class="btn btn-default" value="确认保存">
				</li>
			</ul>
		</form>
	</div>
</body>
</html>