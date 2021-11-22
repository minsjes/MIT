<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../include/header.jsp"%>

<style>
.preview-list{
	list-style: none;
    padding: 0 10px 0 10px;
}
</style>

<div id="layoutSidenav_content">
	<main>
		<div class="container-fluid px-4">
			<h2 class="mt-4" style="text-align: center; margin-bottom: 30px;">동아리 소개 등록하기</h2>
			
			<form role="form" method="post" name="frm">
				<input type="hidden" value="${login.memberNo}" id="inlineFormInputGroupUsername" name="memberNo"> 
				
				<div class="input-group">
					<span class="input-group-text" id="inputGroup-sizing-default">작성자</span>
					<input type="text" class="form-control" name="memberName" value="${login.memberName}" readonly>
				</div>
				<div class="form-group">
					<div class="input-group-text">내용</div>
					<textarea class="form-control" id="historyContent" name="historyContent" rows="15" placeholder="Enter content..."></textarea>
				</div>

				<div style="text-align: right; margin: 17px 0 17px 0;">
					<button type="button" class="btn btn-outline-primary" id="btn_submit">등록</button>
					<button type="button" class="btn btn-outline-dark" id="btn_list">취소</button>
				</div>
			</form>
		</div>
	</main>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="/resources/upload.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<script id="template" type="text/x-handlebars-template">
<li class="dropzone-previews mt-3">
<div class="card mt-1 mb-0 shadow-none border dz-processing dz-image-preview dz-success dz-complete">
<div class="p-2">
<div class="row align-items-center">
<div class="col-auto">
<img data-dz-thumbnail="" class="avatar-sm rounded bg-light" src="{{imgsrc}}">
</div>
<div class="col pl-0">
<a href="/displayFile?fileName={{fullName}}" text-muted font-weight-bold" data-dz-name="">{{fileName}}</a>
</div>
<div class="col-auto">
<a href="{{fullName}}" class="btn btn-default btn-xs pull-right delbtn"><i class="far fa-trash-alt"></i></a>
</div>
</div>
</div>
</div>
</li>
</script>

<script>
	// 등록 유효성 검사 
	function validate() {
		var historyContent = $("#historyContent").val();

		if (historyContent == "") {
			alert("내용을 입력해주세요 .");
			document.getElementById("historyContent").focus();
			return false;
		}

		return true;
	}
</script>

<script>
	$("input:text[numberOnly]").on("focus", function() {
		var x = $(this).val();
		x = removeCommas(x);
		$(this).val(x);
	}).on("focusout", function() {
		var x = $(this).val();
		if (x && x.length > 0) {
			if (!$.isNumeric(x)) {
				x = x.replace(/[^0-9]/g, "");
			}
			x = addCommas(x);
			$(this).val(x);
		}
	}).on("keyup", function() {
		$(this).val($(this).val().replace(/[^0-9]/g, ""));
	});
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