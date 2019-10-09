<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="fo" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>

</head>
				<table>
					<thead>
						<tr>
							<th>Add Theatre</th>
						</tr>
					</thead>

					<fo:form action="addTheatreToDatabase" method="post"
						modelAttribute="myTheatreForm">
						<tr>
							<td>Theatre Name</td>
							<td><fo:input path="theatreName" /></td>
							<td><span><fo:errors path="theatreName" /></span></td>
						</tr>
						<tr>
							<td>Theatre City</td>
							<td><fo:select path="cityName" items="${cityDataItem}" /></td>
						</tr>
						<tr>
							<td>Pincode</td>
							<td><fo:input path="cityPincode" /></td>
							<td><span><fo:errors path="cityPincode" /></span></td>
						</tr>
						<tr>
							<td><input type="submit" value="Add Theatre"
								class="waves-effect waves-light btn-small"></td>
						</tr>
					</fo:form>
				</table>
	
</body>
</html>