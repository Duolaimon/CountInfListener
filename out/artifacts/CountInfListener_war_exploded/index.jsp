<%@ page import="java.util.ArrayList" %>
<%@ page import="Item.User" %><%--
  Created by IntelliJ IDEA.
  User: deity
  Date: 16-11-14
  Time: 下午8:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>监听器</title>
  </head>
  <body>
    当前在线人数为${userNums}<br/>
    <%
      ArrayList<User> users = (ArrayList<User>) request.getServletContext().getAttribute("users");
      if (users!=null)
        for (User user : users) {
    %>
    Ip:<%=user.getIpString()%>,FirstTime:<%=user.getFirstTimeString()%>,SessionId:<%=user.getSessionId()%><br/>
    <%
        }
    %>
  </body>
</html>
