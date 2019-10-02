<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body> 
<table>
<a:forEach var="pro" items="${adminName}">
<tr>
<td>Welcome ${adminName}</td>

</tr>
</a:forEach>
</table> 
	<a href="addTheatrePage">1. Add Theatre</a><br>
	<a href="addMoviePage">2. Add Movie</a><br>
	<a href="addShowPage">3. Add Show</a><br>
	<a href="showCustomerPage">4. Show Customers</a><br>
</body>
</html>