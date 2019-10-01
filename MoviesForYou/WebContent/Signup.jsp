<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="fo" uri="http://www.springframework.org/tags/form" %>    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>	
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="border:3px; border-style:solid; border-color:#FF1111; padding: 1em;">
<img src="<c:url value='/resources/img.jpg'/>" />
Add Product

<table border="20" BORDERCOLOR=BLUE style="background-color: yellow;">
<fo:form action="pagesubmit"  method="post" modelAttribute="myForm">
<tr>
<td>Id</td>
<td><fo:input path="customerId"/></td>
<td><span><fo:errors path="customerId"></fo:errors></span></td>
</tr>
<tr>
<td>Name</td>
<td><fo:input path="customerName"/></td>
<td><span><fo:errors path="customerName"></fo:errors></span></td>
</tr>
<tr>
<td> Phone Number</td>
<td><fo:input path="customerPhone"/></td>
<td><span><fo:errors path="customerPhone"></fo:errors></span></td>
</tr>
<tr>
<td>Password</td>
<td><fo:input path="customerPassword"/></td>
<td><span><fo:errors path="customerPassword"></fo:errors></span></td>
</tr>


</fo:form>
</table>

</body>
</html>