<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../include/header.jsp"%>

<div id="layoutSidenav_content">
	<main>
		<div class="container-fluid px-4">
			<h1 class="mt-4" style='text-align: center; margin-bottom: 30px;'>스터디 게시판</h1>
			<div id="img" style="text-align: center;">
			<a href = "https://www.gather.town/download">
			<img class="fit-picture" src="/resources/dist/img/wgt.PNG"
					style="height: 140px; width: auto;"></a> </div>
			<div class="card mb-4">
				<div class="card-header">
					<span style="vertical-align: middle;">
						<i class="bi bi-pencil"></i> 스터디 게시판 목록
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
							<c:forEach items="${list}" var="studyVO" varStatus="status">
								<tr>
									<td>${studyVO.rnum}</td>
									<td>
										<c:if test="${1 eq studyVO.studyClass}">
      										웹디자인
										</c:if>
										<c:if test="${2 eq studyVO.studyClass}">
											파이썬 기초
										</c:if>
									</td>
									<td>
										<a href='/study/read?studyNo=${studyVO.studyNo}'>
											${studyVO.studyTitle}
										</a>
									</td>
									<td>${studyVO.memberName}</td>
									<td>${studyVO.studyDate}</td>
									<td>${studyVO.studyView}</td>
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