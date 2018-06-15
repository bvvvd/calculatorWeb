<%@ page import="ru.spbu.models.User" %>
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

<form action="calculator.jsp">
    <input type="submit" value="go to calculator"/>
</form>

<form action="changePassword.jsp">
    <input type="submit" value="change password"/>
</form>

<form action="LogoutServlet" method="get">
    <input type="submit" value="logout">
</form>

<form action="deleteUser.jsp" method="post">
    <input type="submit" value="delete user">
</form>

</body>
</html>
