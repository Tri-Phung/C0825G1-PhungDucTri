<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <html>

        <head>
            <title>Setting</title>
            <style>
                .error {
                    color: red;
                }
            </style>
        </head>

        <body>
            <h1>Settings</h1>
            <form:form method="post" action="/setting" modelAttribute="mailInbox">
                <table>
                    <tr>
                        <td>Languages: </td>
                        <td>
                            <form:select path="languages" items="${languagesArray}" />
                        </td>
                    </tr>
                    <tr>
                        <td>Page Size: </td>
                        <td>Show
                            <form:select path="pageSize" items="${pageSizeArray}" /> emails per page
                            <br>
                            <form:errors path="pageSize" cssClass="error"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Spams filter: </td>
                        <td>
                            <form:checkbox path="spamsFilter" value="${spamsFilter}" /> Enable spams filter
                            <br>
                            <form:errors path="spamsFilter" cssClass="error"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Signature: </td>
                        <td>
                            <form:textarea path="signature" value="${signature}" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                        </td>
                        <td>
                            <button type="submit">Update</button>
                            <a href="/index"><button type="button">Cancel</button></a>
                        </td>
                    </tr>
                </table>
            </form:form>
        </body>

        </html>