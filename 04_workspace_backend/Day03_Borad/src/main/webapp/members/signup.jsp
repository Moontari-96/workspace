<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html>

    <head>
      <meta charset="UTF-8">
      <title>Sign up</title>
      <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
      <script defer src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
      <style>
        * {
          box-sizing: border-box;
          padding: 0;
          margin: 0;
        }

        .container {
          margin: auto;
          width: 500px;
          max-width:100%;
          height: 100%;
          display: flex;
          flex-direction: column;
          justify-content: center;
        }

        h5 {
          text-align: left;
          color: red;
        }

        h1 {
          text-align: center;
          margin-bottom: 20px;
        }

        #joinform>div {
          display: flex;
          width: 100%;
          padding: 10px;
          align-items: center;
          justify-content: flex-start;
        }

        label {
          font-size: 18px;
          color: #555;
          word-break: keep-all;
          width: 150px;
        }

        input {
          width: calc(100% - 150px);
          padding: 15px;
          border-radius: 5px;
        }

        #post_btn {
          word-break: keep-all;
          background-color: dodgerblue;
          color: #fff;
          border: 1px solid dodgerblue;
          padding: 15px;
          border-radius: 5px;
          width: auto;
          margin: 0;
        }

        button {
          word-break: keep-all;
          background-color: dodgerblue;
          color: #fff;
          border: 1px solid dodgerblue;
          padding: 15px;
          border-radius: 5px;
        }

        #joinform .id_Box,
        #joinform .pw_chkBox,
        #joinform .name_Box,
        #joinform .phone_Box,
        #joinform .email_Box {
          display: flex;
          flex-direction: column;
          align-items: flex-start;
        }

        #joinform .input_val{
          width: 100%;
          display: flex;
          align-items: center;
        }
        #joinform .input_val form{
          width: 100%;
          display: flex;
          align-items: center;
        }
        #joinform .val span {
          display: block;
          padding: 5px 0;
          font-size: 12px;
        }

        .id_Box input {
          margin-left: 47px;
          margin-right: 10px;
        }

        .post_Box input {
          margin-left: 38px;
          margin-right: 20px;
        }

        #joinform .join_box {
          display: flex;
          justify-content: space-evenly;
        }

        .join_box button {
          background-color: mediumseagreen;
          border: 1px solid mediumseagreen;
          color: #fff;
          width: 20%;
          font-size: 18px;
        }
      </style>
    </head>

    <body>
    <!-- 절대경로 지정법 : /signup.mem -> http://localhost/signup.mem -->
    <!-- 상대경로 지정법 : signup.mem -> http://localhost/현재위치/signup.mem -->
      <div class="container">
        <h1>회원가입</h1>
        <!-- 회원가입 유효성 기준 -->
        <h5>1> ID / 패스워드 / 이름은 필수 항목</h5>
        <h5>2> ID는 8자 이상의 알파벳 소문자, 숫자, _로만 구성가능</h5>
        <h5>3> 패스워드는 알파벳 대문자, 소문자, 숫자를 각 하`나 이상은 포함해야 하며, 최소 8자 이상</h5>
        <h5>4> 이름은 한글로 2 ~ 5자만 가능</h5>
        <h5>5> 전화번호 및 이메일은 입력하지 않으면 무시하되, 입력이 되었다면 형식에 맞아야 함</h5>
        <h5>6> 주소에는 유효성 검사 없음</h5>

		<form action="/signup.mem" id="joinform">
		<!-- ID 영역 -->
        <div class="id_Box">
          <div class="input_val">
              <label for="id">아이디</label>
              <input type="text" id="id" placeholder="아이디" name="id">
              <button id="id_chk" type="button">중복체크</button>
          </div>
          <div class="val"></div>
        </div>
        <!-- PW 영역 -->
        <div class="pw_Box">
          <label for="pw">패스워드</label>
          <input type="password" id="pw" placeholder="패스워드" name="pw">
        </div>
        <div class="pw_chkBox">
          <div class="input_val">
            <label for="pwchk">패스워드 확인</label>
            <input type="password" id="pwchk" placeholder="패스워드 재입력" name="pwchk">
          </div>
          <div class="val"></div>
        </div>
        <!-- 이름 영역 -->
        <div class="name_Box">
          <div class="input_val">
            <label for="name">이름</label>
            <input type="text" id="name" placeholder="이름" name="name">
          </div>
          <div class="val"></div>
        </div>
        <!-- 전화번호 영역 -->
        <div class="phone_Box">
          <div class="input_val">
            <label for="phone">전화번호</label>
            <input type="tel" id="phone" placeholder="전화번호" name="phone">
          </div>
          <div class="val"></div>
        </div>
        <!-- 이메일 영역 -->
        <div class="email_Box">
          <div class="input_val">
            <label for="email">이메일</label>
            <input type="email" id="email" placeholder="이메일" name="email">
          </div>
          <div class="val"></div>
        </div>
        <!-- 주소 영역 -->
        <div class="post_Box">
          <label for="post">우편번호</label>
          <input type="text" id="post" placeholder="우편번호" readonly name="zipcode">
          <input type="button" onclick="postSearchBtn()" value="검색" id="post_btn" >
        </div>
        <div>
          <label for="address1">주소1</label>
          <input type="text" placeholder="주소1" id="address1" name="address1">
        </div>
        <div>
          <label for="address2">상세주소</label>
          <input type="text" placeholder="상세주소" id="address2" name="address2">
        </div>
        <!-- 회원가입 영역 -->
        <div class="join_box">
          <button id="join_btn">가입하기</button>
          <button id="backIndex" type="button">돌아가기</button>
        </div>
        </form>



      </div>
      <script>
       
        
        // 공용 유효성 텍스트 배열
        var didIdCheck = false;
        let val = document.getElementsByClassName('val');
        // ID 체크 변수
        let id = document.getElementById('id');
        let id_chk = document.getElementById('id_chk');
        let idRegex = /^[a-z\d_]{8,}$/;

        // PW 체크 변수 
        let pw = document.getElementById('pw');
        let pwchk = document.getElementById('pwchk');
        let pwRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{8,}$/;

        // name 체크 변수
        let name = document.getElementById('name');
        let nameRegex = /^[가-힣]{2,5}$/;

        // phone 체크 변수
        let phone = document.getElementById('phone');
        let phoneRegex = /^01[\d]-?\d{4}-?\d{4}$/;

        // email 체크 변수
        let eamil = document.getElementById('email');
        let emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

        // adress 변수
        let post = document.getElementById('post');
        let post_btn = document.getElementById('post_btn');
        let address1 = document.getElementById('address1');

        // ID 체크 함수
        id.addEventListener('keyup', function () {
          let result = idRegex.test(id.value);
          if (result) {
            val[0].innerHTML = '<span>가입이 가능한 아이디입니다.</span>';
            val[0].children[0].setAttribute('style', 'color:dodgerblue');
            id_chk.removeAttribute("disabled");  
            didIdCheck = false;
          } else {
            val[0].innerHTML = '<span>가입이 불가한 아이디입니다.</span>';
            val[0].children[0].setAttribute('style', 'color:red');
            id_chk.setAttribute('disabled',true);  
          }
        })

        // PW 체크 함수
        pw.addEventListener('keyup', function () {
          let result = pwRegex.test(pw.value);
            console.log(pw.value);
          if (result) {
            pwchk.addEventListener('keyup', function () {
              if (pwchk.value == pw.value) {
                val[1].innerHTML = '<span>비밀번호가 일치합니다.</span>';
                val[1].children[0].setAttribute('style', 'color:dodgerblue');
              } else {
                val[1].innerHTML = '<span>비밀번호가 일치하지 않습니다 비밀번호를 확인해주세요.</span>';
                val[1].children[0].setAttribute('style', 'color:red');
              }
            })
          }
        })
        // 이름 체크 함수
        name.addEventListener('keyup', function () {
          let result = nameRegex.test(name.value);
          if (result) {
            val[2].innerHTML = '<span>이름 굳👍</span>';
            val[2].children[0].setAttribute('style', 'color:dodgerblue');
          } else {
            val[2].innerHTML = '<span>이름을 확인해주세요.</span>';
            val[2].children[0].setAttribute('style', 'color:red');
          }
        })
        
        // 전화번호 체크 함수
        phone.addEventListener('keyup', function () {
          let result = phoneRegex.test(phone.value);
          console.log(result);
          if (result) {
            val[3].innerHTML = '<span>전화번호와 양식이 일치합니다.</span>';
            val[3].children[0].setAttribute('style', 'color:dodgerblue');
          } else {
            val[3].innerHTML = '<span>전화번호를 확인해주세요.</span>';
            val[3].children[0].setAttribute('style', 'color:red');
          }
        })
        // 이메일 체크 함수
        email.addEventListener('keyup', function () {
          let result = emailRegex.test(email.value);
          if (result) {
            val[4].innerHTML = '<span>이메일과 양식이 일치합니다.</span>';
            val[4].children[0].setAttribute('style', 'color:dodgerblue');
          } else {
            val[4].innerHTML = '<span>이메일을 확인해주세요.</span>';
            val[4].children[0].setAttribute('style', 'color:red');
          }
        })

        // 우편번호 찾기
        function postSearchBtn() {
          new daum.Postcode({
            oncomplete: function (data) {
              let postcode = data.zonecode; // 우편번호
              let roadAddress = data.roadAddress; // 도로명주소
              post.value = postcode;
              address1.value = roadAddress;
            }
          }).open();
        }
       
        document.getElementById('backIndex').addEventListener('click', function () {
          location.href = "/index.jsp";
        })
        $("#id_chk").on("click", function () {
        	$.ajax({
				url:"/idcheck.mem",
				type: "post",
				dataType:"json", // 역직렬화 선언 (let movie = JSON.parse(resp))와 같은 의미
				data: {id : $("#id").val()}
			}).done(function(resp){
				console.log(resp);
				if(resp){
					alert("사용이 불가능한 아이디 입니다.");
					$("#id").val("");
				} else if(!resp) {
					let result = confirm("사용 가능한 ID 입니다. 사용하시겠습니까 ?");
					 if (result) {
                         didIdCheck = true;
                      } else {
                         $("#id").val("");
                      }

				}
			});
	        
	        // window.open("/idcheck.mem?id=" + $("#id").val(), "", "width=300,height=200");
        })
         console.log(didIdCheck);
         // 서브밋 유효성 검사
        joinform.addEventListener('submit', function (e) {
          if (!idRegex.test(id.value)) {
            // id 유효성
            alert('ID를 먼저 입력해주세요.')
            e.preventDefault(); // e.preventDefault
          } else if (!pwRegex.test(pw.value)) {
            // pw 유효성
            alert('PW를 입력해주세요.')
            e.preventDefault(); // e.preventDefault
          } else if (!pwRegex.test(pwchk.value)) {
            // pwchk 유효성
            alert('패스워드 재입력을 입력해주세요.')
            e.preventDefault(); // e.preventDefault
          } else if (!nameRegex.test(name.value)) {
            // name 유효성
            alert('이름을 입력해주세요.')
            e.preventDefault(); // e.preventDefault
          } else if (didIdCheck == false){
        	  alert('ID 중복성 체크을 해주세요')
              e.preventDefault(); // e.preventDefault
          }
        })
      </script>
    </body>

</html>