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
<jsp:include page="ShowTheatrePage.jsp"></jsp:include>
<table border=1>

<tr><td>Theatre Id</td>
<td>Theatre Name</td>
</tr>

<c:forEach var="theatre" items="${theatresList}">
			<tr>
				
				<td>${theatre.theatreId}</td>
				<td>${theatre.theatreName}</td>


			</tr>

		</c:forEach>
</table>
<form action="choseTheatreSubmit" method="POST">
<table><tr>
<td>Select Theatre Id:<input type="text" name="theatreId"><br>
<td>Select Date and Time:<input type="datetime-local" name="dateAndTime" /><br></td>
<td>User Id:<input type="text" value="<% out.print(session.getAttribute("customerId")); %>" name="customerId" readonly/><br></td>
<td>Movie Id:<input type="text" value="<% out.print(session.getAttribute("movieId")); %>" name="movieId" readonly><br></td>
<td>><input type="submit" value="Chose Theatre" /></td>
</tr>
</table>
</form>
</body>
<% } %>
</html>