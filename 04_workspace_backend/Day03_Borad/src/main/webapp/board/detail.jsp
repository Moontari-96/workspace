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

    .container {
      background-color: #fff;
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      width: 90%;
      max-width: 800px;
    }

    h1,
    h2,
    h3 {
      text-align: center;
    }

    .post_detail {
      margin-bottom: 30px;
    }

    .post_header {
      border-bottom: 1px solid #dee2e6;
      padding-bottom: 10px;
      margin-bottom: 20px;
    }

    .post_meta {
      color: #6c757d;
      margin-bottom:20px;
    }

    .post_content {
      white-space: pre-wrap;
    }
    
    .post_header form {
    	float: right;
    	padding-bottom: 10px;
    	margin-bottom: 20px;
    }
    .post_header button{
      padding: 5px 10px;
      background-color: #ff4040;
      color: white;
      border: none;
      border-radius: 4px;
      font-size: 16px;
      cursor: pointer;
      transition: background-color 0.3s;
    }
    .post_header .update_box {
		display:none;
    }
    .comments_section {
      margin-top: 30px;
    }

    .comment_form {
      display: flex;
      flex-direction: column;
    }

    .comment_form #comment {
      width: 100%;
      height: 100px;
      padding: 10px;
      border: 1px solid #dee2e6;
      border-radius: 4px;
      font-size: 16px;
      margin-bottom: 10px;
    }

    .comment_form button {
      align-self: flex-end;
      padding: 10px 20px;
      background-color: #007bff;
      color: white;
      border: none;
      border-radius: 4px;
      font-size: 16px;
      cursor: pointer;
      transition: background-color 0.3s;
    }

    .comment_form button:hover {
      background-color: #0056b3;
    }

    .comments .comment {
      border-bottom: 1px solid #dee2e6;
      padding: 10px 0;
    }

    .comments .comment:last-child {
      border-bottom: none;
    }

    .no_comments {
      text-align: center;
      color: #6c757d;
    }
	
</style>
</head>
<body>
 <div class="container">
    <div class="post_detail">
      <div class="post_header">
        <h2 id="post_title">
        제목: <span id="modifyTitle">${dto.title}</span>
        	
        </h2>
        <div class="post_meta">
          <span id="post_author">작성자: ${dto.writer}</span> |
          <span id="post_date">작성일: <fmt:formatDate value="${dto.write_date}" pattern="yyyy.MM.dd" /></span> |
          <span id="post_views">조회수: ${dto.view_count}</span>
         
          <c:choose>
          <c:when test="${dto.writer eq loginID}">
  	        <form action="/update.board?seq=${dto.seq}" method="post">
			    <div class="update_box">
			      <input type="hidden" name="title" id="hiddentitle" value="${dto.title}">
			      <input type="hidden" name="content" id="hiddenContent" value="${dto.contents}">
			      <button id="updateBtn">수정 완료</button>
			      <button id="cancleBtn" type="button">취소</button>
			    </div>
			    <div class="modi_box">
			      <button id="modifyBtn" type="button">게시글 수정</button>
			      <button id="deleteBtn" type="button">게시글 삭제</button>
			      <button id="listBtn" type="button">목록으로</button>
			    </div>
  			</form>
  	        <script>
  	        	$('#listBtn').on("click",function(){
  	        		location.href="/list.board";
  	        	})
  	        	$('#cancleBtn').on("click",function(){
  	        		location.reload();
  	        	})
  	        	$("#deleteBtn").on("click",function(){
  	        		let result = confirm("정말 삭제하시겠습니까?");
  	        		if(result) {
  	        			location.href="/delete.board?seq=${dto.seq}";
  	        		}
  	        	})
  	        	$("#modifyBtn").on("click",function(){
  	        		let result = confirm("수정하시겠습니까?");
  	        		if(result) {
  	        			let modifyContent = $("#post-content");
  	        			let modifyTitle = $("#modifyTitle");
  	        			
  	        			modifyContent.attr("contenteditable" , true);
  	        			modifyTitle.attr("contenteditable" , true);
  	        			modifyTitle.focus();
  	        			$(".modi_box").css("display","none");
  	        			$(".update_box").css("display","inline-block");
  	        		}
  	        	})
  	        	$("#updateBtn").on("click",function(){
  	        		let result = confirm("수정하시겠습니까?");
  	        		if(result) {
  	        			let modifyContent = $("#post-content");
  	        			let modifyTitle = $("#modifyTitle");
  	        			let contentval = $("#hiddenContent");
  	        			let titleval = $("#hiddentitle");
  	        			modifyContent.attr("contenteditable" , true);
  	        			modifyTitle.attr("contenteditable" , true);
  	        			contentval.val(modifyContent.html());
  	        			titleval.val(modifyTitle.html());
  	        			$(".update_box").css("display","none");
  	        			$(".modi_box").css("display","inline-block");
  	        		}
  	        	})
  	        </script>
          </c:when>
          <c:otherwise>
           	<button id="listBtn" type="button">목록으로</button>
          </c:otherwise>
          </c:choose>
          
        </div>
      </div>
      <div class="post_content" id="post-content">
        ${dto.contents}
      </div>
    </div>
    <div class="comments_section">
      <h3>댓글</h3>
      <div class="comments" id="comments">
        <!-- 댓글이 동적으로 추가될 부분 -->
        <p class="no_comments">댓글이 없습니다.</p>
      </div>
      <div class="comment_form">
        <div id="comment" placeholder="댓글을 입력하세요..." contenteditable="true"></div>
        <button id="submitComment">댓글 작성</button>
      </div>
    </div>
  </div>
  <script>
  $('#listBtn').on("click",function(){
		location.href="/list.board";
	})
  </script>
</body>
</html>