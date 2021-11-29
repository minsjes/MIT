<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@include file="../include/header.jsp"%>

<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>

<div id="layoutSidenav_content">
	<main>

	<div class="container-fluid px-4">
		<div class="box-header">
			<h2 class="mt-4" style='text-align: center; margin-bottom: 30px;'>가입
				관리</h2>
		</div>


		<form role="form" action="modify" method="post">

			<input type='hidden' name='memberNo' value="${login.memberNo}">
			<input type='hidden' name='joinNo' value="${joinVO.joinNo}">
		</form>


		<div class="card mb-4">
			<div class="card-header">
				<i class="fas fa-user fa-fw"></i> 가입 관리
			</div>

			<div class="card-body"
				style="padding-right: 25%; padding-left: 25%;">
				<div class="form-group">

					<label for="exampleInputEmail">이름</label>
					<div class="input-group mb-3">
						<span class="input-group-text" id="basic-addon1"><i
							class="far fa-user"></i></span> <input type="text" name='joinName'
							class="form-control" value="${joinVO.joinName}"
							readonly="readonly">
					</div>

				</div>

				<div class="form-group">

					<label for="exampleInputEmail">학번</label>
					<div class="input-group mb-3">
						<span class="input-group-text" id="basic-addon1"><i
							class="fas fa-graduation-cap"></i></span> <input type="text"
							name='joinNo' class="form-control" value="${joinVO.joinNo}"
							readonly="readonly">
					</div>

				</div>

				<div class="form-group">

					<label for="exampleInputEmail">전화번호</label>
					<div class="input-group mb-3">
						<span class="input-group-text" id="basic-addon1"><i
							class="fas fa-mobile-alt"></i></span> <input type="text"
							name="joinPhone" class="form-control" value="${joinVO.joinPhone}"
							readonly="readonly">
					</div>

				</div>

				<div class="form-group">

					<label for="exampleInputEmail">사유</label>
					<div class="input-group mb-3">
						<span class="input-group-text" id="basic-addon1"><i
							class="far fa-thumbs-up"></i></span>
						<textarea class="form-control" name="joinText" rows="3"
							readonly="readonly">${joinVO.joinText}</textarea>
					</div>

				</div>

				<div class="form-group">

					<label for="exampleInputEmail">신청 일자</label>
					<div class="input-group mb-3">
						<span class="input-group-text" id="basic-addon1"><i
							class="far fa-calendar-alt"></i></span> <input type="text"
							class="form-control" name="joinDate"
							value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${joinVO.joinDate}"/>"
							readonly="readonly">
					</div>

				</div>

				<div class="form-group">

					<label for="exampleInputEmail">가입 상태</label>
					<div class="input-group mb-3">
						<span class="input-group-text" id="basic-addon1"><i
							class="far fa-bell"></i></span>
						<c:if test="${joinVO.allowStatus == '0'}">
							<input type="text" name="allowStatus" class="form-control"
								value="대기" readonly="readonly">
						</c:if>
						<c:if test="${joinVO.allowStatus == '1'}">
							<input type="text" name="allowStatus" class="form-control"
								value="승인" readonly="readonly">
						</c:if>
						<c:if test="${joinVO.allowStatus == '2'}">
							<input type="text" name="allowStatus" class="form-control"
								value="거절" readonly="readonly">
						</c:if>
					</div>
				</div>
			</div>




			<div class="box-footer" style="float: right; margin: 50px auto 50px;">
				<button type="submit" class="btn btn-outline-primary">승인</button>
				<button type="submit" class="btn btn-outline-danger">거절</button>
				<button type="submit" class="btn btn-outline-dark">목록</button>
			</div>


			<script>
				$(document).ready(function() {

					var formObj = $("form[role='form']");

					console.log(formObj);

					$(".btn-outline-primary").on("click", function() {
						formObj.attr("action", "/join/modifyA");
						formObj.submit();
					});

					$(".btn-outline-danger").on("click", function() {
						formObj.attr("action", "/join/modifyB");
						formObj.submit();
					});

					$(".btn-outline-dark").on("click", function() {
						formObj.attr("method", "get");
						formObj.attr("action", "/join/list");
						formObj.submit();
					});

				});
			</script>
		</div>

	</div>
	</main>








	<%@ include file="../include/footer.jsp"%>