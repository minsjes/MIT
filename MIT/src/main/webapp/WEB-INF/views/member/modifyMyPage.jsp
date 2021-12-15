<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../include/header.jsp"%>


<div id="layoutSidenav_content">

	<main>
	<div class="container-fluid px-4">
		<div class="box-header">
			<h2 class="mt-4" style='text-align: center; margin-bottom: 30px;'>내
				정보 수정하기</h2>
		</div>


		<form role="form" action="modifyMyPage" method="post" name="form">

			<div class="card mb-4">
				<div class="card-header">
					<i class="fas fa-user fa-fw"></i> 내 정보 상세보기
				</div>

				<div class="card-body"
					style="padding-right: 350px; padding-left: 350px;">



					<div class="form-group">

						<label for="exampleInputEmail1">학번(아이디)</label>

						<div class="input-group mb-3">
							<span class="input-group-text" id="basic-addon1"><i
								class="far fa-user"></i></span> <input type="text" id="memberNo"
								name="memberNo" class="form-control"
								value="${memberVO.memberNo}" readonly="readonly">
						</div>
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">비밀번호</label>
						<div class="input-group mb-3">
							<span class="input-group-text" id="basic-addon1"><i
								class="fas fa-unlock-alt"></i></span> <input type="password"
								id="memberPw" name="memberPw" class="form-control"
								value="${memberVO.memberPw}">
						</div>
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">회원명</label>
						<div class="input-group mb-3">
							<span class="input-group-text" id="basic-addon1"><i
								class="far fa-smile"></i></span> <input type="text" id="memberName"
								name="memberName" class="form-control"
								value="${memberVO.memberName}">
						</div>
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">전화번호</label>
						<div class="input-group mb-3">
							<span class="input-group-text" id="basic-addon1"><i
								class="fas fa-mobile-alt"></i></span> <input type="text"
								id="memberPhone" name="memberPhone" class="form-control"
								value="${memberVO.memberPhone}">
						</div>
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">회원유형</label>
						<div class="input-group mb-3">
							<span class="input-group-text" id="basic-addon1"><i
								class="far fa-star"></i></span>
							<c:if test="${1 eq memberVO.memberClass}">
								<input type="text" class="form-control" value="재학생"
									readonly="readonly">
							</c:if>
							<c:if test="${2 eq memberVO.memberClass}">
								<input type="text" class="form-control" value="졸업생"
									readonly="readonly">
							</c:if>
							<c:if test="${3 eq memberVO.memberClass}">
								<input type="text" class="form-control" value="교수"
									readonly="readonly">
							</c:if>
							<c:if test="${4 eq memberVO.memberClass}">
								<input type="text" class="form-control" value="일반인"
									readonly="readonly">
							</c:if>
							<c:if test="${9 eq memberVO.memberClass}">
								<input type="text" class="form-control" value="관리자"
									readonly="readonly">
							</c:if>
						</div>
					</div>
				</div>



				<div class="box-footer"
					style="float: right; margin: 50px auto 50px;">
					<button type="button" class="btn btn-outline-primary"
						onclick="sendIt()">저장</button>
					<button type="button" class="btn btn-outline-dark"
						onclick="location.href='/member/readMyPage?memberNo=${memberVO.memberNo}'">취소</button>
				</div>
		</form>


	</div>
</div>
</main>

<script>
	//유효성 검사
	function sendIt() {
		// 비밀번호 입력여부 체크
		if (document.form.memberPw.value == "") {
			alert("비밀번호를 입력해주세요.");
			form.memberPw.focus();
			return false;
		}

		// 비밀번호 길이 체크(12자 까지 허용)
		if (document.form.memberPw.value.length > 12) {
			alert("비밀번호는 12자 이하로 입력해주세요.")
			document.form.memberPw.value = "";
			document.form.memberPw.focus();
			return false;
		}

		// 이름 입력여부 체크
		if (document.form.memberName.value == "") {
			alert("이름을 입력해주세요.");
			form.memberName.focus();
			return false;
		}

		// 연락처 입력여부 체크
		if (document.form.memberPhone.value == "") {
			alert("연락처를 입력해주세요.");
			form.memberPhone.focus();
			return false;
		}

		// 연락처 유효성 검사
		var phoneRegExp = /^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}/;
		var phone = document.form.memberPhone.value;
		if (!phoneRegExp.test(phone)) {
			alert("전화번호가 올바르지 않습니다. ex) 010-1234-1234");
			form.memberPhone.select();
			form.memberPhone.focus();
			return false;
		}
		alert("정보가 수정되었습니다. 재로그인 해주세요.");
		var formObj = $("form[role='form']");
		formObj.submit();
	}
</script>


<div>






	<%@include file="../include/footer.jsp"%>