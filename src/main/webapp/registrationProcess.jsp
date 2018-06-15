<%@page import="ru.spbu.services.UserService"%>
<%@ page import="ru.spbu.exception.UserAlreadyExistException" %>
<%@ page import="java.sql.SQLException" %>
<jsp:useBean id="user" class="ru.spbu.models.User"/>

<jsp:setProperty property="*" name="user"/>

<%
    try {
        new UserService().createUser(user.getName(), user.getPassword());
        request.getRequestDispatcher("registrationSuccessful.jsp").forward(request, response);
    } catch (UserAlreadyExistException e) {
        request.setAttribute("error message", e.getMessage());
        request.getRequestDispatcher("registrationUnsuccessful.jsp").forward(request, response);
        out.print(e);
    } catch (SQLException e) {
        e.printStackTrace();
    }
%>