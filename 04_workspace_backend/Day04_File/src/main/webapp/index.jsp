<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
	<form action="/upload.file" method="post" enctype="multipart/form-data">
		<input type="text" placeholder="메세지" name="message"><br>
		첨부파일1 : <input type="file" name="file1"><br> 첨부파일2 : <input
			type="file" name="file2"><br> 첨부파일3 : <input type="file"
			name="file3"><br>
		<button>완료</button>
	</form>
	<fieldset>
		<legend>File List</legend>
		<div id="filelist">
			
		</div>
	</fieldset>
	<button id="loadBtn">파일 목록 불러오기</button>
	<script>
		$("#loadBtn").on("click", function() {
			$("#filelist").html("");
			$.ajax({
				url : "/list.file",
				dataType : "json",
			}).done(function(resp) {
				//console.log(resp[0].oriname);
				for (let file of resp) {
					console.log(file.oriname);
					$("#filelist").append("<div>" + "<a href='/download.file?sysname="+file.sysname+"&oriname="+file.oriname+"'>" + file.oriname + "</a>"+ "</div>");
				}
			});
		})
	</script>
</body>
</html>