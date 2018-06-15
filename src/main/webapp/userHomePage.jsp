<%@ page import="ru.spbu.models.User" %><%--
  Created by IntelliJ IDEA.
  User: valerii
  Date: 15.06.2018
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User currentUser = (User) session.getAttribute("currentUser");
%>
<html>
<head>
    <title>Welcome, <%
        out.print(currentUser.getName());
    %></title>
</head>
<body>
    <h1>Welcome, <%
        out.print(currentUser.getName());
    %></h1>
</body>
</html>
