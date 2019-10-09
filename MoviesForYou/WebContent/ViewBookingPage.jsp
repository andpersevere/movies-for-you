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

<table border="1">
	<thead><tr><th>View Booking</th></tr></thead>
		<tr>
			<th>Booking Id</th>
			<th>Seats Booked</th>


			
		</tr>
		<a:forEach var="booking" items="${data}">
			<tr>
				<td>${booking.bookingId}</td>
				<td>${booking.seatsBooked}</td>
	
			
				
				
				<%-- <td>${movie.movieList}</td>
				<td>${movie.moviesList}</td> --%>
			</tr>
		</a:forEach>

	</table> 
</body>
</html>