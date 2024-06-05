<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            margin-bottom: 20px;
          }

          .post_content {
            white-space: pre-wrap;
            text-align: center;
          }

          .post_header form {
            float: right;
            padding-bottom: 10px;
            margin-bottom: 20px;
          }

          .post_header button {
            padding: 5px 10px;
            background-color: #ff4040;
            color: white;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s;
          }

          .post_meta .floatBtn {
            float: right;
          }

          .post_header .update_box {
            display: none;
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
            border: 1px solid #dee2e6;
            border-radius: 4px;
            font-size: 16px;
            margin-bottom: 10px;
            overflow-y: auto;
          }

          .comment_form #comment img {
            width: 160px;
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


          .no_comments {
            text-align: center;
            color: #6c757d;
          }

          .replyBox {
            display: flex;
            justify-content: space-between;
            align-items: flex-end;
            padding: 10px;
            border-top: 1px solid #dee2e6;
          }

          .replytxt {
            display: flex;
            flex-direction: column;
            word-break: break-word;
            color: #6c757d;
            width: calc(100% - 100px);
          }

          .replytxt span {
            padding-bottom: 5px;
          }

          .replytxt span:last-child {
            padding-bottom: 0px;
          }

          .replybtn {
            width: 100px;
            display: flex;
    		justify-content: space-between;
          }

          .replybtn button {
            padding: 5px 10px;
            background-color: dodgerblue;
            border: 1px solid dodgerblue;
            border-radius: 4px;
            color: #fff;
          }

          .replybtn .replyUpdate {
            display: none;
          }

          .replybtn .replyCancle {
            display: none;
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
                <span id="post_date">작성일:
                  <fmt:formatDate value="${dto.write_date}" pattern="yyyy.MM.dd" />
                </span> |
                <span id="post_views">조회수: ${dto.view_count}</span>

                <c:choose>
                  <c:when test="${dto.writer eq loginID}">
                    <form action="/update.board?seq=${dto.seq}" method="post">
                      <div class="update_box">
                        <input type="hidden" name="title" id="hiddentitle" value="${dto.title}">
                        <input type="hidden" name="content" id="hiddenContent" value="${dto.contents}">
                        <button class="updateBtn">수정 완료</button>
                        <button class="cancleBtn" type="button">취소</button>
                      </div>
                      <div class="modi_box">
                        <button class="modifyBtn" type="button">게시글 수정</button>
                        <button class="deleteBtn" type="button">게시글 삭제</button>
                        <button class="listBtn" type="button">목록으로</button>
                      </div>
                    </form>
                    <script>

                      $('.cancleBtn').on("click", function () {
                        location.reload();
                      })
                      $(".deleteBtn").on("click", function (e) {

                        location.href = "/delete.board?seq=${dto.seq}";
                      })

                      $(".modifyBtn").on("click", function () {
                        let result = confirm("수정하시겠습니까?");
                        if (result) {
                          let modifyContent = $("#post-content");
                          let modifyTitle = $("#modifyTitle");

                          modifyContent.attr("contenteditable", true);
                          modifyTitle.attr("contenteditable", true);
                          modifyTitle.focus();
                          $(".modi_box").css("display", "none");
                          $(".update_box").css("display", "inline-block");
                        }
                      })
                      $(".updateBtn").on("click", function () {
                        let result = confirm("수정하시겠습니까?");
                        if (result) {
                          let modifyContent = $("#post-content");
                          let modifyTitle = $("#modifyTitle");
                          let contentval = $("#hiddenContent");
                          let titleval = $("#hiddentitle");
                          modifyContent.attr("contenteditable", true);
                          modifyTitle.attr("contenteditable", true);
                          contentval.val(modifyContent.html());
                          titleval.val(modifyTitle.html());
                          $(".update_box").css("display", "none");
                          $(".modi_box").css("display", "inline-block");
                        }
                      })
                    </script>
                  </c:when>
                  <c:otherwise>
                    <button class="listBtn floatBtn" type="button">목록으로</button>
                  </c:otherwise>
                </c:choose>

              </div>
            </div>
            <div class="post_content" id="post-content">
              ${dto.contents}
            </div>
            <div id="filelist">
				<c:forEach var="i" items="${list}">
					<div><a href="/download.file?sysname=${i.sysname}&oriname=${i.oriname}">${i.oriname}</a></div>
				</c:forEach>
			</div>
          </div>
          <!-- 게시글 클릭 시점에 게시글 내용은 EL/JSTL로 출력하되 댓글 목록은 AJAX로 추가로 받아오는 문법으로 변경 -->
          <div class="comments_section">
            <h3>댓글</h3>
            <div class="comments" id="comments">
              <!-- 댓글이 동적으로 추가될 부분 -->
              <p class="no_comments"></p>
			  
              <form action="/write.reply">
                <div class="comment_form">
                  <div id="comment" placeholder="댓글을 입력하세요..." contenteditable="true"></div>
                  <input type="hidden" name="replyCon" id="hiddenReplyCon" value="">
                  <input type="hidden" name="replyPseq" id="hiddenReplyPseq" value="${dto.seq}">
                  <button id="submitComment">댓글 입력</button>
                </div>
              </form>
            </div>

          </div>
        </div>
        <script>
          $('.listBtn').on("click", function () {
            location.href = "/list.board";
          });
          $('#submitComment').on("click", function () {
            let replyText = $('#comment').text().trim();
            if(replyText == null && replyText == "") {
            	$("#submitComment").attr("disabled",true);
            } else {
            	$("#submitComment").attr("disabled",false);
	            $('#hiddenReplyCon').val(replyText);
            }
          });
          
          $(function () {
              $.ajax({
                url: "/list.reply",
                dataType: "json",
                type: "post",
                data: {  parent_seq: "${dto.seq}" },
              }).done(function (resp) {
                for (let i of resp) {
                  let replyCon = $("<span>",{ "class": "replyContents" });
                  let replyWriter = $("<span>",{"class": "replyWriter"});
                  let replyWriteDate = $("<span>",{"class": "replyDate"});
                  let hiddenReplyContent = $("<input>",{"class": "hiddenReplyContent", "type": "hidden","name": "replyContents"});
                  let hiddenreplyseq = $("<input>",{"class": "hiddenreplyseq", "type": "hidden", "name": "replyseq"});
                  let hiddenParentseq = $("<input>",{"class": "hiddenParentseq", "type": "hidden", "name": "seq"});
                  let loginID = "${loginID}";
                  let formBox = $("<form>", {"action": "/update.reply","class": "replyBox"})
                  hiddenreplyseq.val(i.seq);
                  hiddenParentseq.val(i.parent_seq);
                  console.log(loginID);
                  for (let j of ${replyList}) {
                	console.log(j)	  
                  }
                  replyWriter.html(i.writer);
                  replyCon.html(i.contents);
                  replyWriteDate.html(i.write_date);
                  let replytxt = $("<div>", { "class": "replytxt" });
                  replytxt.append(replyWriter, replyCon, replyWriteDate,hiddenReplyContent,hiddenreplyseq,hiddenParentseq);
                  formBox.append(replytxt);
                  // 버튼
                  let replyModify = $("<button>", { "class": "replyModify", "type": "button" });
                  replyModify.html("수정")
                  let replyCancle = $("<button>", { "class": "replyCancle", "type": "button" });
                  replyCancle.html("취소")
                  let replyDel = $("<button>", { "class": "replyDel", "type": "button" });
                  replyDel.html("삭제")
                  let replyUpdate = $("<button>", { "class": "replyUpdate" });
                  replyUpdate.html("완료")
                  let replybtn = $("<div>", { "class": "replybtn" });
                  
                  if (loginID == i.writer) {
                    replybtn.append(replyModify, replyDel, replyUpdate, replyCancle);
                    formBox.append(replybtn);
                  }
                  
                  $("#comments").prepend(formBox);
                  $('.replyDel').off('click').on('click', function () {
                      let inputVal = $(this).parent().siblings('.replytxt').find('.hiddenreplyseq').val();
                      location.href = "/delete.reply?seq=${dto.seq}&replyseq=" + inputVal;
                    });
                    $('.replyCancle').off('click').on("click", function () {
                      location.reload();
                    });
                    $(".replyModify").off('click').on('click', function () {
                      $(this).css("display", "none");
                      $(this).siblings('.replyDel').css("display", "none");
                      $(this).siblings('.replyUpdate').css("display", "inline-block");
                      $(this).siblings('.replyCancle').css("display", "inline-block");
                      $(this).parent().siblings('.replytxt').find('.replyContents').attr("contenteditable", true);
                    });

                    $(".replyUpdate").off('click').on('click', function () {
                      $(this).parent().siblings('.replytxt').find('.hiddenReplyContent').val($(this).parent().siblings('.replytxt').find('.replyContents').html());
                    });
                }
              })
            });
          
             
            
        </script>
      </body>

      </html>