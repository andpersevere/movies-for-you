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

<body background="<c:url value='/resources/movies6.jpg'/>" style="background-size: 100% 150%;background-repeat: no-repeat;">

	<nav>
		<div class="nav-wrapper red darken-4">
			<a href="home" class="brand-logo right">movies4u</a>
			<ul id="nav-mobile" class="left hide-on-med-and-down">

				<li><a href="signUpPage">Sign Up</a></li>
			</ul>
		</div>
	</nav>



	<div class="container">
		<div class="row">
			<div class="card col s4 offset-s4 center">

		
				<fo:form action="addCustomerToDatabase" method="post"
					modelAttribute="myCustomerForm">
						<table class="striped">
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
</table>
				</fo:form>
			
	
			</div>
		</div>
	</div>
	<footer class="page-footer red darken-4">
          <div class="container"></div>
          <div class="footer-copyright red darken-4">
            <div class="container">
            © 2019 Movie Booking System
            
            </div>
          </div>
        </footer>
</body>
</html>