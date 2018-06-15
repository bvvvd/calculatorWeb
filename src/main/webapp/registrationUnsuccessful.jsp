<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Unsuccessful registration</title>
</head>

<body>

<form name="registrationForm" method="post">
    <p><b><%
        out.print(request.getAttribute("error message"));
    %></b></p>
    <a href="register.jsp">another try</a>
    <a href="index.jsp">to main page</a>
</form>

</body>
</html>
