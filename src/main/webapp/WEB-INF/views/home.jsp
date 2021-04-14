<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<c:import url="./template/bootStrap.jsp"></c:import>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e82ee4c5e0891511187124e83dd83282"></script>
<link rel="stylesheet" href="./resources/css/test.css">
<title>Home</title>
<style type="text/css">
#d1 {
	width: 200px;
	height: 200px;
	background-color: red;
	overflow: hidden;
}

#d2 {
	width: 50px;
	height: 50px;
	background-color: yellow;
	margin: 75px auto;
}
</style>
</head>
<body>
	<c:import url="./template/header.jsp"></c:import>

	<button class="b" id="btn1">BUTTON</button>
	<button id="btn" class="b">CLICK</button>
	<button id="btn2" class="b">CLICK2</button>
	<input type="text" id="num">
	<h1 id="t">version 3</h1>
	<ol id="result">
		<li>A</li>
	</ol>
	<select id="mon"></select>

	<div id="d1">
		<div id="d2">
			<h3 id="d3"></h3>
			<h3 id="d4"></h3>
		</div>
	</div>

	<div id="exchange">
		<h3 id="krw"></h3>
		<h3 id="usd"></h3>
	</div>

	<div id="map" style="width: 500px; height: 400px;"></div>

	<script type="text/javascript">
		getMap(33.450701, 126.570667);
		
		function getMap(lat, lng) {
			var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
			var options = { //지도를 생성할 때 필요한 기본 옵션
				center: new kakao.maps.LatLng(lat, lng), //지도의 중심 좌표
				level: 3 //지도의 레벨(확대, 축소 정도)
			};
			var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
		}
		
		$("#btn1").click(function() {
			$.get("https://jsonplaceholder.typicode.com/users", function(data) {
				console.log(data);
				
				for(index of data){
					console.log(index.company.name);
				}
				
				//첫번째 유저의 내용 중
				console.log(data[0].address.geo.lat);
				console.log(data[0].address.geo.lng);
				let t = parseFloat(data[0].address.geo.lat);
				let n = parseFloat(data[0].address.geo.lng);
				getMap(t, n);
			});
		});
		
		$("#btn").click(function() {
			$.ajax({
				type: "GET",
				url : "https://api.manana.kr/exchange/price.json",
				data: {
					base: "KRW",
					price: 1500, 
					code:"KRW,USD,JPY"
				},
				success:function(data) {
					console.log(data);
					$("#krw").html(data.KRW);
					$("#usd").html(data.USD);
				}
			});
		});

			$("#btn2").click(function() {
				let num = $("#num").val();
				
				$.get("https://jsonplaceholder.typicode.com/posts/"+num, function(data) {
					console.log(data);
					$("#d3").html(data.title);
					$("#d4").html(data.body);
				});
			});
		</script>
</body>
</html>