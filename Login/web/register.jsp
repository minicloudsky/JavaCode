<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
    <meta charset="UTF-8">
</head>
<body bgcolor="#87cefa">
<form action="save.jsp" id="form" method="post">
        <p>请填写一下信息好吗?</p>
    <p>用户名:&nbsp;&nbsp;<input type="text" name="username" id="username"></p>
    <p>密码:&nbsp;&nbsp;<input type="password" name="password" id="password"></p>
        确认密码:&nbsp;&nbsp;<input type="text" name="confirm" id="confirm">
        <p>性别:&nbsp;&nbsp;
            <input type="radio" name="sex" id="male">男
            <input type="radio" name="sex" id="female">女
        </p>
         <p>  爱好:&nbsp;&nbsp;<input type="checkbox" value = "basketball" name="basketball" id= "basketball">篮球
                   <input type="checkbox" value="足球" name="football" id="football">足球
         </p>
        <p>
            <label>专业:&nbsp;&nbsp;</label>
                <select name="major" id = "major">
                    <option value="请选择" name="selecet">请选择</option>
                    <option value="物联网" name="net">物联网</option>
                    <option value="软件工程" name="software">软件工程</option>
                    <option value="英语" name= "english">英语</option>
                </select>
         </p>
           <p> 其他:</br>
                <textarea  rows="10" cols="20" name="other" style="word-break-inside: 100% " ></textarea>
           </p>
    <input type="submit"  name="button" id="button" value="登录">
</form>
</body>
</html>
