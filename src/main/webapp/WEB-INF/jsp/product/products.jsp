
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Products</title>
	</head>
	
	<body>
	<jsp:include page="../welcome.jsp"></jsp:include>
		<div class="container">
			<div class="row">
				<div class="col-sm-6">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Product list</h5>
							<table class="table table-striped table-hover">
								<thead>
									<tr>
										<th>NAME</th>
										<th>REFERENCE</th>
										<th>STOCK</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${productList}" var="product">
										<tr>
											<td>${product.name}</td>
											<td>${product.reference}</td>
											<td>${product.stock}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Add Product</h5>
							<form action="products" method="post">
								<div class="mb-3">
									<label for="exampleInputEmail1" class="form-label">Name</label>
									<input type="text" name="name" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
								</div>
								<div class="mb-3">
									<label for="exampleInputPassword2" class="form-label">Reference</label>
									<input type="text" name="reference" class="form-control" id="exampleInputPassword2">
								</div>
								<div class="mb-3">
									<label for="exampleInputPassword3" class="form-label">Stock quantity</label>
									<input type="number" name="stock" class="form-control" id="exampleInputPassword3">
								</div>
								<button type="submit" class="btn btn-primary">Submit</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>