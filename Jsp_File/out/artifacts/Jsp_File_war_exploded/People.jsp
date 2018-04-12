<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head></head>
<body bgcolor=><font size=3>
    <h1>马月华&nbsp; &nbsp;&nbsp; 15031210133</h1>
    <%!int count;
        StringBuffer personList;
        public void judge(){
            if(count==0)
                personList=new StringBuffer();
        }
        public void addPerson(String p){
            if(count==0)
                personList.append(p);
            else
                personList.append(","+p);
            count++;
        } %>
    <%String name=request.getParameter("name");
        byte bb[]=name.getBytes("iso-8859-1");
        name=new String(bb);
        if(name.length()==0||name.length()>10){
    %><jsp:forward page="inputName.jsp"/><% }
    judge();
    addPerson(name);
%>
    <br>目前共有<%=count %>人浏览了该页面，他们的名字是：
    <br><% out.println("马月华");%>
</font> </body></html>