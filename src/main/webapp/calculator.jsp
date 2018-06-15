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

</body>
</html>
