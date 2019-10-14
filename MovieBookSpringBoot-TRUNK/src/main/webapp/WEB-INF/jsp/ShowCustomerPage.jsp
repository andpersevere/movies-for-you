<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="fo" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>movies4u</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">
<script
	src=https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/js/materialize.min.js></script>


<style type="text/css">
body {
	background-color: #ffffff;
}

footer {
	position: absolute;
	bottom: 0;
	width: 100%;
}

.card {
	margin-top: 15vh;
}
</style>
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="card col s6 offset-s6 center">
				<table border="1" class="striped">
					<thead>
						<tr>
							<th>Show Customer</th>
						</tr>
					</thead>
					<tr>
						<th>Customer Id</th>
						<th>Customer User Name</th>
						<th>Customer Contact</th>
					</tr>
					<fo:forEach var="customer" items="${customerData}">
						<tr>
							<td>${customer.customerId}</td>
							<td>${customer.customerName}</td>
							<td>${customer.contactNumber}</td>
						</tr>
					</fo:forEach>

				</table>
			</div>
		</div>
	</div>
</body>
</html>