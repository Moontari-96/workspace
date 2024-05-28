<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border=1 align='center'>
        <tr>
          <th>ID
          <th>Writer
          <th>Message
          <th>Date
        </tr>
        <c:forEach var="dto" items="${list}">
	        <tr>
	      		<td>${dto.id}</td>
	      		<td>${dto.writer}</td>
	      		<td>${dto.message}</td>
	      		<td>${dto.write_date}</td>
	        </tr>
        </c:forEach>
        <tr>
          <td colspan="4">
            <form action="delete.msg">
              <input type="text" id="delInp" name="delInp">
              <button id="delBtn">Delete</button>
            </form>
          </td>
        </tr>
        <tr>
          <td colspan="4">
            <form action="update.msg">
              <input type="text" id="upId" name="upId"><br>
              <input type="text" id="upWriter" name="upWriter"><br>
              <input type="text" id="upMessage" name="upMessage"><br>
              <input type="text" id="upDate" name="upDate"><br>
              <button id="modiBtn">Modify</button>
            </form>
          </td>
        </tr>
	</table>
</body>
</html>