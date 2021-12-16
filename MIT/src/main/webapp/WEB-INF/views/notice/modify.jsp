<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../include/header.jsp"%>

<div id="layoutSidenav_content">
	<main>
		<div class="container-fluid px-4">
			<h2 class="mt-4" style='text-align: center; margin-bottom: 30px;'>공지사항 수정하기</h2>

			<form role="form" action="modify" method="post">
				<input type='hidden' id="noticeNo" name='noticeNo' value="${noticeVO.noticeNo}">
				<input type='hidden' id="memberNo" name='memberNo' value="${noticeVO.memberNo}">
				
				<div class="input-group">
					<div class="input-group-text" style="padding-right: 20px; padding-left: 20px">제목</div>
					<input type="text" class="form-control" name='noticeTitle'
						value="${noticeVO.noticeTitle}">
				</div>
				
				<div class="row">
					<div class="col" style="padding-right: 0;">
						<div class="input-group">
							<div class="input-group-text">작성자</div>
							<input type="text" class="form-control" name="memberName"
								value="${noticeVO.memberName}" readonly="readonly">
						</div>
					</div>
					<div class="col" style="padding-left: 0;">
						<div class="input-group">
							<div class="input-group-text">작성일</div>
							<input type="text" class="form-control"
								value="${noticeVO.noticeDate}"
								readonly="readonly">
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<div class="input-group-text">내용</div>
					<textarea class="form-control" id="noticeContent" name="noticeContent">${noticeVO.noticeContent}</textarea>
				</div>
				
				<script>
    				$(document).ready(function() {
        				CKEDITOR.replace("noticeContent", {
            				/* filebrowserUploadUrl : "/common/ckUpload", */
            				height: 400
        				});
    				});
				</script>
				

				<div style="text-align: right; margin: 17px 0 17px 0;">
					<button type="submit" class="btn btn-outline-primary">수정</button>
					<button type="button" class="btn btn-outline-dark" onclick="location.href='/notice/read?noticeNo=${noticeVO.noticeNo}'">취소</button>
				</div>
			</form>
		</div>
	</main>

<%@include file="../include/footer.jsp"%>