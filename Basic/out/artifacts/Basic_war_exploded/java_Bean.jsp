<%@ page contentType="text/html;charset=gb2312" %>
<HTML>
<BODY bgcolor="skyblue">
<br>ѧ�ţ�15031210133 ���������»�</br>
<br>Ӣ����ĸ��</br>
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