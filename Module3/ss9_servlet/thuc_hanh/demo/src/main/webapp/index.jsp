<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Thuc hanh</title>
</head>
<body>
<h2>Vietnamese Dictionary</h2>
<form action="/translate" method="post">
    <input type="text" name="txtSearch" placeholder="Enter your word: "/>
    <input type = "submit" id = "submit" value = "Search"/>
</form>
<h1>Kết quả</h1>
<h1>${text}: ${result}</h1>
<p>${message}</p>
</body>
</html>