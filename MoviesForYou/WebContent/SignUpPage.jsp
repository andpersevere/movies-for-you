<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="fo" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body> Register
<table>
<fo:form action="addCustomerToDatabase"  method="post" modelAttribute="myCustomerForm">
<tr>
<td>UserName</td>
<td><fo:input path="customerName"/></td>
<td><span><fo:errors path="customerName"></fo:errors></span></td>
</tr>
<tr>
<td> Phone Number</td>
<td><fo:input path="contactNumber"/></td>
<td><span><fo:errors path="contactNumber"></fo:errors></span></td>
</tr>
<tr>
<td>Password</td>
<td><fo:input type="password" path="customerPassword" /></td>

</tr>
<tr>
<td>
<input type="submit" value="Create Account">
</td>
</tr>
</fo:form>
</table>

</body>
</html>