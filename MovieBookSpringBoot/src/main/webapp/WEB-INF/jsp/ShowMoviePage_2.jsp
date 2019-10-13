<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="fo" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<thead><tr><th>Show Movie</th></tr></thead>
		<tr>
			<th>Movie Id</th>
			<th>Movie Name</th>
			<th>Language</th>
			<th>Genre</th>
			<th>Movie Length</th>
			<th>Director</th>
			<th>Release Date</th>
		</tr>
		<fo:forEach var="movie" items="${movieList}">
			<tr>
				<td>${movie.movieId}</td>
				<td>${movie.movieName}</td>
				<td>${movie.language}</td>
				<td>${movie.genre}</td>
				<td>${movie.movieLength}</td>
				<td>${movie.director}</td>
				<td>${movie.movieReleaseDate}</td>
				<%-- <td>${movie.movieList}</td>
				<td>${movie.moviesList}</td> --%>
			</tr>
		</fo:forEach>

	</table>
</body>
</html>