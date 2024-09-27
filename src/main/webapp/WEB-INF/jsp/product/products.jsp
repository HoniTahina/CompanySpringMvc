<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 27/09/2024
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Products</title>
</head>
<body>
<jsp:include page="../welcome.jsp" />
<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th>Référence</th>
            <th>Nom</th>
            <th>Stock</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${productList}" var="product">
                <tr>
                    <td>${product.ref}</td>
                    <td>${product.name}</td>
                    <td>${product.stock}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<div class="container">
    <form action="products" method="post">
        <div class="mb-3">
            <label for="inputRef" class="form-label">Référence</label>
            <input type="text" name="ref" class="form-control" id="inputRef">
        </div>
        <div class="mb-3">
            <label for="inputName" class="form-label">Nom</label>
            <input type="text" name="name" class="form-control" id="inputName">
        </div>
        <div class="mb-3">
            <label for="inputStock" class="form-label">Stock</label>
            <input type="number" name="stock" class="form-control" id="inputStock">
        </div>
        <button type="submit" class="btn btn-primary">Ajouter Produit</button>
    </form>
</div>
</body>
</html>
