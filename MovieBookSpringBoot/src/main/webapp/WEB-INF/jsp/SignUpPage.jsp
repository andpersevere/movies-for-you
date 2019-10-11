<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="fo" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>

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