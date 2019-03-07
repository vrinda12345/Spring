<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
.error {
	color: red;
	font: weigth:bold;
}
</style>
</head>
<body>
	<div align="center">
		<form action="associateDetails" method="post">
			<h2>Enroll associate Details here</h2>
			<table>
				<tr>
					<td>Associate Id</td>
					<td><input type="text" name="associatedId"></td>
					<td><input type="submit" value="Click"></td>
					<td><a href="index">Home</a></td>
				</tr>
			</table>
		</form>
	</div>
	<div align="center" class="error">${errorMessage}</div>
	<br>
	<br>
	<div align="center">
		<table>
			<tr>
				<th>Associate Id</th>
				<th>FirstName</th>
				<th>LastName</th>
				<th>EmailId</th>
			</tr>
			<tr>
				<th>${associate.associatedId}</th>
				<th>${associate.firstName}</th>
				<th>${associate.lastName}</th>
				<th>${associate.emailId}</th>
			</tr>
		</table>
	</div>
</body>
</html>