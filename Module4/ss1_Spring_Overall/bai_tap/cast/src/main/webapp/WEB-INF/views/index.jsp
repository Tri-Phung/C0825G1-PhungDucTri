<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2025-12-25
  Time: 3:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cash Converter</title>
    <style>
        .modal {
            display: none;  /* Ẩn mặc định */
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            background: white;
            padding: 20px;
            border: 2px solid red;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.3);
            z-index: 1000;
            text-align: center;
        }
    </style>
</head>
<body>
<h1>Convert USD to VND:</h1>
<form action="/convert" method="post" onsubmit="return checkInput()">
    <label>Rate:</label>
    <label>26290.95</label> <br>
    <label>USD:</label>
    <input id="usd" type="text" name="usd"> <br>
    <input type="submit" value="Submit">
</form>
</body>

</html>
