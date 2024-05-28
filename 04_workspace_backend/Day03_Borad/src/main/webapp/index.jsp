<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<style>
    /* styles.css */
    * {
      box-sizing: border-box;
      margin: 0;
      padding: 0;
      font-family: 'Arial', sans-serif;
    }

    body {
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      background-color: #f6f5f7;
    }

    .container {
      background-color: #fff;
      border-radius: 10px;
      box-shadow: 0 14px 28px rgba(0, 0, 0, 0.25), 0 10px 10px rgba(0, 0, 0, 0.22);
      position: relative;
      overflow: hidden;
      width: 768px;
      max-width: 100%;
      min-height: 480px;
    }

    .form-container {
      position: absolute;
      top: 0;
      height: 100%;
      transition: all 0.6s ease-in-out;
    }

    .sign-in-container {
      left: 0;
      width: 50%;
      z-index: 2;
    }

    .sign-up-container {
      left: 0;
      width: 50%;
      opacity: 0;
      z-index: 1;
    }

    .container.right-panel-active .sign-in-container {
      transform: translateX(100%);
    }

    .container.right-panel-active .sign-up-container {
      transform: translateX(100%);
      opacity: 1;
      z-index: 5;
    }

    .overlay-container {
      position: absolute;
      top: 0;
      left: 50%;
      width: 50%;
      height: 100%;
      overflow: hidden;
      transition: transform 0.6s ease-in-out;
      z-index: 100;
    }

    .container.right-panel-active .overlay-container {
      transform: translateX(-100%);
    }

    .overlay {
      background: #ff416c;
      background: -webkit-linear-gradient(to right, #ff4b2b, #ff416c);
      background: linear-gradient(to right, #ff4b2b, #ff416c);
      background-repeat: no-repeat;
      background-size: cover;
      background-position: 0 0;
      color: #ffffff;
      position: absolute;
      left: -100%;
      height: 100%;
      width: 200%;
      transform: translateX(0);
      transition: transform 0.6s ease-in-out;
    }

    .container.right-panel-active .overlay {
      transform: translateX(50%);
    }

    .overlay-panel {
      position: absolute;
      display: flex;
      align-items: center;
      justify-content: center;
      flex-direction: column;
      padding: 0 40px;
      text-align: center;
      top: 0;
      height: 100%;
      width: 50%;
      transform: translateX(0);
      transition: transform 0.6s ease-in-out;
    }

    .overlay-left {
      transform: translateX(-20%);
    }

    .container.right-panel-active .overlay-left {
      transform: translateX(0);
    }

    .overlay-right {
      right: 0;
      transform: translateX(0);
    }

    .container.right-panel-active .overlay-right {
      transform: translateX(20%);
    }

    h1 {
      font-weight: bold;
      margin: 0;
    }

    p {
      font-size: 14px;
      font-weight: 100;
      line-height: 20px;
      letter-spacing: 0.5px;
      margin: 20px 0 30px;
    }

    button {
      border-radius: 20px;
      border: 1px solid #ff4b2b;
      background-color: #ff4b2b;
      color: #ffffff;
      font-size: 12px;
      font-weight: bold;
      padding: 12px 45px;
      letter-spacing: 1px;
      text-transform: uppercase;
      transition: transform 80ms ease-in;
    }

    button:active {
      transform: scale(0.95);
    }

    button:focus {
      outline: none;
    }

    button.ghost {
      background-color: transparent;
      border-color: #ffffff;
    }

    form {
      background-color: #ffffff;
      display: flex;
      align-items: center;
      justify-content: center;
      flex-direction: column;
      padding: 0 50px;
      height: 100%;
      text-align: center;
    }

    input {
      background-color: #eee;
      border: none;
      padding: 12px 15px;
      margin: 8px 0;
      width: 100%;
    }
  </style>
</head>
<body>
	<c:choose>
		<c:when test="${loginID != null}">
			<table align="center">
				<tr>
					<th colspan="3">${loginID } 님 환영합니다.</th>
				</tr>
				<tr>
					<td>
						<button id="mypage">내 정보</button>
					</td>
					<td>
						<button id="logout">로그아웃</button>
					</td>
					<td>
						<button id="memberout">회원탈퇴</button>
					</td>
				</tr>
			</table>
			<script>
				$("#mypage").on("click",function(){
					location.href="/mypage.mem"
				})
				$("#logout").on("click",function(){
					location.href="/logout.mem"
				})
				$("#memberout").on("click",function(){
					let check = confirm("정말 삭제하시겠습니까?");
					if(check) {
						location.href="/memberout.mem"
					} else {
						location.href="/index.jsp"
					}
				})
			</script>
		</c:when>
		<c:otherwise>
		<div class="container">
		    <div class="form-container sign-up-container">
		      <form action="#">
		        <h1>회원가입</h1>
		        <input type="text" placeholder="이름" />
		        <input type="email" placeholder="이메일" />
		        <input type="password" placeholder="비밀번호" />
		        <button class="signUp">회원가입</button>
		      </form>
		    </div>
		    <div class="form-container sign-in-container">
		      <form action="/login.mem" method="post">
		        <h1>로그인</h1>
		        <input type="text" placeholder="아이디" name="id"/>
		        <input type="password" placeholder="비밀번호" name="pw" />
		        <button id="signIn">로그인</button>
		      </form>
		    </div>
		    <div class="overlay-container">
		      <div class="overlay">
		        <div class="overlay-panel overlay-left">
		          <h1>반갑습니다!</h1>
		          <p>계정이 이미 있으신가요? 로그인을 해주세요.</p>
		          <button class="ghost" id="signIn">로그인</button>
		        </div>
		        <div class="overlay-panel overlay-right">
		          <h1>처음이신가요?</h1>
		          <p>계정이 없으신가요? 회원가입을 해주세요.</p>
		          <button class="ghost signUp">회원가입</button>
		        </div>
		      </div>
		    </div>
		  </div>
		  <script>
		    // scripts.js
		    $(".signUp").on("click", function(){
				location.href="/members/signup.jsp";
			})
		  </script>
		</c:otherwise>
	</c:choose>
</body>
</html>