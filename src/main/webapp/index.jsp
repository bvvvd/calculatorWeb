<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <div>
        <h1>hello world</h1>
    </div>
</head>

<body>

<form name="form" method="post">
    <input type="text" name="expression">
    <input type="submit" value="calculate!" name="calculation">
</form>

<form name="register" method="get">
    <a href="register.jsp" class="btn1">register</a>
    <a href="login.jsp" class="btn2">login</a>
</form>

<%
    String expression = request.getParameter("expression");

    if (expression != null) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/calculationResult");
        requestDispatcher.forward(request, response);
    }
%>

</body>
</html>

