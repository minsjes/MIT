<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../include/header.jsp"%>

<div id="layoutSidenav_content">
	<main>
		<div class="container-fluid px-4">
			<h1 class="mt-4" style='text-align: center; margin-bottom: 30px;'>질문 게시판</h1>

			<div class="card mb-4">
				<div class="card-header">
					<span style="vertical-align: middle;">
						<i class="bi bi-question-diamond"></i> 질문 게시판 목록
					</span>
					<c:if test="${null ne login.memberNo}">
						<button class="btn btn-outline-dark btn-sm" id="newBtn" style="float: right; padding: 0 auto 0 auto;">새 게시글 작성</button>
					</c:if>
				</div>
				<div class="card-body">
					<table id="datatablesSimple">
						<thead>
							<tr>
								<th style="width: 10px">NO</th>
								<th>유형</th>
								<th>제목</th>
								<th>작성자</th>
								<th>작성일</th>
								<th>조회수</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list}" var="qnaVO" varStatus="status">
								<tr>
									<td>${qnaVO.rnum}</td>
									<td>
										<c:if test="${1 eq qnaVO.qnaClass}">동아리</c:if> 
	                        			<c:if test="${2 eq qnaVO.qnaClass}">코딩오류</c:if> 
	                        			<c:if test="${3 eq qnaVO.qnaClass}">전공과목</c:if> 
	                        			<c:if test="${4 eq qnaVO.qnaClass}">학교생활</c:if>
	                        		</td>
									<td>
										<a href='/qna/read?qnaNo=${qnaVO.qnaNo}'>
											${qnaVO.qnaTitle}
										</a>
									</td>
									<td>
										<c:if test="${0 eq qnaVO.hiddenStatus}">${qnaVO.memberName}</c:if> 
										<c:if test="${1 eq qnaVO.hiddenStatus}">익명 </c:if>
									</td>
									<td>${qnaVO.qnaDate}</td>
									<td>${qnaVO.qnaView}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</main>

<script>
	var result = '${msg}';
	
	if (result == 'REGISTER') {
		alert("등록되었습니다.");
	}

	if (result == 'MODIFY') {
		alert("수정되었습니다.");
	}

	if (result == 'REMOVE') {
		alert("삭제되었습니다.");
	}
		
	if (result == 'CANNOT') {
		alert("로그인 정보가 일치하지 않아 수정 불가능합니다.");
	}

	if (result == 'CANTDELETE') {
		alert("로그인 정보가 일치하지 않아 삭제 불가능합니다.");
	}
</script>

<script>
	$(document).ready(function() {
		$('#newBtn').on("click", function(evt) {
			self.location = "register";
		});
	});
</script>

<%@include file="../include/footer.jsp"%>