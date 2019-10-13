<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<%
	if (null == session.getAttribute("username")) {
		response.sendRedirect("LogInPage");
	} else {
		
%>
<head>
    <title>movies4u</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">
	<script src=https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/js/materialize.min.js></script>
	
	
  <style type="text/css">
    body{
  background-color: #ffffff;
}
footer{
  position: absolute;
  bottom: 0;
  width: 100%;
}
.card{
  margin-top: 15vh;
}
  </style>
</head>
<body>

<table border=1>

<tr><td>Theatre Id</td>
<td>Theatre Name</td>
</tr>

<c:forEach var="theatrein" items="${theatreList}">
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