<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../include/header.jsp"%>

<div id="layoutSidenav_content">
	<main>
		<div class="container-fluid px-4">
			<h1 class="mt-4" style='text-align: center; margin-bottom: 30px;'>자유 게시판</h1>

			<div class="card mb-4">
				<div class="card-header">
					<span style="vertical-align: middle;">
					<i class="bi bi-chat-square-text"></i> 자유 게시판 목록
					</span>
					<c:if test="${null ne login.memberNo}">
						<button class="btn btn-outline-dark btn-sm" id="newBtn" style="float: right; padding: 0 auto 0 auto;">새 게시글 작성</button>
					</c:if>
				</div>
				<div class="card-body">
					<c:if test="${empty list}">
						<table id="datatablesSimple" class="dataTable-table">
							<thead>
								<tr>
									<th style="text-align: center;">등록된 게시글이 없습니다.</th>
								</tr>
							</thead>
						</table>
					</c:if>
					<c:if test="${!empty list}">
						<table id="datatablesSimple">
							<thead>
								<tr>
									<th style="width: 10px">NO</th>
									<th>제목</th>
									<th>작성자</th>
									<th>작성일</th>
									<th>조회수</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="freeVO" varStatus="status">
									<tr>
										<td>${freeVO.rnum}</td>
										<td>
											<a href='/free/read?freeNo=${freeVO.freeNo}'>
												${freeVO.freeTitle}
											</a>
										</td>
										<td>
											<c:if test="${0 eq freeVO.hiddenStatus}">${freeVO.memberName}</c:if> 
											<c:if test="${1 eq freeVO.hiddenStatus}">익명 </c:if>
										</td>
										<td>${freeVO.freeDate}</td>
										<td>${freeVO.freeView}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:if>
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