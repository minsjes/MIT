<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@include file="../include/header.jsp"%>

<style>
.preview-list {
	list-style: none;
	padding: 0 10px 0 10px;
}

.preview-size {
	width: auto;
	height: auto;
	max-width: 200px;
	max-height: 200px;
}

.preview-icon {
	width: auto;
	height: auto;
	max-width: 50px;
	max-height: 50px;
}

.comment-list {
	margin-bottom: 20px;
}
</style>

<div id="layoutSidenav_content">
	<main>
		<div class="container-fluid px-4">
			<h2 class="mt-4" style='text-align: center; margin-bottom: 30px;'>동아리
				소개</h2>

			<form role="form" action="modify" method="post">
				<input type='hidden' id="historyNo" name='historyNo'
					value="${historyVO.historyNo}"> <input type='hidden'
					id="memberNo" value="${historyVO.memberNo}">

				<div class="input-group">
					<div class="input-group-text" style="padding: 0 20px 0 20px;">내용</div>
					<textarea class="form-control" rows="15" readonly="readonly">${historyVO.historyContent}</textarea>
				</div>
				
				<div class="col" style="padding-left: 0;">
					<div class="input-group">
						<div class="input-group-text">작성일</div>
						<input type="text" class="form-control"
							value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${historyVO.historyDate}"/>"
							readonly="readonly">
					</div>
				</div>
		</div>

		<div style="text-align: right; margin: 17px 0 17px 0;">
		  <!-- ${login.memberNo} eq ${historyVO.memberNo} -->
			<c:if test="${login.memberNo eq historyVO.memberNo}">
				<button type="button" class="btn btn-outline-primary btn-modify">수정</button>
				<button type="button" class="btn btn-outline-danger">삭제</button>
			</c:if>
			<button type="button" class="btn btn-outline-dark">목록</button>
		</div>
		</form>
</main>
			</div>

<script>
	$(document).ready(function() {
		var formObj = $("form[role='form']");

		console.log(formObj);

		$(".btn-modify").on("click", function() {
			formObj.attr("action", "/history/modify");
			formObj.attr("method", "get");
			formObj.submit();
		});

		$(".btn-outline-danger").on("click", function() {
			formObj.attr("action", "/history/remove");
			formObj.attr("method", "post");
			formObj.submit();
		});

		$(".btn-outline-dark").on("click", function() {
			formObj.attr("action", "/history/list");
			formObj.attr("method", "get");
			formObj.submit();
		});
	});
</script>

<%@include file="../include/footer.jsp"%>