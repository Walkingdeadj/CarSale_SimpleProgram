<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buyer List</title>
</head>
<body>
<body>
	<h1 style="font-size:40px"> Car Buyers </h1>
	<h2 style="font-size:25px"> Choose a buyer, then select an operation to do to that buyer </h2>

	<form method = "post" action = "navigationServlet">	
	<table border="2">
	<tr><td>ID</td><td>Name</td><td>Phone Number</td></tr>
	<c:forEach items="${requestScope.allBuyers}" var="currentBuyer">
	<tr>
 	<td><input type = "radio" name ="id" value = "${currentBuyer.id}"></td>
 	<td>${currentBuyer.buyerName}</td>
 	<td>${currentBuyer.buyerPNum}</td>
 	</tr>
	</c:forEach>
	</table>
	<input type = "submit" value = "editBuyer" name="doThisToCar">
	<input type = "submit" value = "deleteBuyer" name="doThisToCar">
	<input type = "submit" value = "addBuyer" name = "doThisToCar">
	</form>
	
		<a href = "viewAllCarsServlet">View the complete list of cars</a>
	<a href = "viewAllBuyersServlet">View the complete list buyers</a>
	<a href = "viewAllSalesServlet">View all car sales</a>
</body>
</body>
</html>