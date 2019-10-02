<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
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
				<td><input type="text" name="bookingId" /></td>
			</tr>
				<tr>
				<td><input type="submit" value="Cancel Booking"></input></td>
			</tr>
		</table>
	</form>
</body>
</html>