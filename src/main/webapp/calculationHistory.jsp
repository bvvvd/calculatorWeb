<%@ page import="ru.spbu.models.Calculation" %>
<%@ page import="ru.spbu.models.User" %>
<%@ page import="ru.spbu.services.CalculationHistoryService" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        User currentUser = (User) session.getAttribute("currentUser");
        List<Calculation> historyForUser = new CalculationHistoryService().getHistoryForUser(currentUser);

        for (Calculation calculation : historyForUser) {
            out.print("<br>");
            out.print(calculation.getExpression() + " = " + calculation.getResult() + ", " + calculation.getDate());
            out.print("</br>");
        }

        out.print("that's all");
    %>
</body>
</html>
