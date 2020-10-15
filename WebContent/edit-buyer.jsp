<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Car Buyer</title>
</head>
<body>
<h1 style="font-size:40px">Alter the buyer info</h1>
	<form action = "editBuyerServlet" method = "post">
	Name: <input type = "text" name = "name" value = "${buyerToEit.buyerName}">
	Number: <input type = "text" name = "pNum" value = "${buyerToEit.buyerPNum}">
	<input type = "hidden" name = "id" value = "${buyerToEit.id}">
	<input type = "submit" value = "Save Edited Buyer">
	
	</form>
</body>
</html>