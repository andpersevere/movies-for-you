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
<jsp:include page="ShowMoviePage_2.jsp"></jsp:include>
<form action="removeMovieFromDatabase" method="POST">
		<table>
			<tr>
				<td>Movie Id:</td>
				<td><input name="movieId" /></td>
			</tr>
				<tr>
				<td><input type="submit" value="Submit Movie"></input></td>
			</tr>
		</table>
	</form>
</body>
</html>