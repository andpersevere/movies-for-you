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
		<fo:forEach var="movie" items="${movieData}">
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