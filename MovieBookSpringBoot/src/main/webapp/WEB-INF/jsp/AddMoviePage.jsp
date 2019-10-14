<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fo" uri="http://www.springframework.org/tags/form"%>
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
<body background="<c:url value='/resources/movies6.jpg'/>" style="background-size: 100% 150%;background-repeat: no-repeat;">

	<nav>
		<div class="nav-wrapper red darken-4">
			<a href="home" class="brand-logo right">movies4u</a>
		
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<div class="card col s4 offset-s4 center">
	<fo:form action="addMovieToDatabase" method="post"
		modelAttribute="myMovieForm">
		<table>
			<tr>
				<td>Movie Name</td>
				
				<td><fo:input path="movieName" /></td>
				
				<td><span><fo:errors path="movieName" /></span></td>
			</tr>
			<tr>
				<td>Language</td>
				<td><td><fo:input path="language" /></td>
				<td><span><fo:errors path="language" /></span></td>
			</tr>
			<tr>
				<td>Genre</td>
				
				<td><c:forEach items="${genreDataItem}" var="myGenreList">
				<label>
							<input type="checkbox" name="genre_id" 
							value="${genreDataItem}"><span>${myGenreList}</span>
						</label>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td>Movie Length (Minutes)</td>
				<td><fo:input path="movieLength" /></td>
				<td><span><fo:errors path="movieLength" /></span></td>
			</tr>
			<tr>
				<td>Director</td>
				<td><fo:input path="director" /></td>
				<td><span><fo:errors path="director" /></span></td>
			</tr>
			<tr>
				<td>Movie Release Date</td>
				<td><label for="datepicker"> <input
					id="movieReleaseDate_id" name="movieReleaseDate_id" value="2019-10-03"
					min="2019-10-01" max="2019-11-12" class="datepicker" required /></label></td>
			</tr>
			<tr><td>Theatres</td><td>
				 <c:forEach items="${theatreDataItem}" var="theatre">
				 <label>
							<input type="checkbox" name="theatre_id" 
							value="${theatre.theatreId}"><span>${theatre.theatreName}</span>
						</label>
					</c:forEach></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Add Movie"></td>
				<td></td>
			</tr>
		</table>
	</fo:form>
	<script>
			$('.datepicker').datepicker({
			    format: 'yyyy-MM-dd',
			    startDate: '-1d'
			});
			</script>
			</div>
		</div>
	</div>
</body>
</html>