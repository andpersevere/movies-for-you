<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="fo" uri="http://www.springframework.org/tags/form"%>
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
				<td><label><fo:select path="language"
							items="${languageDataItem}" /></label></td>
			</tr>
			<tr>
				<td>Genre</td>
				<td><fo:checkboxes path="genre" items="${genreDataItem}" /></td>
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
				<td><label for="datepicker"/> <input
					id="movieReleaseDate_id" name="movieReleaseDate_id" value="2019-10-03"
					min="2019-10-01" max="2019-11-12" class="datepicker" required /></td>
			</tr>
			<tr><td>Theatres</td><td>
				 <c:forEach items="${theatreDataItem}" var="theatre">
							<input type="checkbox" name="theatre_id" class="case"
								value="${theatre.theatreId}">${theatre.theatreName}
						
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
</body>
</html>