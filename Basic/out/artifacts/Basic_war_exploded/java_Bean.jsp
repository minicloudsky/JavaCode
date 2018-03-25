<%@ page contentType="text/html;charset=gb2312" %>
<HTML>
<BODY bgcolor="skyblue">
<br>学号：15031210133 姓名：马月华</br>
<br>英文字母表：</br>
<% char c='A';
    for(c='A';c<='Z';c++){
        out.print(" "+c);
        if(c=='M'){
            out.print("<br>");
        }
    }
%>
</BODY>
</HTML>