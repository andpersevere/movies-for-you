<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="fo" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<style>
thead {
	color: green;
}

tbody {
	color: black;
}

tfoot {
	color: red;
}

table, th, td {
	border: 0px solid black;
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<table>
	<thead><tr><th>Add Theatre</th></tr></thead>
	
		<fo:form action="addTheatreToDatabase" method="post" modelAttribute="myTheatreForm">
			<tr>
				<td>Theatre Name</td>
				<td><fo:input path="theatreName"/></td>
				<td><span><fo:errors path="theatreName"/></span> </td>
			</tr>
			<tr>
				<td>Theatre City</td>
				<td><fo:select path="cityName" items="${cityDataItem}"/></td> 
			</tr>
			<tr>
				<td>Theatre Pin Code</td>
				<td><fo:input path="cityPincode"/></td>
				<td><span><fo:errors path="cityPincode"/></span> </td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="Add Theatre">
				</td>
			</tr>
		</fo:form>
	</table>
</body>
</html>