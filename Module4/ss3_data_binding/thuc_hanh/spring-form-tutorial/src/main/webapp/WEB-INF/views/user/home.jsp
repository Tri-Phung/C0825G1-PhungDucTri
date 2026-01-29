<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Home</h3>
<form:form action="login" method="post" modelAttribute="login">
    <fieldset>
    <legend>Login</legend>
    <table>
    <tr>
    <td>Username:</td>
    <td><form:input path="account"></form:input></td>
    </tr>
    <tr>
    <td>Password:</td>
    <td><form:password path="password"></form:password></td>
    </tr>
    <tr>
    <td><form:button>Login</form:button></td>
    </tr>
    </table>
    </fieldset>
</form:form>
</body>
</html>
