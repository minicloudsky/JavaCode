<%--
  Created by IntelliJ IDEA.
  User: qiyu
  Date: 2017-12-18
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8" import="java.util.*" %>
<jsp:useBean id="cal" scope="request" class="com.Calculator"></jsp:useBean>
<jsp:setProperty name="cal" property="*"></jsp:setProperty>
<html>
  <head>
      <meta charset="UTF-8">
    <title>JSP中使用JavaBean</title>
  </head>
  <body>
  <form id="form1" name="form1" method="post" action="index.jsp">
      <table width="399" border="1">
          <tr>
              <td colspan="2">计算器</td>
          </tr>
          <tr>
              <td>第一个参数</td>
              <td><input type="text" name="value1" id="value1"></td>
          </tr>
          <tr>
              <td>运算符</td>
              <td>
                  <input type="radio" name="operatorNum" value="1">
                  <input type="radio" name="operatorNum" value="2">
                  <input type="radio" name="operatorNum" value="3">
                  <input type="radio" name="operatorNum" value="4">
              </td>
          </tr>
          <tr>
              <td>
                  第二个参数
              </td>
              <td>
                  <input type="text" name="value2" id="value2">
              </td>
          </tr>
          <tr>
              <td colspan="2">
                  <input type="submit" name="button" id="button" value="提交">
                  <input type="reset" name="button2" id="button2" value="重置">
              </td>
          </tr>
      </table>
  </form>
  <%
      out.println(cal.getValue1());
      out.println(cal.getValue2());
      cal.calculate();
  %>
  </body>
</html>
