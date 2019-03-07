<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="fundTransferAmount" method="post" name="fundTransferForm">
	<table>
		<tr>
			<th>Account No To:</th>
			<td><input type="text" name="accountNoTo"> 
		</tr>
		<tr>
			<th>Account No From:</th>
			<td><input type="text" name="accountNoFrom"> 
		</tr>
		<tr>
			<th>Transfer Amount:</th>
			<td><input type="text" name="transferAmount"> 
		</tr>
		<tr>
			<th>Pin Number:</th>
			<td><input type="text" name="pinNumber"> 
		</tr>
		
		<tr>
			<td><button type="submit">Submit </button></td>
		</tr>
	</table>
	</form>
	<jstl:choose>
			<jstl:when test="${account!=null}">Your Account Balance is :- ${account}</jstl:when>	
	</jstl:choose>
</body>
</html>