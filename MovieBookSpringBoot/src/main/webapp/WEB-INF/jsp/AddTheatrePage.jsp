<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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
				<table>
					<thead>
						<tr>
							<th>Add Theatre</th>
						</tr>
					</thead>

					<fo:form action="addTheatreToDatabase" method="post"
						modelAttribute="myTheatreForm">
						<tr>
							<td>Theatre Name</td>
							<td><fo:input path="theatreName" /></td>
							<td><span><fo:errors path="theatreName" /></span></td>
						</tr>
						<tr>
							<td>Theatre City</td>
							<td><fo:select path="cityName" items="${cityDataItem}" /></td>
						</tr>
						<tr>
							<td>Pincode</td>
							<td><fo:input path="cityPincode" /></td>
							<td><span><fo:errors path="cityPincode" /></span></td>
						</tr>
						<tr>
							<td><input type="submit" value="Add Theatre"
								class="waves-effect waves-light btn-small"></td>
						</tr>
					</fo:form>
				</table>
	
</body>
</html>