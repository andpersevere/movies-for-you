<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<%
	if (null == session.getAttribute("customerId")) {
		response.sendRedirect("LogInPage");
	} else {
		
%>
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
<jsp:include page="ViewBookingPage.jsp"></jsp:include>
We allow you to cancel your booking! WE'LL THINK ABOUT REFUND!!
<form action="CancelBookingSubmit" method="POST">
		<table>
			<tr>
				<td>Booking Id:</td>
				<td><input type="text" name="bookingId" /></td>
			</tr>
				<tr>
				<td><input type="submit" value="Cancel Booking"></input></td>
			</tr>
		</table>
	</form>
</body>
<% } %>
</html>