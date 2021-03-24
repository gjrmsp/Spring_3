<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook Select</h1>
	
	<h3>Name : ${dto.bookname}</h3>
	<h3>Number : ${dto.booknumber}</h3>
	
	<a href="./bankbookDelete?booknumber=${dto.booknumber}">Delete</a>
</body>
</html>