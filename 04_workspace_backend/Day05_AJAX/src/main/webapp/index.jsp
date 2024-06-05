<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
	<!-- AJAX ( Asynchronous JavaScript And XML ) -->
	<!-- 페이지 전환 또는 데이터 통신 방법 -->
	<!-- Anchor / location.href / form submit / window.open -->
	<!-- 페이지 전환 없이 데이터 Request 및 Response 하는 기술 - AJAX -->
	<fieldset>
		<legend>단순 요청</legend>
		<button id="ajax01">단순 요청</button>
	</fieldset>
	
	<script>
		$("#ajax01").on("click",function(){
			$.ajax({
				url:"/exam01.ajax"
			});
		})
	</script>
	
	<hr>
	
	<fieldset>
		<legend>파라미터 전달 요청</legend>
		<button id="ajax02">TEST</button>
	</fieldset>
	<script>
		$("#ajax02").on("click",function(){
			$.ajax({
				url:"/exam02.ajax",
				type: "post",			// 보내는 방식 type으로 작성
				data:{
					key1:"Apple",		// input type=text name=key1 value="Apple"
					key2:"Orange"
				}
			});
		})
	</script>
	
	<hr>
	
	<fieldset>
		<legend>응답 받아보기</legend>
		<button id="ajax03">TEST</button>
	</fieldset>
	<script>
		$("#ajax03").on("click",function(){
			$.ajax({
				url:"/exam03.ajax"
			}).done(function(resp){
				// 서버로부터 정상적 응답이 돌아왔을 때 실행되는 callback
				// 서버의 응답 데이터는 callback의 매개변수로 전달 됨.
				
				console.log(resp);
			});
		});
	</script>
	<hr>
	
	<fieldset>
		<legend>배열 데이터 응답 받아보기</legend>
		<button id="ajax04">TEST</button>
	</fieldset>
	<script>
		$("#ajax04").on("click",function(){
			$.ajax({
				url:"/exam04.ajax"
			}).done(function(resp){
				console.log(resp)
				let fruits = JSON.parse(resp)
				console.log(fruits[0]);
			});
		});
	</script>
	<hr>
	
	<fieldset>
		<legend>객체 데이터 응답 받아보기</legend>
		<button id="ajax05">TEST</button>
	</fieldset>
	<script>
		$("#ajax05").on("click",function(){
			$.ajax({
				url:"/exam05.ajax",
				dataType:"json", // 역직렬화 선언 (let movie = JSON.parse(resp))와 같은 의미
			}).done(function(resp){
				console.log(resp)
			});
		});
	</script>
	<hr>
	
	<fieldset>
		<legend>객체 배열 응답 받아보기</legend>
		<button id="ajax06">TEST</button>
	</fieldset>
	<script>
		$("#ajax06").on("click",function(){
			$.ajax({
				url:"/exam06.ajax",
				dataType:"json", // 역직렬화 선언 (let movie = JSON.parse(resp))와 같은 의미
			}).done(function(resp){
				console.log(resp)
			});
		});
	</script>
	<hr>
	
	<fieldset>
		<legend>임의 객체응답 받아보기</legend>
		<button id="ajax07">TEST</button>
	</fieldset>
	<script>
		$("#ajax07").on("click",function(){
			$.ajax({
				url:"/exam07.ajax",
				dataType:"json", // 역직렬화 선언 (let movie = JSON.parse(resp))와 같은 의미
			}).done(function(resp){
				console.log(resp)
			});
		});
	</script>
</body>
</html>