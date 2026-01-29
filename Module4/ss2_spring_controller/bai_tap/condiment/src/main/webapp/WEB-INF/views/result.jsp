<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2025-12-26
  Time: 3:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<c:choose>
    <c:when test="${not empty condiments}">
        <label>Selected Condiment:</label> <br>
        <c:forEach var="condiment" items="${condiments}">
                ${condiment} <br>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <label>No Condiment Selected</label>
    </c:otherwise>
</c:choose>
<a href="/">Back</a>
</body>
</html>
