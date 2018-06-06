<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>无标题文档</title>
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<link href="css/select.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
		<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
		<script type="text/javascript" src="js/select-ui.min.js"></script>
		<link rel="shortcut icon" href="${pageContext.request.contextPath }/img/favicon.ico" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath }/js/bootstrap.min.js" type="text/javascript"></script>
		<script type="text/javascript">
			$(function() {
				show(1);
			});
			function show(page) {
				var content = "";
				$.post(
					"${pageContext.request.contextPath}/admins?method=findAllComments",
					function(data) {
						for (var i = 0; i < data.length; i++) {
							content += "<tr>"
									+ "<td width='10%'><p>"+(i+1)+"</p></td>"
									+ "<td width='10%'><p>"+data[i].username+"</p></td>"
									+ "<td width='10%'><p>"
									+ data[i].pname
									+ "</p></td>"
									+ "<td width='20%'><p>"
									+ data[i].datetime
									+ "</p></td>"
									+ "<td width='10%'>"
									+ data[i].contents
									+ "</td>"
									+ "<td width='10%'>"
									+ data[i].reply
									+ "</td>"
									+ "<td width='10%'><a href='javascript:;' onclick='show_modal(\""
									+ (i+1) + "\",\"" + data[i].id
									+ "\")' class='tablelink'>回复</a>"
									+ "</tr>";
						}
						$("#list").empty().append(content);
					}, "json");
			}
			var id="0";
			function show_modal(i,commentsid){
				$('#myModal').modal('show');
				id=commentsid;
				$('#number').html(i);
			}
			function update() {
				var data=$("#formcomments").serialize();
				var path = "${pageContext.request.contextPath }/admins?method=updateComment&id="+id;
				$.post(
					path,
					data,
					function(data) {
						show(1);
					}, 
					"json");
				$('#myModal').modal('hide');
				$("#relpy").html("");
			}
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
					<a href="#">评论管理</a>
				</li>
			</ul>
		</div>

		<div class="formbody">

			<div id="usual1" class="usual">

				<div class="itab">
					<ul>
						<li>
							<a href="#tab1" class="selected">评论列表</a>
						</li>
					</ul>
				</div>
				
				<div id="tab1" class="tabson">
					<table class="tablelist">
						<thead>
							<tr>
								<th>编号<i class="sort"><img src="images/px.gif" /></i></th>
								<th>用户id</th>
								<th>商品名id</th>
								<th>评论日期</th>
								<th>评论内容</th>
								<th>回复</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody id="list" align='center'>
						</tbody>
					</table>
				</div>
			</div>
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">回复编号&nbsp;&nbsp;:&nbsp;&nbsp;<lable id="number" style="font-size:10px"></lable></h4>
					</div>
					<form role="form" method="post" id="formcomments">
								<div class="modal-body">
									<div class="form-group">
				                       	<label class="sr-only" for="contact-message">Message</label>
				                        <textarea style="height:100px" id="reply" name="reply" placeholder="请输入..." class="contact-message form-control" id="contact-message"></textarea>
				                    </div>
			                    </div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">关闭</button>
									<button type="button" id="updateBtn" onclick="update();" class="btn btn-primary">提交更改</button>
								</div>
							</form>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>
			<script type="text/javascript">
				$("#usual1 ul").idTabs();
			</script>

			<script type="text/javascript">
				$('.tablelist tbody tr:odd').addClass('odd');
			</script>
		</div>
	</body>
</html>