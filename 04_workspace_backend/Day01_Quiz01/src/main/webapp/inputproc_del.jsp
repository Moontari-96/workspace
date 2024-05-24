<%@page import="dto.MovieDTO"%>
<%@page import="dao.MovieDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- JSP내에는 자바코드 작성이 가능함 -->
	<% 
		/* 과거문법 */
		/* Scriptlet 문법 */
		System.out.println("CD");
		/* /_jspService안에 코드작성됌 */
		String title = request.getParameter("movieName");
		String genre = request.getParameter("movieGenre");
		
		MovieDAO dao = MovieDAO.getInstance();
		dao.insertMovie(new MovieDTO(0,title,genre,null));
		System.out.println(title + " : " + genre);
	%>
	Input Success <button id ="ok">OK</button>
	<script>
		document.getElementById("ok").onclick = function(){
			location.href = "index.html";
		}
	</script>
	<!-- * EL ( Expression Language ) : JSP 내에서 java의 문법이 아닌 새로운 문법으로 자바 값을 사용하는 방법 -->
	<%-- $ <br> <!-- request.getAttribute("int"); -->
	
	--%>
	${movie.title}<br> <!-- movie.getTitle(); -->
	${movie.genre}<br> 
	${list[0].id}<br>

	<c:if test="${param1 != 10}">
		Param1 값은 10 입니다.
	</c:if>
	
	<br>
	
	<c:choose>
		<c:when test="${param2 eq 'Hello' }">
			<!-- if -->
			<!-- eq는 equals랑 같은 의미 -->
			Param2 값은 "Hello" 입니다.
		</c:when>
		<c:when test="${param2 eq 'Hello JSP' }">
			<!-- if -->
			Param2 값은 "Hello JSP" 입니다.
		</c:when>
		<c:otherwise> 
			<!-- else -->
			Param2 값은 임의의 텍스트 입니다.
		</c:otherwise>
	</c:choose> 
	
	<br>
	<br>
	<c:forEach var="fruit" items="${fruits}">
		Foreach : ${fruit}<br>
	</c:forEach>
	<br>
	<br>
	<c:forEach var="dto" items="${list}">
		${dto.title} : ${dto.genre}<br>
	</c:forEach>
</body>
</html>