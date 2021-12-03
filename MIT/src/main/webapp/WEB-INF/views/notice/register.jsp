<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../include/header.jsp"%>

<div id="layoutSidenav_content">
	<main>
		<div class="container-fluid px-4">
			<h2 class="mt-4" style="text-align: center; margin-bottom: 30px;">공지사항 등록하기</h2>
			
			<form role="form" method="post" name="frm">
				<input type="hidden" value="${login.memberNo}" id="inlineFormInputGroupUsername" name="memberNo"> 
				
				
				<div class="input-group">
					<span class="input-group-text" id="inputGroup-sizing-default" style="padding: 0 20px 0 20px;">제목</span>
					<input type="text" class="form-control" id="noticeTitle" name="noticeTitle" placeholder="Enter Title...">
				</div>
				<div class="input-group">
					<span class="input-group-text" id="inputGroup-sizing-default">작성자</span>
					<input type="text" class="form-control" name="memberName" value="${login.memberName}" readonly>
				</div>
				<div class="form-group">
					<div class="input-group-text">&nbsp;내용</div>
					<textarea class="form-control" id="noticeContent" name="noticeContent" rows="15" placeholder="Enter content..."></textarea>
					<script>
            			$(document).ready(function() {
                			CKEDITOR.replace("noticeContent", {
                    			height: 400
                			});
            			});
        			</script>
				</div>

			
				<div style="text-align: right; margin: 17px 0 17px 0;">
					<button type="button" class="btn btn-outline-primary" id="btn_submit">등록</button>
					<button type="button" class="btn btn-outline-dark" id="btn_list">취소</button>
				</div>
			</form>
		</div>
	</main>

<script>
	// 등록 유효성 검사 
	function validate() {
		var noticeTitle = $("#noticeTitle").val();
		var noticeContent = CKEDITOR.instances.noticeContent.getData();

		if (noticeTitle == "") {
			alert("제목을 입력해주세요 .");
			document.getElementById("noticeTitle").focus();
			return false;
		}

		if (noticeContent == "") {
			alert("내용을 입력해주세요 .");
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
			formObj.submit();
		});
		
		$('#btn_list').on("click", function(evt) {
			self.location = "list";
		});
	});
</script>

<%@include file="../include/footer.jsp"%>