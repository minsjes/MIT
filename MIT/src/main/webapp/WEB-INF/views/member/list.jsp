<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../include/header.jsp"%>

<div id="layoutSidenav_content">
	<main>
		<div class="container-fluid px-4">
			<h1 class="mt-4" style='text-align: center; margin-bottom: 30px;'>회원 관리</h1>
			
			<div class="card mb-4">
				<div class="card-header">
					<span style="vertical-align: middle;">
						<i class="bi bi-person-lines-fill"></i> 회원 목록
					</span>
					<c:if test="${null ne login.memberNo}">
						<button class="btn btn-outline-dark btn-sm" id="newBtn" style="float: right; padding: 0 auto 0 auto;">회원 추가 등록</button>
					</c:if>
				</div>
				<div class="card-body">
					<table id="datatablesSimple">
						<thead>
							<tr>
								<th style="width: 10px">NO</th>
								<th>학번</th>
								<th>이름</th>
								<th>연락처</th>
								<th>회원 유형</th>
								<th>상태</th>
							</tr>
						</thead>
						<tbody><c:forEach items="${list}" var="memberVO" varStatus="var">
							<tr>
								<td>${memberVO.rnum}</td>
								<td>${memberVO.memberNo}</td>
								<td><a href='/member/read?memberNo=${memberVO.memberNo}'>
									${memberVO.memberName}
								</a></td>
								<td>${memberVO.memberPhone}</td>
								<td>
									<c:if test="${1 eq memberVO.memberClass}">
										재학생
									</c:if>
									<c:if test="${2 eq memberVO.memberClass}">
										졸업생
									</c:if>
									<c:if test="${3 eq memberVO.memberClass}">
										교수
									</c:if>
									<c:if test="${4 eq memberVO.memberClass}">
										일반인
									</c:if>
									<c:if test="${9 eq memberVO.memberClass}">
										관리자
									</c:if>
								</td>
								<td>
									<c:if test="${0 eq memberVO.dormancyStatus}">
										활성
									</c:if>
									<c:if test="${1 eq memberVO.dormancyStatus}">
										휴면
									</c:if>
								</td>
							</tr>
						</c:forEach></tbody>
					</table>
				</div>
			</div>
		</div>
	</main>

<script>
	var result = '${msg}';
	
	if (result == 'REGISTER') {
		alert("새로운 회원이 추가되었습니다.");
	}
	
	if (result == 'MODIFY') {
		alert("회원 정보가 수정되었습니다.");
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
