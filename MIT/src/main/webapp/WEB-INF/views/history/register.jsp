<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<meta name="description" content="MIT Website" />
	<meta name="author" content="MIT" />
	
	<title>MIT</title>
	
	<!-- MAIN JS -->
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
	<!-- startbootstrap-sb-admin-gh-pages -->
	<link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
	<link href="/resources/bootstrap/css/styles.css" rel="stylesheet" />
	<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
	
	<!-- Bootstrap Icons -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
</head>
<body>
<div id="layoutSidenav_content">
	<main>
		<div class="container-fluid px-4">
			<h1 class="mt-4" style='text-align: center; margin-bottom: 30px;'>동아리 연혁 수정하기</h1>
				
			<form role="form" method="post" name="frm">
				<input type='hidden' id="memberNo" name='memberNo' value="${login.memberNo}">
				
				<div class="input-group">
					<div class="input-group-text">일자</div>
					<input type="text" class="form-control" id="historyDate" name="historyDate">
				</div>
				
				<div class="form-group">
					<div class="input-group-text">내용</div>
					<textarea class="form-control" id="historyContent" name="historyContent" rows="13" placeholder="Enter content..."></textarea>
				</div>
				
				<div style="text-align: right; margin: 17px 0 17px 0;">
					<button type="button" class="btn btn-outline-primary" id="btn_submit">등록</button>
					<button type="button" class="btn btn-outline-dark" onClick="window.close()">닫기</button>
				</div>
			</form>
		</div>
	</main>
	<footer class="py-4 bg-light mt-auto mb-0">
		<div class="container-fluid px-4">
			<div class="d-flex align-items-center justify-content-between small">
				<div class="text-muted">MIT Website</div>
			</div>
		</div>
	</footer>
</div>

<script>
	function validate() {
		var historyDate = $("#historyDate").val();
		var historyContent = $("#historyContent").val();
	
		if (historyDate == "") {
			alert("일자를 입력해주세요.");
			document.getElementById("historyDate").focus();
			return false;
		}
		
		if (historyContent == "") {
			alert("내용을 입력해주세요.");
			document.getElementById("historyContent").focus();
			return false;
		}
		
		return true;
	}
</script>

<script>
	$(document).ready(function() {
		var formObj = $("form[role='form']");
		console.log(formObj);

		$("#btn_submit").on("click", function() {
			if (validate()) {
				formObj.submit();
			}
		});
	});
</script>
</body>
</html>