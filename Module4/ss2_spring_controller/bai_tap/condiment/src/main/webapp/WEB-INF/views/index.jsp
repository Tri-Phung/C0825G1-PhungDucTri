<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2025-12-26
  Time: 3:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich Condiments</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/save" method="post">
    <label><input type="checkbox" name="condiment" value="Lettuce">Lettuce</label>
    <label><input type="checkbox" name="condiment" value="Tomato">Tomato</label>
    <label><input type="checkbox" name="condiment" value="Mustard">Mustard</label>
    <label><input type="checkbox" name="condiment" value="Sprouts">Sprouts</label>
    <button type="submit">Save</button>
</form>
</body>
</html>
