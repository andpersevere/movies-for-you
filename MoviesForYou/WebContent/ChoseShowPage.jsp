<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="ShowShowPage.jsp"></jsp:include>
<table border=1>

<tr><td>Show Id</td>
<td>Show Timings</td>
</tr>

<c:forEach var="show" items="${showsList}">
			<tr>
				
				<td>${show.showId}</td>
				<td>${show.showTimings}</td>
				<td>${show.availableSeats}</td>

			</tr>

		</c:forEach>
</table>
<form action="choseShowSubmit" method="POST">
<table><tr>

<td>Show Id:<input type="text" name="showId"><br>
<td>Seats Booked:<input type="number" name="seatsBooked"><br>
<td>User Id:<input type="text" value="<% out.print(session.getAttribute("customerId")); %>" name="customerId" readonly/><br></td>
<td>Movie Id:<input type="text" value="<% out.print(session.getAttribute("movieId")); %>" name="movieId" readonly><br></td>
<td>Theatre Id:<input type="text" value="<% out.print(session.getAttribute("theatreId")); %>" name="theatreId" readonly><br></td>
<td>><input type="submit" value="Book Ticket" /></td>
</tr>
</table>
</form>
</body>
</html>