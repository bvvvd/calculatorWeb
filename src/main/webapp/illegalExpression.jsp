<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Illegal expression</title>
</head>
<body>
    <%
        String error = ((Throwable) request.getSession().getAttribute("error")).getMessage();
        out.print(error);
    %>
<a href="index.jsp">go to main page</a>
</body>
</html>
