<%--
  Created by IntelliJ IDEA.
  User: qiyu
  Date: 2017-11-19
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>在线答题</title>
</head>
<body>

<p>
    <form action="four.jsp" method="post" name = "form1">
    诗人李白是中历史上那个朝代的人:<br>
    <input type="radio" name="R" value="a"> 宋朝
    <input type="radio" name="R" value="b"> 唐朝
    <input type="radio" name="R" value="c"> 明朝
    <input type="radio" name="R" value="d"> 清朝<br>
    小说红楼梦的作者是:<br>
    <input type="radio" name="P" value="a">曹雪芹
    <input type="radio" name="P" value="b">雪芹
    <input type="radio" name="P" value="c">芹
    <input type="radio" name="P" value="d">曹<br>
    <input type="submit" value="提交答案" name="submit">
</form>
</p>
</body>
</html>
