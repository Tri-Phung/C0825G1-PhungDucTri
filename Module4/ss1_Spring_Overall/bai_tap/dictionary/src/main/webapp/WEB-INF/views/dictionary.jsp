<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2025-12-25
  Time: 10:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<form action="/translate" method="post">
    <label>Enter word:</label>
    <input type="text" name="word">
    <input type="submit" value="Translate">
</form>
</body>
</html>
