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

	<fo:form action="addShowToDatabase" method="post"
		modelAttribute="myShowForm">
		<table>

			<tr>
				<td>Total Seats</td>
				<td><fo:input path="availableSeats"></fo:input></td>
				<td><span><fo:errors path="availableSeats" /></span></td>
			</tr>
			<tr>
				<td>Theatre:</td>
				<td><select id="theatre_id" name="theatre_id">
						<c:forEach items="${theatreDataItem}" var="theatre">
							<option value="${theatre.theatreId}">${theatre.theatreName}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Movie</td>
				<td><select id="movie_id" name="movie_id">
						<c:forEach items="${movieDataItem}" var="movie">
							<option value="${movie.movieId}">${movie.movieName}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Show Date</td>
				<td><label for="datepicker"> <input
					id="showDate_id" name="showDate_id" value="2019-10-03"
					min="2019-10-01" max="2019-11-12" class="datepicker" required /></td>
			</tr>
			<tr>
				<td>Show Time</td>
				<td><input type="time" id="showTime_id" name="showTime_id"
					min="09:00" max="23:00" required /><span>Time must be
						between 9:00 hrs to 23:00 hrs</span></td>
				<td><span><fo:errors path="showTime" /></span></td>
			</tr>

			<tr>
				<td><input type="submit" value="Add Show"></td>
			</tr>

		</table>
	</fo:form>

	<script>
			$('.datepicker').datepicker({
			    format: 'mm/dd/yyyy',
			    startDate: '-1d'
			});
			</script>
</body>
</html>