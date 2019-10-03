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
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="ViewBookingPage.jsp"></jsp:include>
We allow you to cancel your booking! WE'LL THINK ABOUT REFUND!!
<form action="CancelBookingSubmit" method="POST">
		<table>
			<tr>
				<td>Booking Id:</td>
				<td><input name="bookingId" /></td>
			</tr>
				<tr>
				<td><input type="submit" value="Cancel Booking"></input></td>
			</tr>
		</table>
	</form>
</body>
<% } %>
</html>