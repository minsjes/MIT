<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../include/header.jsp"%>

<div id="layoutSidenav_content">
	<main>
		<div class="container-fluid px-4">
			<h1 class="mt-4" style='text-align: center; margin-bottom: 30px;'>회원 추가 등록</h1>

			<form role="form" action="register" method="post" name="form">
				<input type="hidden" id="adminNo" name="adminNo" value="${login.memberNo}">
				<div class="card mb-4">
					<div class="card-header">
						<i class="bi bi-person-plus-fill"></i> 회원 추가 등록
					</div>
					<div class="card-body" style="margin: 15px; padding-right: 25%; padding-left: 25%;">
						<div class="form-group">
							<div class="form-group">
								<label class="exampleInputEmail1">학번</label>
								<div class="input-group mb-3">
									<span class="input-group-text" id="basic-addon1"><i class="far fa-user"></i></span>
									<input type="text" id="memberNo" name="memberNo" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">비밀번호</label>
								<div class="input-group mb-3">
									<span class="input-group-text" id="basic-addon1"><i class="fas fa-unlock-alt"></i></span>
									<input type="password" id="memberPw" name="memberPw" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">이름</label>
								<div class="input-group mb-3">
									<span class="input-group-text" id="basic-addon1"><i class="far fa-smile"></i></span>
									<input type="text" id="memberName" name="memberName" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">연락처</label>
								<div class="input-group mb-3">
									<span class="input-group-text" id="basic-addon1" style="padding-right: 15px; padding-left: 15px;">
										<i class="fas fa-mobile-alt"></i>
									</span>
									<input type="text" id="memberPhone" name="memberPhone" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">회원 유형</label>
								<div class="input-group mb-3">
									<span class="input-group-text" id="basic-addon1"><i class="far fa-star"></i></span>
									<select id="memberClass" name="memberClass" class="form-select">
										<option value="1">재학생</option>
										<option value="2">졸업생</option>
										<option value="3">교수</option>
										<option value="4">일반인</option>
									</select>
								</div>
							</div>
						</div>
					</div>
					<div class="box-footer" style="float: right; margin: 0px auto 50px;">
						<button type="button" class="btn btn-outline-primary">저장</button>
						<button type="button" class="btn btn-outline-dark">취소</button>
					</div>
				</div>
			</form>
		</div>
	</main>

<script>
	$(document).ready(function(){
		var formObj = $("form[role='form']");
		console.log(formObj);
		
		$(".btn-outline-dark").on("click", function() {
			self.location = "/member/list";
		});

		$(".btn-outline-primary").on("click", function(){
			formObj.attr("action", "/member/register");
			formObj.attr("method", "post");
			formObj.submit();
		});
	});
</script>

<script>
	var result = '${msg}';
	
	if (result == 'FAIL') {
		alert("사용할 수 없는 학번입니다.");
	}
</script>

<script>
	function sendIt() {
		// 아이디 입력여부 검사
		if (form.memberNo.value == "") {
			alert("학번을 입력해주세요.");
			form.memberNo.focus();
			return false;
		}
		
		// 아이디 유효성 검사
		for(var i=0; i<document.form.memberNo.value.length; i++) {
			ch = document.form.memberNo.value.charAt(i)
			if(!(ch >= '0' && ch <='9')) {
				alert("학번에는 숫자만 입력할 수 있습니다.");
				document.form.memberNo.value = "";
				document.form.memberNo.focus();
				return false;
			}
		}
		
		// 아이디 길이 체크(8자)
		if(document.form.memberNo.value.length != 8) {
			alert("학번은 숫자 8자입니다.");
			document.form.memberNo.select();
			document.form.memberNo.focus();
			return false;
		} 
			
		// 비밀번호 입력여부 체크
		if(document.form.memberPw.value == "") {
			alert("비밀번호를 입력해주세요.");
			form.memberPw.focus();
			return false;
		}
			
		// 비밀번호 길이 체크(20자 까지 허용)
		if(document.form.memberPw.value.length > 12) {
			alert("비밀번호는 12자 이하로 입력해주세요.")
			document.form.memberPw.value = "";
			document.form.memberPw.focus();
			return false;
		}
			
		// 이름 입력여부 체크
		if(document.form.memberName.value == "") {
			alert("이름을 입력해주세요.");
			form.memberName.focus();
			return false;
		}
			
		// 연락처 입력여부 체크
		if(document.form.memberPhone.value == "") {
			alert("연락처를 입력해주세요.");
			form.memberPhone.focus();
			return false;
		}
		
		// 연락처 유효성 검사
		var phoneRegExp = /^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}/;
		var phone = document.form.memberPhone.value;
		if(!phoneRegExp.test(phone)) {
			alert("전화번호가 올바르지 않습니다. ex) 010-1234-1234");
			form.memberPhone.select();
			form.memberPhone.focus();
			return false;
		}
		
		var formObj = $("form[role='form']");
		formObj.submit();
	}
</script>

<%@include file="../include/footer.jsp"%>
