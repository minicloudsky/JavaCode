<%--
  Created by IntelliJ IDEA.
  User: qiyu
  Date: 2018-06-06
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Title</title>
  <!-- 配置文件 -->
  <script type="text/javascript" src="../ueditor/ueditor.config.js"></script>
  <!-- 编辑器源码文件 -->
  <script type="text/javascript" src="../ueditor/ueditor.all.js"></script>
  <!-- 实例化编辑器 -->
</head>
<div style="">
<form action="result.jsp" method="post">
  <!-- 加载编辑器的容器 -->
  <script id="container" name="content" type="text/plain">
            这里写你的初始化内容
        </script>
  <input type="submit" value="提交"/>
</form>
</div>
<script type="text/javascript">
    var editor = UE.getEditor('container');
</script>

</body>
</html>
