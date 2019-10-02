<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="fo" uri="http://www.springframework.org/tags/form" %>
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
	<thead><tr><th>Add Movie</th></tr></thead>
	
		<fo:form action="addMovieToDatabase" method="post" modelAttribute="myMovieForm">
			<tr>
				<td>Movie Name</td>
				<td><fo:input path="movieName"/></td>
				<td><span><fo:errors path="movieName"/></span> </td>
			</tr>
			<tr>
				<td>Language</td>
				<td><fo:select path="language" items="${languageDataItem}"/></td> 
			</tr>
			<tr>
				<td>Genre</td>
				<td><fo:checkboxes path="genre" items="${genreDataItem}"/></td> 
			</tr>
			<tr>
				<td>Movie Length (Minutes)</td>
				<td><fo:input path="movieLength"/></td>
				<td><span><fo:errors path="movieLength"/></span> </td>
			</tr>
			<tr>
				<td>Director</td>
				<td><fo:input path="director"/></td>
				<td><span><fo:errors path="director"/></span> </td>
			</tr>
			<tr>
				<td>Movie Release Date</td>
				<td><fo:input path="movieReleaseDate"/></td>
  				 <td><input type="date"/></td>
			</tr>
			<tr>
			
				<td>Theatres:</td>
				<td><fo:checkboxes path="theatre" items="${theatresitem}" /></td>
				
			</tr>
			<tr>
				<td>
					<input type="submit" value="Add Movie">
				</td>
			</tr>
		</fo:form>
	</table>
	</body>
</html>