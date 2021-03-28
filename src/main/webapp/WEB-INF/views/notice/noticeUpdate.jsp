<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Notice Update</h1>
	
	<form action="./noticeUpdate" method="post">
		<input type="hidden" name="num" value="${dto.num}"><br>
		제목 <input type="text" name="title" value="${dto.title}"><br>
		작성자 <input type="text" readonly="readonly" value="${dto.writer}"><br>
		내용 <input type="text" style="width:200px;height:100px;" name="contents" value="${dto.contents}"></input><br>
		<input type="hidden" name="regdate" value="${dto.regdate}"><br>
		<input type="hidden" name="hit" value="${dto.hit}"><br>
		<button>Update</button>
	</form>
</body>
</html>