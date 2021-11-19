<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../include/header.jsp"%>

<div id="layoutSidenav_content">
	<main>
		<div class="container-fluid px-4">
			<h2 class="mt-4" style='text-align: center; margin-bottom: 30px;'>회원 추가 등록</h2>

			<form role="form" action="register" method="post">
				<div class="card mb-4">
					<div class="card-header">
						<i class="bi bi-person-plus-fill"></i> 회원 추가 등록
					</div>
					<div class="card-body">
						<div class="form-group">
							<div class="form-group" style="padding-right: 25%; padding-left: 25%;">
								<label class="exampleInputEmail1">학번</label>
								<div class="input-group mb-3">
									<span class="input-group-text" id="basic-addon1"><i class="far fa-user"></i></span>
									<input type="text" name='memberNo' class="form-control" value="${memberVO.memberNo}">
								</div>
							</div>
							<div class="form-group" style="padding-right: 25%; padding-left: 25%;">
								<label for="exampleInputEmail1">비밀번호</label>
								<div class="input-group mb-3">
									<span class="input-group-text" id="basic-addon1"><i class="fas fa-unlock-alt"></i></span>
									<input type="password" name='memberPw' class="form-control" value="${memberVO.memberPw}">
								</div>
							</div>
							<div class="form-group" style="padding-right: 25%; padding-left: 25%;">
								<label for="exampleInputEmail1">회원명</label>
								<div class="input-group mb-3">
									<span class="input-group-text" id="basic-addon1"><i class="far fa-smile"></i></span>
									<input type="text" name='memberName' class="form-control" value="${memberVO.memberName}">
								</div>
							</div>
							<div class="form-group" style="padding-right: 25%; padding-left: 25%;">
								<label for="exampleInputEmail1">전화번호</label>
								<div class="input-group mb-3">
									<span class="input-group-text" id="basic-addon1"><i class="fas fa-mobile-alt"></i></span>
									<input type="text" name="memberPhone" class="form-control" value="${memberVO.memberPhone}">
								</div>
							</div>
							<div class="form-group" style="padding-right: 25%; padding-left: 25%;">
								<label for="exampleInputEmail1">회원 유형</label>
								<select name='memberClass' class="form-select">
									<option value="1">신입생</option>
									<option value="2">졸업생</option>
									<option value="3">교수</option>
									<option value="4">일반인</option>
								</select>
							</div>
						</div>
					</div>
					<div class="box-footer" style="float: right; margin: 50px auto 50px;">
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
			self.location = "/member/list;
		});

		$(".btn-outline-primary").on("click", function(){
			formObj.submit();
		});
	});
</script>

<%@include file="../include/footer.jsp"%>
