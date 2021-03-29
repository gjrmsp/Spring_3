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
	<h1>Notice List</h1>
	<div class="container">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성 날짜</th>
					<th>조회 수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="dto">
					<tr>
						<td>${dto.num}</td>
						<td><a href="./noticeSelect?num=${dto.num}">${dto.title}</a></td>
						<td>${dto.writer}</td>
						<td>${dto.regdate}</td>
						<td>${dto.hit}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<br>
	<c:if test="${member.id eq 'admin'}">
		<a href="../notice/noticeInsert">작성</a>
	</c:if>
</body>
</html>