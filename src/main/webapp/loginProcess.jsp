<%@page import="ru.spbu.exception.NoSuchUserException" %>
<%@ page import="ru.spbu.exception.WrongPasswordException" %>
<%@ page import="ru.spbu.services.UserService" %>
<%@ page import="java.sql.SQLException" %>
<jsp:useBean id="user" class="ru.spbu.models.User"/>

<jsp:setProperty property="*" name="user"/>

<%
    try {
        UserService userService = new UserService();
        userService.checkPasswordForUser(user.getName(), user.getPassword());
        request.getSession().setAttribute("currentUser", user);

        user = userService.findUserByName(user.getName());

//        String userRole = userService.getUserRole(user.getName());

        String userRole = user.getRole();
        if (userRole.equals("admin")) {
            request.getRequestDispatcher("adminUserHomePage.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("userHomePage.jsp").forward(request, response);
        }

    } catch (WrongPasswordException | NoSuchUserException e) {
        request.setAttribute("error message", e.getMessage());
        request.getRequestDispatcher("loginUnsuccessful.jsp").forward(request, response);
    } catch (SQLException e) {
        e.printStackTrace();
    }
%>