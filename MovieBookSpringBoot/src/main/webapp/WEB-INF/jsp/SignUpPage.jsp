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

<body>

			<table class="striped">
				<fo:form action="addCustomerToDatabase" method="post"
					modelAttribute="myCustomerForm">
					<tr>
						<td>Username</td>
						<td><fo:input path="customerName" /></td>
						
					</tr>
					<tr>
						<td>Password</td>
						<td><fo:input type="password" path="customerPassword" /></td>
						
					</tr>
					<tr>
						<td>Contact Number</td>
						<td><fo:input path="contactNumber" /></td>
					</tr>
					<tr>
						<td></td><td><input type="submit" value="Create Account"
							class="waves-effect waves-light btn-small"></td><td></td>
					</tr>

				</fo:form>
			</table>

</body>
</html>