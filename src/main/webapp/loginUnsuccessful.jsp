<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Unsuccessful login</title>
</head>

<body>

<form name="loginForm" method="post">
    <p><b><%
        out.print(request.getAttribute("error message"));
    %></b></p>
    <a href="login.jsp">another try</a>
    <a href="index.jsp">go to main page</a>
</form>

</body>
</html>
