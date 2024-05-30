<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <!DOCTYPE html>
    <html>

    <head>
      <meta charset="UTF-8">
      <title>Mypage</title>
      <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
      <script defer src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
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
    .val span {
      font-size:12px;
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
		        <span id="userID" class="userID" contenteditable="false">${dto.id}</span>
		        <input type="hidden" name="id" id="hiddenId" value="${dto.id}">
		      </div>
		      <div class="info-item">
		        <label for="userName">이름:</label>
		        <span id="userName">${dto.name}</span>
		        <input type="hidden" name="name" id="hiddenName" value="${dto.name}">
		        <div class="val"></div>
		      </div>
		      <div class="info-item">
		        <label for="userPhone">전화번호:</label>
		        <span id="userPhone">${dto.phone}</span>
		        <input type="hidden" name="phone" id="hiddenPhone" value="${dto.phone}">
		        <div class="val"></div>
		      </div>
		      <div class="info-item">
		        <label for="userEmail">이메일:</label>
		        <span id="userEmail">${dto.email}</span>
		        <input type="hidden" name="email" id="hiddenEmail" value="${dto.email}">
		        <div class="val"></div>
		      </div>
		      <div class="info-item">
		        <label for="userZipcode">우편 번호:</label>
		        <span id="userZipcode" contenteditable="false">${dto.zipcode}</span>
		        <input type="button" onclick="postSearchBtn()" value="검색" id="post_btn" disabled="true">
		        <input type="hidden" name="zipcode" id="hiddenZipcode" value="${dto.zipcode}">
		      </div>
		      <div class="info-item">
		        <label for="userAddress">주소1:</label>
		        <span id="userAddress1" contenteditable="false">${dto.address1}</span>
		        <input type="hidden" name="address1" id="hiddenAddress1" value="${dto.address1}">
		      </div>
		      <div class="info-item">
		        <label for="userAddress" >주소2:</label>
		        <span id="userAddress2" >${dto.address2}</span>
		        <input type="hidden" name="address2" id="hiddenAddress2" value="${dto.address2}">
		      </div>
		      <div class="info-item">
		        <label for="userJoindate">가입일:</label>
		        <span id="userJoindate" class="userJoindate" contenteditable="false">
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
//수정버튼 클릭
  	$("#modifyBtn").on("click", function () {
      $(this).closest(".btn_box").removeClass("on");
      $(this).closest(".btn_box").siblings().addClass("on");
      $(this).closest(".info-box").addClass("on");
      console.log(this.closest(".btn_box"));
      if ($(".info-box").hasClass("on")) {
        $("span:not(#userID, #userZipcode,#userAddress1,#userJoindate)").attr("contenteditable", true);
        $("#post_btn").attr("disabled",false);
      }
    })
    // 완료 클릭
    $("#finishBtn").on("click", function () {
      $(this).closest(".btn_box").removeClass("on");
      $(this).closest(".btn_box").siblings().addClass("on");
      $(this).closest(".info-box").removeClass("on");
      if (!$(".info-box").hasClass("on")) {
        $("span").attr("contenteditable", false);
      }
      $("#hiddenName").val($("#userName").html());
      $("#hiddenPhone").val($("#userPhone").html());
      $("#hiddenEmail").val($("#userEmail").html());
      $("#hiddenZipcode").val($("#userZipcode").html());
      $("#hiddenAddress1").val($("#userAddress1").html());
      $("#hiddenAddress2").val($("#userAddress2").html());
    })
    // 취소버튼 클릭
    $("#cancleBtn").on("click", function(){
		location.href="/mypage.mem";
	})
	// 홈버튼 클릭
	$("#homeBtn").on("click", function(){
		location.href="/index.jsp";
	})
	// contenteditable 엔터 시 <br>태그로 인해 정규표현식 오류 방지 엔터키 사용 못하게 방지
    $("span").on("keydown",function(e){
    	if(e.key == "Enter") {
    		return false;
    	}
    })
  </script>
  <script>
	  // 공용 유효성 텍스트 배열
	  let val = document.getElementsByClassName('val');
	
	  // name 체크 변수
	  let name = document.getElementById('userName');
	  let nameRegex = /^[가-힣]{2,5}$/;
	
	  // phone 체크 변수
	  let phone = document.getElementById('userPhone');
	  let phoneRegex = /^01[\d]-?\d{4}-?\d{4}$/;
	
	  // email 체크 변수
	  let email = document.getElementById('userEmail');
	  let emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
	
	  // adress 변수
	  let post = document.getElementById('hiddenZipcode');
	  let post_btn = document.getElementById('post_btn');
	  let address1 = document.getElementById('hiddenAddress1');
	  let post_txt = document.getElementById('userZipcode');
	  let address1_txt = document.getElementById('userAddress1');
		
		
	  // 이름 체크 함수
	  name.addEventListener('keyup', function () {
	      let result = nameRegex.test(name.innerHTML);
	      console.log(name.innerHTML);
	      if (result) {
	        val[0].innerHTML = '<span>이름 굳👍</span>';
	        val[0].children[0].setAttribute('style', 'color:dodgerblue');
	      } else {
	        val[0].innerHTML = '<span>이름을 확인해주세요.</span>';
	        val[0].children[0].setAttribute('style', 'color:red');
	      }
	  })

	    // 전화번호 체크 함수
	    phone.addEventListener('keyup', function () {
	      let result = phoneRegex.test(phone.innerHTML);
	      console.log(result);
	      if (result) {
	        val[1].innerHTML = '<span>전화번호와 양식이 일치합니다.</span>';
	        val[1].children[0].setAttribute('style', 'color:dodgerblue');
	      } else {
	        val[1].innerHTML = '<span>전화번호를 확인해주세요.</span>';
	        val[1].children[0].setAttribute('style', 'color:red');
	      }
	    })
	    // 이메일 체크 함수
	    email.addEventListener('keyup', function () {
	      let result = emailRegex.test(email.innerHTML);
	      if (result) {
	        val[2].innerHTML = '<span>이메일과 양식이 일치합니다.</span>';
	        val[2].children[0].setAttribute('style', 'color:dodgerblue');
	      } else {
	        val[2].innerHTML = '<span>이메일을 확인해주세요.</span>';
	        val[2].children[0].setAttribute('style', 'color:red');
	      }
	    })
	
	  // 우편번호 찾기
	  function postSearchBtn() {
	    new daum.Postcode({
	      oncomplete: function (data) {
	    		let postcode = data.zonecode; // 우편번호
	          let roadAddress = data.roadAddress; // 도로명주소
	          let post_innertxt = post.value = postcode;
	          let address1_innertxt = address1.value = roadAddress;
	          post_txt.innerHTML = post_innertxt;
	          address1_txt.innerHTML = address1_innertxt;
	      }
	    }).open();
	  }
  </script>
 </body>
</html>