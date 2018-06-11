<%--
  Created by IntelliJ IDEA.
  User: qiyu
  Date: 2018-06-07
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script language="JavaScript" type="text/javascript">
    function check(form) {
        if(document.loginform.AdminName.value == ""){
            alert("请输入管理员名");
            document.loginform.AdminName.focus();
            return false;
        }
        if(document.loginform.Password.value == ""){
            alert("请输入登录密码");
            document.loginfrom.Password.focus();
            return false;
        }
    }
    window.onload = function () {
        document.getElementById("AdminName").focus();
        document.getElementById("AdminName").value = "";
        document.getElementById("Password").value = "";
    }
</script>
...
<form name="loginform" action="./login-check.jsp" method="post"
onsubmit="return check(this)">
    <table width="350" border="0" cellspacing="1" cellpadding="0">
        <tr>
            <td colspan="2" align="center"><strong>博客管理员登录</strong></td>
        </tr>
        <tr>
            <td width="101" class="item">管理员名:</td>
            <td width="246" class="input">
                <input name="AdminName" type="text" id="AdminName" size="30"/></td>
        </tr>
        <tr>
            <td class="item">登录密码</td>
            <td class="input"><input type="Password" id="Password" size="30"/></td>
        </tr>
        <tr>
            <td colspan="2" class="button"><input type="submit" value="登录"/></td>
        </tr>
    </table>
</form>
...