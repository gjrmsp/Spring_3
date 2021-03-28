<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<c:import url="../template/bootStrap.jsp"></c:import>
<title>BankBook</title>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<h1>BankBook List</h1>

	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Rate</th>
				<th>Sale</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td><a href="bankbookSelect?booknumber=${dto.booknumber}">${dto.bookname}</a></td>
					<td>${dto.bookrate}</td>
					<td>${dto.booksale}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>