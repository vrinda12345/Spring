<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="registerAccount" method="post"
		modelAttribute="account">
		<table>
			<tr>
				<th>Account Type:</th>
				<td><form:select path="accountType">
						<form:option value="current" label="Current"></form:option>
						<form:option value="savings" label="Savings"></form:option>
					</form:select></td>
			</tr>
			<tr>
				<th>Initial Account Balance:</th>
				<td><form:input path="accountBalanace" /></td>
			</tr>
			<tr>
				<td><form:button type="submit">Submit</form:button></td>
			</tr>
		</table>
	</form:form>
</body>
</html>