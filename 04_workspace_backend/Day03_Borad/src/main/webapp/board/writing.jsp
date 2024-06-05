<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<style>
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
      max-width: 600px;
    }

    h1 {
      text-align: center;
      margin-bottom: 20px;
    }

    .form-group {
      margin-bottom: 15px;
    }

    label {
      display: block;
      margin-bottom: 5px;
      font-weight: bold;
    }

    input[type="text"],
    .content {
      width: 100%;
      padding: 10px;
      border: 1px solid #dee2e6;
      border-radius: 4px;
      font-size: 16px;
    }

    [contenteditable="true"]:empty:before {
      content: attr(placeholder);
    }

    .content {
      height: 300px;
    }

    .btn_box {
      display: flex;
      justify-content: space-between;
    }

    button {
      display: block;
      width: 50%;
      padding: 10px;
      margin: 10px;
      background-color: #007bff;
      color: white;
      border: none;
      border-radius: 4px;
      font-size: 16px;
      cursor: pointer;
      transition: background-color 0.3s;
    }

    button:hover {
      background-color: #0056b3;
    }
    .file_box {
        display: flex;
    	justify-content: space-between;
    	align-items: flex-start;
	}
    .file_cont {
    display: flex;
    flex-direction: column;
    }
    .file_cont input {
    	margin-bottom:5px;
    }
</style>
</head>
<body>
	<div class="container">
    <h1>자유게시판 글 작성하기</h1>
    <form id="postForm" action="/write.board" method="post" enctype="multipart/form-data">
      <div class="form-group">
        <label for="title">제목</label>
        <input type="text" id="title" name="title" placeholder="글 제목을 입력하세요." required>
      </div>
      <div class="form-group">
        <label for="content">내용</label>
        <div contenteditable="true" class="content" id="content" name="content" rows="10" placeholder="내용을 입력해주세요."></div>
         <input type="hidden" name="content" id="hiddenContent" value="">
      </div>
      <div class="file_box">
      	<div class="file_cont">
			<input type="file" name="file0">
      	</div>
		<input type="button" value="+" id="filePlus">
      </div>
      <div class="btn_box">
        <button type="button" id="list">목록으로</button>
        <button id="complete">작성완료</button>
      </div>
    </form>
  </div>
  <script>
  	let idx = 1;
  	$("#list").on("click",function(){
  		location.href="/list.board";
	})
  	$("#complete").on("click",function(){
	  	$("#hiddenContent").val($("#content").html());
  	})
  	$("#filePlus").on("click",function(){
	  	console.log(idx);
  		let inputFile = $("<input type='file' name='file"+idx+"'>");
  		if(idx < 5){
		  	$(".file_cont").append(inputFile);
		  	idx++;	
  		} else {
  			alert("파일 등록은 최대 5개까지입니다.")
  		}
  	})
  </script>
</body>
</html>