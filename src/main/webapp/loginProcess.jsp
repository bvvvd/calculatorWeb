<%@page import="ru.spbu.exception.NoSuchUserException" %>
<%@ page import="ru.spbu.exception.WrongPasswordException" %>
<%@ page import="ru.spbu.services.UserService" %>
<%@ page import="java.sql.SQLException" %>
<jsp:useBean id="user" class="ru.spbu.models.User"/>

<jsp:setProperty property="*" name="user"/>

<%
    try {
        new UserService().checkPasswordForUser(user.getName(), user.getPassword());
        session.setAttribute("currentUser", user);
        request.getRequestDispatcher("userHomePage.jsp").forward(request, response);
    } catch (WrongPasswordException | NoSuchUserException e) {
        request.setAttribute("error message", e.getMessage());
        request.getRequestDispatcher("loginUnsuccessful.jsp").forward(request, response);
    } catch (SQLException e) {
        e.printStackTrace();
    }
%>