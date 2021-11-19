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


		<form role="form" action="modifyMyPage" method="post">

			<div class="card mb-4">
				<div class="card-header">
					<i class="fas fa-user fa-fw"></i> 내 정보 상세보기
				</div>

				<div class="card-body" style="padding-right:350px; padding-left: 350px;">
				
				
				
					<div class="form-group">
					
						<label for="exampleInputEmail1">학번(아이디)</label> 
						
						<div class="input-group mb-3">
 							 <span class="input-group-text" id="basic-addon1"><i class="far fa-user"></i></span>
  								<input type="text" name='memberNo' class="form-control" value="${memberVO.memberNo}" readonly="readonly">
						</div>
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">비밀번호</label> 
						<div class="input-group mb-3">
 							 <span class="input-group-text" id="basic-addon1"><i class="fas fa-unlock-alt"></i></span>
  								<input type="password" name='memberPw' class="form-control" value="${memberVO.memberPw}">
						</div>
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">회원명</label> 
						<div class="input-group mb-3">
  							<span class="input-group-text" id="basic-addon1"><i class="far fa-smile"></i></span>
  							<input type="text" name='memberName' class="form-control" value="${memberVO.memberName}">
						</div>
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">전화번호</label> 
						<div class="input-group mb-3">
  							<span class="input-group-text" id="basic-addon1"><i class="fas fa-mobile-alt"></i></span>
  							<input type="text" name="memberPhone" class="form-control" value="${memberVO.memberPhone}">
						</div>
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">회원등급</label> 
						<div class="input-group mb-3">
  							<span class="input-group-text" id="basic-addon1"><i class="far fa-star"></i></span>
  							<input type="text" name="memberClass" class="form-control" value="${memberVO.memberClass}" readonly="readonly">
						</div>
					</div>
				</div>

				<div class="box-footer"
					style="float: right; margin: 50px auto 50px;">
					<button type="button" class="btn btn-outline-primary">저장</button>
					<button type="button" class="btn btn-outline-dark">취소</button>
				</div>
		</form>

		<script>
			$(document)
					.ready(
							function() {

								var formObj = $("form[role='form']");

								console.log(formObj);

								$(".btn-outline-dark")
										.on(
												"click",
												function() {
													self.location = "/member/myreadPage?memberNo=${memberVO.memberNo}";
												});

								$(".btn-outline-primary").on("click",
										function() {
											formObj.submit();
										});
							});
		</script>

	</div>
</div>
</main>
<div>






	<%@include file="../include/footer.jsp"%>