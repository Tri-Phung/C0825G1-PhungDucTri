<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product Discount Calculator</title>
</head>
<body>
<h1>Product Discount Calculator</h1>
<br/>
<form action="discount-calculator" method="post">
    <table>
        <tr>
            <td>Product Description:</td>
            <td><input type="text" name="productDescription"><br></td>
        </tr>
        <tr>
            <td>List Price:</td>
            <td><input type="text" name="listPrice"><br></td>
        </tr>
        <tr>
            <td>Discount percent:</td>
            <td><input type="text" name="discountPercent"><br></td>
        </tr>
    </table>
    <br>
    <input type="submit" value="Calculate">
    <p>${message}</p>
</form>
</body>
</html>