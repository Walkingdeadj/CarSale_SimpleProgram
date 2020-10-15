<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="font-size:40px"> Car's file </h1>
	<h2 style="font-size:25px"> Please choose the option to change car's information </h2>
	<h3 style="color:red" style="font-size:10px"> Select car first then do the operation </h3>

	<form method = "post" action = "navigationServlet">	
	<table border="1">
	<tr><td>Sale ID</td><td>Car ID</td><td>Buyer ID</td><td>Sale Date</td> <td>Price</td></tr>
	<c:forEach items="${requestScope.allSales}" var="currentSale">
	<tr>
 	<td><input type = "radio" name ="id" value = "${currentSale.id}"></td>
 	<td>${currentSale.car.id}</td>
 	<td>${currentSale.buyer.id}</td>
 	<td>${currentSale.saleDate}</td>
 	<td>${currentSale.price}</td>
 	 	
 	</tr>
	</c:forEach>
	</table>
	<input type = "submit" value = "deleteSale" name="doThisToCar">
	<input type = "submit" value = "addSalle" name = "doThisToCar">
	</form>
</body>
</html>