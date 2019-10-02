<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@taglib prefix="fo" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body> Log In Page

	<table>
		<fo:form action="validateLogInFromDatabase" method="post">
			<tr>
				<td>Enter User Name</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="Log In">
				</td>
			</tr>
		</fo:form>
	</table>

</body>
</html>