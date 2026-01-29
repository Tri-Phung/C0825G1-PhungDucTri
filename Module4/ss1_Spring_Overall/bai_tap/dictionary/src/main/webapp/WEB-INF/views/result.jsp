<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2025-12-25
  Time: 10:54 PM
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
    <c:when test="${found}">
        <label>Word: ${word} =></label>
        <label>Meaning: ${meaning}</label>
    </c:when>
    <c:otherwise>
        <label>Word not found</label>
    </c:otherwise>
</c:choose>

    </body>
    </html>
