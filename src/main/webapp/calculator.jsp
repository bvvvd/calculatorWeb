<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>

<form name="form" method="post">
    <input type="text" name="expression">
    <input type="submit" value="calculate!" name="calculation">
</form>

<form action="calculationHistory.jsp">
    <input type="submit" value="show history">
</form>

<%
    String expression = request.getParameter("expression");

    if (expression != null) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/calculationResult");
        requestDispatcher.forward(request, response);
    }
%>

<a href="userHomePage.jsp">go to home page</a>

</body>
</html>
