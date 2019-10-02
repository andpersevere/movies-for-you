<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<%
	if (null == session.getAttribute("customerId")) {
		response.sendRedirect("LogInPage");
	} else {
		
%>
<head>
<meta charset="ISO-8859-1">
<title>Chose Theatre</title>
</head>
<body>

<table border=1>

<tr><td>Theatre Id</td>
<td>Theatre Name</td>
</tr>

<c:forEach var="theatrein" items="${theatresList}">
			<tr>
				
				<td>${theatrein.theatreId}</td>
				<td>${theatrein.theatreName}</td>


			</tr>

		</c:forEach>
</table>
<form action="choseTheatreSubmit" method="POST">
<table><tr>
<td>Select Theatre Id:<input type="text" name="theatreId"><br>
<td>User Id:<input type="text" value="<% out.print(session.getAttribute("customerId")); %>" name="customerId" readonly/><br></td>
<td>Movie Id:<input type="text" value="<% out.print(session.getAttribute("movieId")); %>" name="movieId" readonly><br></td>
<td><input type="submit" value="Chose Theatre" /></td>
</tr>
</table>
</form>
</body>
<% } %>
</html>