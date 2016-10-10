<%@page import="com.supinfo.sun.supcommerce.bo.SupProduct"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product detail</title>
</head>
<body>
<%@ include file="header.jsp" %>

<%SupProduct p = (SupProduct) request.getAttribute("product"); %>

<h2>Product detail</h2>
	<table>
		<tr>
			<td>Product ID :</td>
			<td><%= p.getId() %></td>
		</tr>
		<tr>
			<td>Product Name :</td>
			<td><%= p.getName() %></td>
		</tr>
		<tr>
			<td>Product Content :</td>
			<td><%= p.getContent() %></td>
		</tr>
		<tr>
			<td>Product Price :</td>
			<td><%= p.getPrice() %></td>
		</tr>
	</table>
</body>
</html>