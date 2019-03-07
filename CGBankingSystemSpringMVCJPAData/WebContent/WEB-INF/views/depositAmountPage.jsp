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
	<form action="depositAmount" method="post" name="depositForm">
	<table>
		<tr>
			<th>Account No:</th>
			<td><input type="text" name="accountNo"> 
		</tr>
		<tr>
			<th>Deposit Amount:</th>
			<td><input type="text" name="amount"> 
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