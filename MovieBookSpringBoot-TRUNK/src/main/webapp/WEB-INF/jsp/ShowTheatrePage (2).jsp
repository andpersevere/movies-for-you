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
	<thead><tr><th>Show Theatre</th></tr></thead>
		<tr>
			<th>Theatre Id</th>
			<th>Theatre Name</th>
			<th>Theatre City</th>
			<th>Theatre Pincode</th>
		</tr>
		<fo:forEach var="theatre" items="${theatresList}">
			<tr>
				<td>${theatre.theatreId}</td>
				<td>${theatre.theatreName}</td>
				<td>${theatre.cityName}</td>
				<td>${theatre.cityPincode}</td>

			</tr>
		</fo:forEach>

	</table>
</body>
</html>