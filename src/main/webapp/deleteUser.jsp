<%@ page import="ru.spbu.models.User" %>
<%@ page import="ru.spbu.services.UserService" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete user</title>
</head>
<body>
<%
    UserService userService = new UserService();
    List<User> allUsers = userService.getAll();

    for (User user : allUsers) {
        out.print("<br>" + user.getName() + " " + user.getRole() + "</br>");
    }
%>
<form action="/deleteUser" method="get">
    Delete user with name:<input type="text" name="userNameToDelete">
    <input type="submit" value="delete user" name="deleteUser">
</form>
</body>
</html>
