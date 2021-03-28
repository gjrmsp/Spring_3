<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>내용</th>
				<th>작성 날짜</th>
				<th>조회 수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.noticenum}</td>
					<td>${dto.noticename}</td>
					<td>${dto.noticenwriter}</td>
					<td>${dto.noticecontents}</td>
					<td>${dto.noticeregdate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>