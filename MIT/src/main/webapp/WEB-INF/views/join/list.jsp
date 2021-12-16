<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../include/header.jsp"%>

<div id="layoutSidenav_content">
	<main>
		<div class="container-fluid px-4">
			<h1 class="mt-4" style="text-align: center; margin-bottom: 30px;">가입 관리</h1>
			<div class="card mb-4">
				<div class="card-header">
					<i class="bi bi-person-plus-fill"></i> 가입 목록
				</div>
				<div class="card-body">
					<table id="datatablesSimple">
						<thead>
							<tr>
								<th style="width: 10px">NO</th>
								<th>학번</th>
								<th>이름</th>
								<th>연락처</th>
								<th>신청 일자</th>
								<th>가입 상태</th>
							</tr>
						</thead>
						<tbody><c:forEach items="${list}" var="joinVO" varStatus="status">
							<tr>
								<td>${joinVO.rnum}</td>
								<td>${joinVO.joinNo}</td>
								<td><a href='/join/read?joinNo=${joinVO.joinNo}'>
									${joinVO.joinName}
								</a></td>
								<td>${joinVO.joinPhone}</td>
								<td>${joinVO.joinDate}</td>
								<c:if test="${joinVO.allowStatus == '0'}">
									<td>대기</td>
								</c:if>
								<c:if test="${joinVO.allowStatus == '1'}">
									<td>승인</td>
								</c:if>
								<c:if test="${joinVO.allowStatus == '2'}">
									<td><span style="color:red;">거절</span></td>
								</c:if>
							</tr>
						</c:forEach></tbody>
					</table>
				</div>
			</div>
		</div>
	</main>

<script>
	var result = '${msg}';

	if (result == 'SUCCESS') {
		alert("처리가 완료되었습니다.");
	}
</script>

<%@ include file="../include/footer.jsp"%>