<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Edit Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body class="bg-light">
<div class="container py-4">
    <h2 class="mb-4 text-center">Edit Product</h2>

    <div class="card shadow-sm p-4">
        <form action="products" method="post">
            <input type="hidden" name="action" value="update" />
            <input type="hidden" name="id" value="${product.id}" />

            <div class="mb-3">
                <label class="form-label">Name</label>
                <input type="text" class="form-control" name="name" value="${product.name}" required />
            </div>

            <div class="mb-3">
                <label class="form-label">Price</label>
                <input type="number" step="0.01" class="form-control" name="price" value="${product.price}" required />
            </div>

            <div class="mb-3">
                <label class="form-label">Quantity</label>
                <input type="number" class="form-control" name="quantity" value="${product.quantity}" required />
            </div>

            <div class="mb-3">
                <label class="form-label">Description</label>
                <textarea class="form-control" name="description" rows="3">${product.description}</textarea>
            </div>

            <div class="d-flex justify-content-between">
                <a href="products" class="btn btn-secondary">Back</a>
                <button type="submit" class="btn btn-primary">Save Changes</button>
            </div>
        </form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>