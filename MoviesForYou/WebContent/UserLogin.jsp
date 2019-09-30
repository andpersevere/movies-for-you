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
<fo:form action="loginsubmit"  method="post" modelAttribute="myLoginForm">
<tr>
<td>Enter Name</td>
<td><fo:input path="userName"/></td>
<td><span><fo:errors path="userName"></fo:errors></span></td>
</tr>
<tr>
<td>Enter Password</td>
<td><fo:input path="userPassword"/></td>
<td><span><fo:errors path="userPassword"></fo:errors></span></td>
</tr>

<tr>
<td>Online</td>
<td><fo:radiobuttons path="online" items="${radiodataitem}"/></td>
</tr>
</fo:form>
</table>

</body>
</html>