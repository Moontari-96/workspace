<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	  <style>
    /* 기본 스타일 */
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      background-color: #f8f9fa;
      display: flex;
      justify-content: center;
      align-items: center;
      min-height: 100vh;
    }
	a {
	  text-decoration: none;
      color: #000;
	}
    .container {
      background-color: #fff;
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      width: 90%;
      max-width: 1000px;
    }

    h1 {
      text-align: center;
      margin-bottom: 20px;
    }

    .board {
      display: grid;
      grid-template-columns: 1fr 3fr 1.5fr 2fr 1fr;
      gap: 10px;
    }

    .board_header,
    .board-item {
      display: contents;
    }

    .board_header span,
    .board-item span {
      padding: 10px;
      border-bottom: 1px solid #dee2e6;
      text-align: center;
    }

    .board_header {
      background-color: #f1f3f5;
      font-weight: bold;
    }

    .board-item:hover {
      background-color: #f8f9fa;
    }

    .no-content {
      grid-column: span 5;
      text-align: center;
      padding: 20px;
      color: #6c757d;
    }

    /* 페이지네이션 스타일 */
    .pagination {
      display: flex;
      justify-content: center;
      padding: 20px 0;
    }

    .pagination a {
      color: #007bff;
      padding: 10px 20px;
      text-decoration: none;
      transition: background-color 0.3s;
      margin: 0 5px;
      border: 1px solid #dee2e6;
      border-radius: 4px;
    }

    .pagination a:hover {
      background-color: #e9ecef;
    }

    .pagination a.active {
      background-color: #007bff;
      color: white;
      border: 1px solid #007bff;
    }

    .btn_box {
      display: flex;
      justify-content: flex-end;
      padding: 20px 0;
    }

    .btn_box button {
      color: #fff;
      padding: 10px 20px;
      text-decoration: none;
      transition: background-color 0.3s;
      margin: 0 5px;
      background-color: #007bff;
      border: 1px solid #007bff;
      border-radius: 4px;
    }

    /* 반응형 스타일 */
    @media (max-width: 600px) {
      .board {
        display: flex;
        flex-direction: column;
      }


      .board_header {
        display: flex;
        flex-direction: column;
      }

      .board-item {
        display: block;
        align-items: flex-start;
        padding: 10px 0px;
      }

      .board_header span {
        text-align: center;
      }

      .board_header span,
      .board-item span {
        border: none;
      }

      .board_header .board_id,
      .board_header .board_writer,
      .board_header .board_date,
      .board_header .board_views {
        display: none;
      }

      .board-item .board_id {
        display: none;
      }

      .board-item {
        border-bottom: 1px solid #dee2e6;
      }

      .board-item span.board_title {
        display: block;
        font-size: 16px;
        font-weight: bold;
      }

      .board-item span {
        text-align: left;
        padding: 5px 10px;
        display: inline;
        font-size: 14px;
      }

      .board-item span::before {
        content: attr(data-label);
        font-weight: bold;
        margin-right: 10px;
      }
    }
  </style>
</head>
<body>
  <div class="container">
    <h1>자유 게시판</h1>
    <div class="board" id="board">
      <div class="board_header">
        <span class="board_id">번호</span>
        <span class="board_title">제목</span>
        <span class="board_writer">작성자</span>
        <span class="board_date">날짜</span>
        <span class="board_views">조회수</span>
      </div>
      <c:forEach var="dto" items="${list}">
	      <div class="board-item">
	        <span class="board_id">${dto.seq}</span>
	        <span class="board_title"><a href="/detail.board?seq=${dto.seq}">${dto.title}</a></span>
	        <span class="board_writer">${dto.writer}</span>
	        <span class="board_date"><fmt:formatDate value="${dto.write_date}" pattern="yyyy.MM.dd" /></span>
	        <span class="board_views">${dto.view_count}</span>
	      </div>
      </c:forEach>
      <div>
    </div>
    </div>
    <div class="btn_box">
      <button class="writerBtn" type="button" id="writerBtn">작성</button>
    </div>
    <div class="pagination" id="pagination">
   	 ${navi}
    </div>
  </div>
  <script>
  
  let writerBtn = document.getElementById("writerBtn");

  writerBtn.addEventListener("click", function () {
	  location.href="/board/writing.jsp";
  });
 
  document.addEventListener("DOMContentLoaded", function () {
      let board = document.getElementById("board");
      let pagination = document.getElementById("pagination");
      let boardItem = document.getElementsByClassName("board-item");

      if (boardItem.length == 0) {
        let noContentMessage = document.createElement("div");
        noContentMessage.className = "no-content";
        noContentMessage.textContent = "표시할 내용이 없습니다.";
        board.appendChild(noContentMessage);
        // pagination.style.display = "none"; // 페이지네이션 숨기기
      }
    });
  
  </script>
</body>
</html>