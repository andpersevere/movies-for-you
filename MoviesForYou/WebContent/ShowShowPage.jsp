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
	<thead><tr><th>Show Show</th></tr></thead>
		<tr>
			<th>Show Id</th>
			<th>Available Seats</th>
			<th>Show Date</th>
			<th>Show Time</th>
			<th>Movie Name</th>
			<th>Theatre Name</th>
		</tr>
		<fo:forEach var="show" items="${showData}">
			<tr>
				<td>${show.showId}</td>
				<td>${show.availableSeats}</td>
				<td>${show.show_date}</td>
				<td>${show.show_timings}</td>
				<td>${show.movie.movieName}</td>
				<td>${show.theatre.theatreName}</td>
				<%-- <td>${show.movieList}</td>
				<td>${show.showsList}</td> --%>
			</tr>
		</fo:forEach>

	</table>
</body>
</html>