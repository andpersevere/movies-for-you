<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
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
	<table border="1">
	<thead><tr><th>Display Shows</th></tr></thead>
		<tr>
			<th>Show Id</th>
			<th>Available Seats</th>
			<th>Show Date</th>
			<th>Show Time</th>
			<th>Movie Name</th>
			<th>Theatre Name</th>
		</tr>
		<c:forEach var="show" items="${showsList}">
			<tr>
				<td>${show.showId}</td>
				<td>${show.availableSeats}</td>
				<td>${show.showDate}</td>
				<td>${show.showTime}</td>
				<td>${show.movie.movieName}</td>
				<td>${show.theatre.theatreName}</td>
				<%-- <td>${show.movieList}</td>
				<td>${show.showsList}</td> --%>
			</tr>
		</c:forEach>

	</table>
</body>
</html>