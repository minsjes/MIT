<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../include/header.jsp"%>

<div id="layoutSidenav_content">
	<main>
		<div class="container-fluid px-4">
			<div class="box-header">
				<h1 class="mt-4" style='text-align: center; margin-bottom: 30px;'>공지사항</h1>
			</div>
		
			<form role="form" action="modify" method="post">
				<input type='hidden' name='noticeNo' value="${noticeVO.noticeNo}" id="noticeNo">
				<input type='hidden' value="${noticeVO.memberNo}" id="memberNo">
	
				<div class="row">
					<div class="col" style="padding-right: 0;">
						<div class="input-group">
					    	<div class="input-group-text">작성자</div>
							<input type="text" class="form-control" value="${noticeVO.memberName}" readonly="readonly">
						</div>
					</div>
					<div class="col" style="padding-left: 0;">
						<div class="input-group">
					    	<div class="input-group-text">작성일</div>
							<input type="text" class="form-control" value="${noticeVO.noticeDate}" readonly="readonly">
						</div>	    
					</div>
				</div>
				 
				<div class="input-group">
					<div class="input-group-text" style="padding-right: 20px; padding-left: 20px">제목</div>
					<input type="text" class="form-control" value="${noticeVO.noticeTitle}" readonly="readonly">
				</div>
				
				<div class="form-group">
					<div class="input-group-text">내용</div>
					<textarea class="form-control" id="noticeContent" readonly="readonly">${noticeVO.noticeContent}</textarea>
					<script>
	    				CKEDITOR.replace("noticeContent",{
	        				height: 400
	   					});
					</script>
				</div>
		
				<div class="box-footer" style="float: right; margin: 5px auto 5px;">
					<c:if test="${login.memberNo eq noticeVO.memberNo}">
						<button type="button" class="btn btn-outline-primary">수정</button>
						<button type="button" class="btn btn-outline-danger">삭제</button>
					</c:if>
					<button type="button" class="btn btn-outline-dark">목록</button>
				</div>
			</form>
		</div>
	</main>

<script>
	$(document).ready(function() {
		var formObj = $("form[role='form']");

		console.log(formObj);

		$(".btn-outline-primary").on("click", function() {
			formObj.attr("action", "/notice/modify");
			formObj.attr("method", "get");
			formObj.submit();
		});

		$(".btn-outline-danger").on("click", function() {
			formObj.attr("action", "/notice/remove");
			formObj.submit();
		});

		$(".btn-outline-dark").on("click", function() {
			formObj.attr("method", "get");
			formObj.attr("action", "/notice/list");
			formObj.submit();
		});

	});
</script>

<%@include file="../include/footer.jsp"%>