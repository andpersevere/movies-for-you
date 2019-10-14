<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<body background="<c:url value='/resources/movies6.jpg'/>" style="background-size: 100% 150%;background-repeat: no-repeat;">

	<nav>
		<div class="nav-wrapper red darken-4">
			<a href="home" class="brand-logo right">movies4u</a>
		
		</div>
	</nav>
	<form action="#">
    <div class="file-field input-field">
      <div class="btn">
        <span>File</span>
        <input type="file">
      </div>
      <div class="file-path-wrapper">
        <input class="file-path validate" type="text">
      </div>
    </div>
  </form>
	<div class="container">
		<div class="row">
			<div class="card col s4 offset-s4 center">

		
				<fo:form action="addTheatreToDatabase" method="post"
					modelAttribute="myTheatreForm" id="addtheatreform">
				<table class="striped">
					
				
						<tr>
							<td>Theatre Name</td>
							<td><fo:input path="theatreName" id="form_theatre_name" /></td>
							<td><span class="form_error" id="theatrename_error_message" style="color:red;"></span></td>
						</tr>
						<tr>
							<td>Theatre City</td>
							<td><fo:input path="cityName"/></td>
						</tr>
						<tr>
							<td>Pincode</td>
							<td><fo:input path="cityPincode" id="form_theatre_citypincode" /></td>
							<td><span class="form_error" id="citypincode_error_message" style="color:red;"></span></td>
						</tr>
						<tr>
							<td><input type="submit" value="Add Theatre"
								class="waves-effect waves-light btn-small"></td>
						</tr>
						
						</table>
					</fo:form>
				
		</div>
		</div>
	</div>
	<span style="color:red;"> ${error }</span>
					<span > ${message }</span>
	<footer class="page-footer red darken-4">
          <div class="container"></div>
          <div class="footer-copyright red darken-4">
            <div class="container">
            © 2019 Movie Booking System
            
            </div>
          </div>
        </footer>	
</body>
<script type="text/javascript">
$(function(){
	$("#citypincode_error_message").hide();
	$("#theatrename_error_message").hide();
	var error_citypincode=false;
	var error_theatrename=false;
	$("#form_theatre_citypincode").keyup(function(){
		check_citypincode();
	});
	$("#form_theatre_name").keyup(function(){
		check_theatrename();
	});
	function check_citypincode()
	{
		var pattern=/^[0-9]*$/;
		var citypincode=$("#form_theatre_citypincode").val();
		if(pattern.test(citypincode) && citypincode!=='')
			{
			$("#citypincode_error_message").hide();
			$("#form_theatre_citypincode").css("border-bottom","2px solid #34FA58");
			}
		else if(citypincode=='')
			{
			$("#citypincode_error_message").html("should not be empty");
			$("#citypincode_error_message").show();
			$("#form_theatre_citypincode").css("border-bottom","2px solid #F90A0A");
			error_citypincode=true;
			}
		else
			{
			$("#citypincode_error_message").html("should contain only numeric vaues");
			$("#citypincode_error_message").show();
			$("#form_theatre_citypincode").css("border-bottom","2px solid #F90A0A");
			error_citypincode=true;
			
			}
	}
	function check_theatrename()
	{
		var pattern=/^[a-zA-Z0-9_ ]*$/;
		var theatrename=$("#form_theatre_name").val();
		if(pattern.test(theatrename) && theatrename!=='')
			{
			$("#theatrename_error_message").hide();
			$("#form_theatre_name").css("border-bottom","2px solid #34FA58");
			}
		else if(theatrename=='')
			{
			$("#theatrename_error_message").html("should not be empty");
			$("#theatrename_error_message").show();
			$("#form_theatre_name").css("border-bottom","2px solid #F90A0A");
			error_theatrename=true;
			}
		else
			{
			$("#theatrename_error_message").html("should contain string");
			$("#theatrename_error_message").show();
			$("#form_theatre_name").css("border-bottom","2px solid #F90A0A");
			error_theatrename=true;
			
			}
	}
	$("#addtheatreform").submit(function(){
		 error_citypincode=false;
		 error_theatrename=false;
		 check_citypincode();
		 check_theatrename();
		 if(error_citypincode===false && error_theatrename===false)
			 {
			 	//alert("Added theatre successfully");
			 	return true;
			 }
		 else
			 {
			// alert("Please fill the form correctly");
			 return false;
			 }
		
	});
	
	
	
});
</script>
</html>