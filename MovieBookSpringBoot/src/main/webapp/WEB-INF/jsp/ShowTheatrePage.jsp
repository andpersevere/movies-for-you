<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="fo" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>movies4u</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">
<script
	src=https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/js/materialize.min.js></script>


<style type="text/css">
body {
	background-color: #ffffff;
}

footer {
	position: absolute;
	bottom: 0;
	width: 100%;
}

.card {
	margin-top: 15vh;
}
</style>
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="card col s6 offset-s3 center" >
				<table border="1" class="striped">
					<thead>
						<tr>
							<th>Show Theatre</th>
						</tr>
					</thead>
					<tr>
						<th>Theatre Id</th>
						<th>Theatre Name</th>
						<th>Theatre City</th>
						<th>Theatre Pincode</th>
					</tr>
					<fo:forEach var="theatre" items="${theatreDataItem}">
						<tr>
							<td>${theatre.theatreId}</td>
							<td>${theatre.theatreName}</td>
							<td>${theatre.cityName}</td>
							<td>${theatre.cityPincode}</td>
						</tr>
					</fo:forEach>

				</table>
			</div>
		</div>
	</div>

</body>
</html>