<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../include/header.jsp"%>

<div id="layoutSidenav_content">
	<main>
		<div class="container-fluid px-4">
			<h1 class="mt-4" style='text-align: center; margin-bottom: 30px;'>회원 관리</h1>
			
			<form role="form" action="read" method="post">
			<div class="card mb-4">
				<div class="card-header">
					<i class="fas fa-user fa-fw"></i> 회원 관리
				</div>
				<div class="card-body" style="margin: 15px; padding-right:25%; padding-left: 25%;">
					<div class="form-group">
						<label for="exampleInputEmail1">학번</label> 
						<div class="input-group mb-3">
 							<span class="input-group-text" id="basic-addon1"><i class="far fa-user"></i></span>
  							<input type="text" name='memberNo' class="form-control" value="${memberVO.memberNo}" readonly="readonly">
						</div>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">이름</label> 
						<div class="input-group mb-3">
  							<span class="input-group-text" id="basic-addon1"><i class="far fa-smile"></i></span>
  							<input type="text" class="form-control" value="${memberVO.memberName}" readonly="readonly">
						</div>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">연락처</label> 
						<div class="input-group mb-3">
  							<span class="input-group-text" id="basic-addon1" style="padding-right: 15px; padding-left: 15px;">
  								<i class="fas fa-mobile-alt"></i>
  							</span>
  							<input type="text" class="form-control" value="${memberVO.memberPhone}" readonly="readonly">
						</div>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">회원 유형</label> 
						<div class="input-group mb-3">
  							<span class="input-group-text" id="basic-addon1"><i class="far fa-star"></i></span>
  							<c:if test="${1 eq memberVO.memberClass}">
								<input type="text" class="form-control" value="재학생" readonly="readonly">
							</c:if>
							<c:if test="${2 eq memberVO.memberClass}">
								<input type="text" class="form-control" value="졸업생" readonly="readonly">
							</c:if>
							<c:if test="${3 eq memberVO.memberClass}">
								<input type="text" class="form-control" value="교수" readonly="readonly">
							</c:if>
							<c:if test="${4 eq memberVO.memberClass}">
								<input type="text" class="form-control" value="일반인" readonly="readonly">
							</c:if>
							<c:if test="${9 eq memberVO.memberClass}">
								<input type="text" class="form-control" value="관리자" readonly="readonly">
							</c:if>
						</div>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">가입 일자</label> 
						<div class="input-group mb-3">
  							<span class="input-group-text" id="basic-addon1"><i class="bi bi-clock"></i></span>
  							<input type="text" class="form-control" value="${memberVO.allowDate}" readonly="readonly">
						</div>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">상태</label> 
						<div class="input-group mb-3">
  							<c:if test="${0 eq memberVO.dormancyStatus}">
  								<span class="input-group-text" id="basic-addon1"><i class="bi bi-eye-fill"></i></span>
								<input type="text" class="form-control" value="활성" readonly="readonly">
							</c:if>
							<c:if test="${1 eq memberVO.dormancyStatus}">
								<span class="input-group-text" id="basic-addon1"><i class="bi bi-eye-slash-fill"></i></span>
								<input type="text" class="form-control" value="휴면" style="color: red;" readonly="readonly">
							</c:if>
						</div>
					</div>
				</div>
				<div class="box-footer" style="float: right; margin: 0px auto 50px;">
					<c:if test="${12345678 != memberVO.memberNo}">
						<button type="button" class="btn btn-outline-primary">수정</button>
					</c:if>
					<button type="button" class="btn btn-outline-dark">목록</button>
				</div>
			</div>
			</form>
		</div>
	</main>
<script>
	var result = '${msg}';

	if (result != '') {
		alert(result);
	}
</script>

<script>
	$(document).ready(function() {
		var formObj = $("form[role='form']");
		console.log(formObj);
		
		$(".btn-outline-primary").on("click", function() {
			formObj.attr("action", "/member/modify");
			formObj.attr("method", "get");
			formObj.submit();
		});
		
		$(".btn-outline-dark").on("click", function() {
			formObj.attr("method", "get");
			formObj.attr("action", "/member/list");
			formObj.submit();
		});
	});
</script>

<%@include file="../include/footer.jsp"%>
