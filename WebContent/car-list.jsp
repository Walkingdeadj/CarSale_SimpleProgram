<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Car List</title>
</head>
<body>
	<h1 style="font-size:40px"> Car's Information </h1>
	<h2 style="font-size:25px"> Please choose the option to change car's information </h2>
	<h3 style="color:red" style="font-size:10px"> Select car first then do the operation </h3>

	<form method = "post" action = "navigationServlet">	
	<table border="1">
	<c:forEach items="${requestScope.allCars}" var="currentcar">
	<tr>
 	<td><input type = "radio" name ="id" value = "${currentcar.id}"></td>
 	<td>${currentcar.model}</td>
 	<td>${currentcar.make}</td>
 	</tr>
	</c:forEach>
	</table>
	<input type = "submit" value = "edit" name="doThisToCar">
	<input type = "submit" value = "delete" name="doThisToCar">
	<input type = "submit" value = "add" name = "doThisToCar">
	</form>
	
	<a href = "viewAllCarsServlet">View the complete list of cars</a>
	<a href = "viewAllBuyersServlet">View the complete list buyers</a>
	<a href = "viewAllSalesServlet">View all car sales</a>
</body>
</html>