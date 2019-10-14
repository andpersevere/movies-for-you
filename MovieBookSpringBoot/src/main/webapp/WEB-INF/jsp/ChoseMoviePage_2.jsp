<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="fo" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>>
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
<jsp:include page="ShowMoviePage_2.jsp"></jsp:include>
<form action="addShowPage_2" method="POST">
		<table>
			<tr>
				<td>Movie</td>
				<td><select id="movie_id" name="movie_id">
						<c:forEach items="${movieDataItem}" var="movie">
							<option value="${movie.movieId}">${movie.movieName}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr> <td><input type="submit" value="Choose Theatre"></td> |</tr>
		</table>
	</form>
</body>
</html>