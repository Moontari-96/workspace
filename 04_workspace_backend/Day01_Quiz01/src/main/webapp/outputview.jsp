<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Message List</title>
</head>
<body>
	
	<table border="1" align="center">
	    <thead>
	      <tr>
	        <th colspan="4">Movies</th>
	      </tr>
	    </thead>
	    <tbody>
	      <tr>
	        <th>ID</th>
	        <th>Title</th>
	        <th>Genre</th>
	        <th>Date</th>
	      </tr>
	      <c:forEach var="dto" items="${list}">
	      	<tr>
	      		<td>${dto.id}</td>
	      		<td>${dto.title}</td>
	      		<td>${dto.genre}</td>
	      		<td>${dto.write_date}</td>
	      	</tr>
	      </c:forEach>
	      <tr>
	        <td colspan="4">
	          <form action="/DeleteServlet">
	            <input type="text" id="delinp" name="delInp">
	            <button id="delBtn" name="delBtn">Delete</button>
	          </form>
	        </td>
	      </tr>
	      <tr>
	        <td colspan="4">
	          <form action="/UpdateServlet">
	            <input type="text" id="upID" name="upID">
	            <br>
	            <input type="text" id="upTitle" name="upTitle">
	            <br>
	            <input type="text" id="upGenre" name="upGenre">
	            <br>
	            <input type="text" id="upDate" name="upDate">
	            <br>
	            <button id="upBtn">Update</button>
	          </form>
	          </td>
	      </tr>
	      <tr>
	        <th colspan="4">
	          <button id="backBtn">Back</button>
	         </th>
	      </tr>
	    </tbody>
  </table>
  <script>
    document.getElementById('backBtn').addEventListener('click',function () {
      location.href = './index.html'
    })
  </script>
</body>
</html>