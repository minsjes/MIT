<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../include/header.jsp"%>

<div id="layoutSidenav_content">
	<main>
		<div class="container-fluid px-4">
			<h1 class="mt-4" style='text-align: center; margin-bottom: 30px;'>회원 정보 수정</h1>

			<form role="form" action="modify" method="post">
				<div class="card mb-4">
					<div class="card-header">
						<i class="fas fa-user fa-fw"></i> 회원 정보 수정
					</div>
					<div class="card-body" style="margin: 15px; padding-right: 25%; padding-left: 25%;">
						<div class="form-group">
							<div class="form-group">
								<label class="exampleInputEmail1">학번</label>
								<div class="input-group mb-3">
									<span class="input-group-text" id="basic-addon1"><i class="far fa-user"></i></span>
									<input type="text" id="memberNo" name="memberNo" class="form-control" value="${memberVO.memberNo}" readonly="readonly">
								</div>
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">이름</label>
								<div class="input-group mb-3">
									<span class="input-group-text" id="basic-addon1"><i class="far fa-smile"></i></span>
									<input type="text" id="memberName" name="memberName" class="form-control" value="${memberVO.memberName}" readonly="readonly">
								</div>
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">연락처</label>
								<div class="input-group mb-3">
									<span class="input-group-text" id="basic-addon1" style="padding-right: 15px; padding-left: 15px;">
										<i class="fas fa-mobile-alt"></i>
									</span>
									<input type="text" id="memberPhone" name="memberPhone" class="form-control" value="${memberVO.memberPhone}" readonly="readonly">
								</div>
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">회원 유형</label>
								<div class="input-group mb-3">
									<span class="input-group-text" id="basic-addon1"><i class="far fa-star"></i></span>
									<c:if test="${1 eq memberVO.memberClass}">
										<select id="memberClass" name="memberClass" class="form-select">
											<option value="1" selected>재학생</option>
											<option value="2">졸업생</option>
											<option value="3">교수</option>
											<option value="4">일반인</option>
										</select>
									</c:if>
									<c:if test="${2 eq memberVO.memberClass}">
										<select id="memberClass" name="memberClass" class="form-select">
											<option value="1">재학생</option>
											<option value="2" selected>졸업생</option>
											<option value="3">교수</option>
											<option value="4">일반인</option>
										</select>
									</c:if>
									<c:if test="${3 eq memberVO.memberClass}">
										<select id="memberClass" name="memberClass" class="form-select">
											<option value="1">재학생</option>
											<option value="2">졸업생</option>
											<option value="3" selected>교수</option>
											<option value="4">일반인</option>
										</select>
									</c:if>
									<c:if test="${4 eq memberVO.memberClass}">
										<select id="memberClass" name="memberClass" class="form-select">
											<option value="1">재학생</option>
											<option value="2">졸업생</option>
											<option value="3">교수</option>
											<option value="4" selected>일반인</option>
										</select>
									</c:if>
								</div>
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">가입 일자</label> 
								<div class="input-group mb-3">
		  							<span class="input-group-text" id="basic-addon1"><i class="bi bi-clock"></i></span>
		  							<input type="text" id="allowDate" name="allowDate" class="form-control" value="<fmt:formatDate value="${memberVO.allowDate}" pattern="yyyy-MM-dd HH:mm:ss"/>" readonly="readonly">
								</div>
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">상태</label> 
								<div class="input-group mb-3">
		  							<c:if test="${0 eq memberVO.dormancyStatus}">
		  								<span class="input-group-text" id="basic-addon1"><i class="bi bi-eye-fill"></i></span>
										<select id="dormancyStatus" name="dormancyStatus" class="form-select">
											<option value="0" selected>활성</option>
											<option value="1">휴면</option>
										</select>
									</c:if>
									<c:if test="${1 eq memberVO.dormancyStatus}">
										<span class="input-group-text" id="basic-addon1"><i class="bi bi-eye-slash-fill"></i></span>
										<select id="dormancyStatus" name="dormancyStatus" class="form-select">
											<option value="0">활성</option>
											<option value="1" selected>휴면</option>
										</select>
									</c:if>
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
			self.location = "/member/read?memberNo=${memberVO.memberNo}";
		});

		$(".btn-outline-primary").on("click", function(){
			var dormancyStatus = $("#dormancyStatus option").index($("#dormancyStatus option:selected"));
			
			if (dormancyStatus != "${memberVO.dormancyStatus}") {
				if (confirm("휴면 처리가 된 계정은 로그인을 할 수 없습니다. 정말로 휴면 처리를 하시겠습니까?") == true){ //확인
					formObj.submit();
				} else { //취소
					return false;
				}
			} else {
				formObj.submit();
			}
		});
	});
</script>

<%@include file="../include/footer.jsp"%>
