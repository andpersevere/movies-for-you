<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="fo" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
	<thead><tr><th>Show Customer</th></tr></thead>
		<tr>
			<th>Customer Id</th>
			<th>Customer User Name</th>
			<th>Customer Contact</th>
		</tr>
		<fo:forEach var="customer" items="${customerData}">
			<tr>
				<td>${customer.customerId}</td>
				<td>${customer.customerName}</td>
				<td>${customer.customerPhone}</td>
				
				<%-- <td>${customer.customerList}</td>
				<td>${customer.customersList}</td> --%>
			</tr>
		</fo:forEach>

	</table>
</body>
</html>