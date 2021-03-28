<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../template/bootStrap.jsp"></c:import>
<title>Insert title here</title>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<h1>Notice Select</h1>

	<h3>Title : ${dto.title}</h3>
	<h3>Contents : ${dto.contents}</h3>

	<c:catch>
		<c:if test="${member.id eq 'admin'}">
			<a href="../notice/noticeUpdate?num=${dto.num}">수정</a>
			<a href="../notice/noticeDelete?num=${dto.num}">삭제</a>
		</c:if>
	</c:catch>
</body>
</html>