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
<h2>List all products</h2>
<ul>
	<%
		List<SupProduct> list = (List<SupProduct>) request.getAttribute("productsList");
		for(SupProduct p : list)
		{
			%>
			<li>
			<%= p.getId() %> <%= p.getName()%> <%= p.getPrice() %>			
			</li>
			<%			
		}
	%>

</ul>
</body>
</html>