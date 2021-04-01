<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootStrap.jsp"></c:import>
<style type="text/css">
	.r1 {
		color: red;
	}
	
	.r2 {
		color: blue;
	}
</style>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>

	<div class="container mt-2">
		<h2 class="mt-4">Member Join Page</h2>
		<form action="./memberJoin" method="post">
			<div class="form-group">
				<label for="id">ID</label> <input type="text" class="form-control"
					id="id" name="id">
				<h4 id="idResult"></h4>
				<!-- ID는 6글자 이상 -->
			</div>
			<div class="form-group">
				<label for="pw">Password</label> <input type="password"
					class="form-control" id="pw" name="pw">
				<h4 id="pwResult"></h4>
					<!-- PW는 8글자 이상 -->
			</div>
			<div class="form-group">
				<label for="pw">Password</label> <input type="password"
					class="form-control" id="pw2" name="pw">
					<!-- PW 두 개는 일치 -->
			</div>
			<div class="form-group">
				<label for="name">Name</label> <input type="text"
					class="form-control" id="name" name="name">
					<!-- 비어 있으면 X -->
			</div>
			<div class="form-group">
				<label for="phone">Phone</label> <input type="text"
					class="form-control" id="phone" name="phone">
					<!-- 비어 있으면 X -->
			</div>
			<div class="form-group">
				<label for="email">Email</label> <input type="text"
					class="form-control" id="email" name="email">
					<!-- 비어 있으면 X -->
			</div>
			<button type="submit" class="btn btn-primary" id="check">Submit</button>
			<input type="button" value="JOIN" class="btn btn-primary">
			<input type="button" id="btn" value="EVENT" class="btn btn-primary">
		</form>
	</div>
<script type="text/javascript" src="../resources/js/memberJoin.js"></script>
</body>
</html>