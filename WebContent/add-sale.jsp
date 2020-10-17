<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add A Sale</title>
</head>
<body>
<h1>Add A Car Sale</h1>
<h2>choose a car, buyer, date, and price</h2>
<form method = "post" action = "addSaleServlet">
	<h4>Choose A Car</h4>	
	<table border="1">
	<tr><td>ID</td><td>Model</td><td>Make</td></tr>
	<c:forEach items="${requestScope.allCars}" var="currentcar">
	<tr>
 	<td><input type = "radio" name ="CarId" value = "${currentcar.id}"></td>
 	<td>${currentcar.model}</td>
 	<td>${currentcar.make}</td>
 	</tr>
 	</c:forEach>
 	</table> 	
 	<br>
 	<h4>Choose a Car Buyer</h4>
 	<table border="1">
	<tr><td>ID</td><td>Name</td><td>Phone Number</td></tr>
	<c:forEach items="${requestScope.allBuyers}" var="currentBuyer">
	<tr>
 	<td><input type = "radio" name ="BuyerId" value = "${currentBuyer.id}"></td>
 	<td>${currentBuyer.buyerName}</td>
 	<td>${currentBuyer.buyerPNum}</td>
 	</tr>
	</c:forEach>
	</table>
	Date: <input type ="text" name = "moth" placeholder="mm"size="2">
	<input type ="text" name = "day"placeholder="dd" size="2">
	<input type ="text" name= "year" placeholder="yyyy" size="4"><br>
	Price: <input type = "text" name = "price">
	<input type = "submit" value = "addSale">
	</form>
</body>
</html>