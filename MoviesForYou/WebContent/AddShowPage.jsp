<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="fo" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<style>
thead {
	color: green;
}

tbody {
	color: black;
}

tfoot {
	color: red;
}

table, th, td {
	border: 0px solid black;
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<table>
	<thead><tr><th>Add Show</th></tr></thead>
	
		<fo:form action="addShowToDatabase" method="post" modelAttribute="myShowForm">
			<tr>
				<td>Show Date</td>
				<td><fo:select path="show_date" type="date" name="Show Date" min="2019-09-30" max="2019-10-12">"></fo:select>></td>
				<td><span><fo:errors path="show_date"/></span> </td>
			</tr>
			<tr>
				<td>Show Time</td>
				<td><fo:select path="show_timings" type="time" name="Show Time" ></fo:select>></td>
				<td><span><fo:errors path="show_timings"/></span> </td> 
			</tr>
			<tr>
				<td>Total Seats</td>
				<td><fo:input path="availableSeats"></fo:input></td>
				<td><span><fo:errors path="availableSeats"/></span> </td>
			</tr>
			<tr>
				<td>Theatre:</td>
				<td><fo:select path="theatre" name="Theatre Id">   
						<c:forEach items="${theatreDataList}" var="movie">
							<option value="${theatre.theatreId}">${theatre.theatreName}</option> 
						</c:forEach>
					</fo:select>>
				</td>
			</tr>
			<tr>
				<td>Movie</td>
				<td><fo:select path="movie" name="Movie Id">   
						<c:forEach items="${movieDataList}" var="movie">
							<option value="${movie.movieId}">${movie.movieName}</option> 
						</c:forEach>
					</fo:select>>
				</td>
			</tr>
			
			<tr>
				<td>
					<input type="submit" value="Add Show">
				</td>
			</tr>
		</fo:form>
	</table>
</body>
</html>