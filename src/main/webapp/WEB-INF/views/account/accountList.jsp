<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Account List Page</h1>

	<table>
		<thead>
			<tr>
				<th>Number</th>
				<th>Balance</th>
				<th>Date</th>
				<th>ID</th>
				<th>Booknumber</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="account">
				<tr>
					<td>${account.accountnumber}</td>
					<td>${account.accountbalance}</td>
					<td>${account.accountdate}</td>
					<td>${account.id}</td>
					<td>${account.booknumber}</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>