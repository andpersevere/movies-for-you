<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
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


<body background="<c:url value='/resources/movies6.jpg'/>" style="background-size: 100% 1500%;background-repeat: no-repeat;">
<nav>
		<div class="nav-wrapper red darken-4">
			Welcome Admin
			 <%out.print(session.getAttribute("username"));%>
			<ul id="nav-mobile" class="left hide-on-med-and-down">
				<li><a href="addShowPage_1">Add Show Page</a>
				<li><a href="addTheatrePage">Add Theatre Page</a></li>
				<li><a href="addMoviePage">Add Movie Page</a></li>
				<li><a href="showCustomerPage">Show Customers</a></li>
				<li><a href="showMoviePage">Show Movies</a></li>
				<li><a href="showTheatrePage">Show Theatres</a></li>
				<li><a href="showShowPage">Display Shows</a></li>
				<li><a href="RemoveMoviePage">Remove Movie</a></li>
				<li><a href="logOutPage">Log Out</a></li>
			</ul>
		</div>
		</nav>
		
		<footer class="page-footer red darken-4">
          <div class="container"></div>
          <div class="footer-copyright red darken-4">
            <div class="container">
            © 2019 Movie Booking System
            
            </div>
          </div>
        </footer>
	</nav>
</body>
</html>