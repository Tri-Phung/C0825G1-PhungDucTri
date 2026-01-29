<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Product List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body class="bg-light">
<div class="container py-4">
    <h2 class="mb-4 text-center">Product List</h2>

    <!-- Search + Add Button Row -->
    <div class="d-flex justify-content-between mb-3">
        <form class="d-flex" action="products" method="get">
            <input type="hidden" name="action" value="search" />
            <input class="form-control me-2" type="search" placeholder="Search by name" name="keyword" />
            <button class="btn btn-primary" type="submit">Search</button>
        </form>

        <a href="products?action=add" class="btn btn-success">+ Add Product</a>
    </div>

    <table class="table table-bordered table-striped table-hover">
        <thead class="table-dark text-center">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th width="180px">Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="p" items="${products}">
            <tr>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td>${p.price}</td>
                <td>${p.quantity}</td>
                <td class="text-center">
                    <a href="products?action=detail&id=${p.id}" class="btn btn-info btn-sm">Detail</a>
                    <a href="products?action=edit&id=${p.id}" class="btn btn-warning btn-sm">Edit</a>
                    <a href="products?action=delete&id=${p.id}" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
