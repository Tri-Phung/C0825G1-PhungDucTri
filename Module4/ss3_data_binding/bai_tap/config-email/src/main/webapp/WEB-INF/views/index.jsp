<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>

        <html>

        <head>
            <title>Index</title>
        </head>

        <body>
            <h1>Mail Inbox Information</h1>
            <table>
                <tr>
                    <td>Languages: </td>
                    <td>${languages}</td>
                </tr>
                <tr>
                    <td>Page Size: </td>
                    <td>${pageSize}</td>
                </tr>
                <tr>
                    <td>Spams filter: </td>
                    <td>
                        <c:choose>
                            <c:when test="${spamsFilter}">Yes</c:when>
                            <c:otherwise>No</c:otherwise>
                        </c:choose>
                    </td>
                </tr>
                <tr>
                    <td>Signature: </td>
                    <td>${signature}</td>
                </tr>
                <tr>
                    <td>
                        <a href="getSettingInfo">
                            <button>Change Setting</button>
                        </a>
                    </td>
                </tr>
            </table>
        </body>

        </html>