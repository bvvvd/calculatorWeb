<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration form</title>
</head>
<body>
<form action="registrationProcess.jsp">
    <input type="text" name="name" value="Name..." onclick="this.value=''"/><br/>
    <input type="password" name="password"  value="Password..." onclick="this.value=''"/><br/>
    <input type="submit" value="register"/>
</form>
</body>
</html>
