<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Car Buyer</title>
</head>
<body>
<h1 style="color:blue" style="font-size:40px">Add a car buyer to the database</h1>
	<p style="font-size:25px">Type in buyer information in the blanks</p>
	<form action = "addBuyerServlet" method="post">
	Name: <input type ="text" name = "name">
	Phone Number (###-###-####): <input type = "text" name = "pNum">
	<input type = "submit" value="Add Buyer's Information in system">
	</form> <br />
	<a href = "viewAllCarsServlet">View the complete list of cars</a>
	<a href = "viewAllBuyersServlet">View the complete list buyers</a>
</body>
</html>