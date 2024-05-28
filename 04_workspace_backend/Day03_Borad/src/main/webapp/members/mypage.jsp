<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <!DOCTYPE html>
    <html>

    <head>
      <meta charset="UTF-8">
      <title>Mypage</title>
      <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
      <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f0f0f0;
      margin: 0;
      padding: 0;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }

    .container {
      background-color: #fff;
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      width: 500px;
      text-align: center;
    }

    h1 {
      margin-bottom: 20px;
    }

    .info-box {
      text-align: left;
    }

    .info-item {
      margin-bottom: 10px;
    }

    .info-item label {
      font-weight: bold;
      display: inline-block;
      width: 80px;
    }

    .info-item span {
      display: inline-block;
    }
    .btn_box.on {
      display: flex;
      justify-content: center;
    }
    .btn_box {
      display: none;
    }
     .btn_box button{
      padding: 5px;
      margin: 5px;
    }
  </style>
    </head>

    <body>
		<form action="/modifyUser.mem" method="post">
		  <div class="container">
		    <h1>회원 정보</h1>
		    <div class="info-box">
		      <div class="info-item">
		        <label for="userID">아이디:</label>
		        <span id="userID" class="userID">${dto.id}</span>
		        <input type="hidden" name="id" id="hiddenId" value="${dto.id}">
		      </div>
		      <div class="info-item">
		        <label for="userName">이름:</label>
		        <span id="userName">${dto.name}</span>
		        <input type="hidden" name="name" id="hiddenName" value="${dto.name}">
		      </div>
		      <div class="info-item">
		        <label for="userPhone">전화번호:</label>
		        <span id="userPhone">${dto.phone}</span>
		        <input type="hidden" name="phone" id="hiddenPhone" value="${dto.phone}">
		      </div>
		      <div class="info-item">
		        <label for="userEmail">이메일:</label>
		        <span id="userEmail">${dto.email}</span>
		        <input type="hidden" name="email" id="hiddenEmail" value="${dto.email}">
		      </div>
		      <div class="info-item">
		        <label for="userZipcode">우편 번호:</label>
		        <span id="userZipcode">${dto.zipcode}</span>
		        <input type="hidden" name="zipcode" id="hiddenZipcode" value="${dto.zipcode}">
		      </div>
		      <div class="info-item">
		        <label for="userAddress">주소1:</label>
		        <span id="userAddress1">${dto.address1}</span>
		        <input type="hidden" name="address1" id="hiddenAddress1" value="${dto.address1}">
		      </div>
		      <div class="info-item">
		        <label for="userAddress">주소2:</label>
		        <span id="userAddress2">${dto.address2}</span>
		        <input type="hidden" name="address2" id="hiddenAddress2" value="${dto.address2}">
		      </div>
		      <div class="info-item">
		        <label for="userJoindate">가입일:</label>
		        <span id="userJoindate" class="userJoindate">
		          <fmt:formatDate value="${dto.joinDate}" pattern="yyyy.MM.dd" />
		        </span>
		        <input type="hidden" name="joinDate" id="hiddenJoinDate" value="${dto.joinDate}">
		      </div>
		      <div>
		        <div class="btn_box on">
		          <button id="modifyBtn" type="button">수정하기</button>
		          <button id="homeBtn" type="button">홈으로</button>
		        </div>
		        <div class="btn_box">
		          <button id="finishBtn">완료</button>
		          <button id="cancleBtn" type="button">취소</button>
		        </div>
		      </div>
		    </div>
		  </div>
		</form>
  <script>
  	$("#modifyBtn").on("click", function () {
      $(this).closest(".btn_box").removeClass("on");
      $(this).closest(".btn_box").siblings().addClass("on");
      $(this).closest(".info-box").addClass("on");
      console.log(this.closest(".btn_box"));
      if ($(".info-box").hasClass("on")) {
        $("span").attr("contenteditable", "true");
        
        $("#userID").attr("contenteditable", "false");
        $("#userJoindate").attr("contenteditable", "false");
      }
    })
    
    $("#finishBtn").on("click", function () {
      $(this).closest(".btn_box").removeClass("on");
      $(this).closest(".btn_box").siblings().addClass("on");
      $(this).closest(".info-box").removeClass("on");
      if (!$(".info-box").hasClass("on")) {
        $("span").attr("contenteditable", "false");
      }
      $("#hiddenName").val($("#userName").html());
      $("#hiddenPhone").val($("#userPhone").html());
      $("#hiddenEmail").val($("#userEmail").html());
      $("#hiddenZipcode").val($("#userZipcode").html());
      $("#hiddenAddress1").val($("#userAddress1").html());
      $("#hiddenAddress2").val($("#userAddress2").html());
    })
    $("#cancleBtn").on("click", function(){
		location.href="/mypage.mem";
	})
	$("#homeBtn").on("click", function(){
		location.href="/index.jsp";
	})
	
  </script>
 </body>
</html>