<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html lang="en-US">

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
			<ul id="nav-mobile" class="centre hide-on-med-and-down">
				
				<li><a href="#">movies4u</a></li>
			</ul>
			<ul id="nav-mobile" class="right hide-on-med-and-down">
				
				<li><a href="#">Sign Up</a></li>
			</ul>
		</div>
	</nav>
	
	

	 <div class="container">
	 	<div class="row">
	 		<div class="card col s4 offset-s4 center">
	 			<form:form action="userLogin" method="GET">
	 			<div class="row">
	 				<h4>Log In</h4>
	 				<div class="input-field col s12">
          				<input id="user_name" type="text" class="validate" name="user_name">
          				<label for="first_name">User Name</label>
       				 </div>
       				 <div class="input-field col s12">
         				 <input id="password" type="password" class="validate" name="user_password">
         				 <label for="password">Password</label>
        			</div>
        			
	 			</div>
	 			<input type="submit" value="Login" class="waves-effect waves-light btn-small"></input>
	 			</form:form>
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
	
    <script>
    </script>
</body>

</html>