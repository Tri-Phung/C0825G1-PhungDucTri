<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2025-12-26
  Time: 3:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/calculator" method="post">
    <input type="text" name="number1" value="${number1}">
    <input type="text" name="number2" value="${number2}"> <br><br>
    <button type="submit" value="add" name="operation">Addition(+)</button>
    <button type="submit" value="subtract" name="operation">Subtraction(-)</button>
    <button type="submit" value="multiply" name="operation">Multiplication(X)</button>
    <button type="submit" value="divide" name="operation">Division(/)</button>
    <br><br>
    <label>Result ${operation}: ${result}</label> <br><br>
    <label id="message">Error: ${errorMessage}</label>
</form>
</body>
<script>
    var message = document.getElementById("message");
    if ("${errorMessage}" == "") message.style.display = "none";
</script>
</html>
