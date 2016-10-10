<%@page import="com.supinfo.sun.supcommerce.bo.SupProduct"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List all products</title>
</head>
<body>
<%@ include file="header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>List all products</h2>
<ul>
	<c:forEach items="${requestScope.productsList}" var="p">
		<li>
			<c:out value="${p.id}"/>  
			<c:out value="${p.name}"/> 
			<c:out value="${p.price}"/> 
			<a href="Auth/removeProduct?id=<c:out value="${p.id}"/>">Delete</a>
		</li>
	</c:forEach>
		
		

</ul>
</body>
</html>