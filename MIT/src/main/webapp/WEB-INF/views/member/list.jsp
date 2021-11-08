<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../include/header.jsp"%>


<div id="layoutSidenav_content">
	<main>
	<div class="container-fluid px-4">
		<h1 class="mt-4" style='text-align: center; margin-bottom: 30px;'>회원
			관리</h1>


		<div class="card mb-4">
			<div class="card-header">
				<i class="bi bi-chat-square-text"></i> 회원 목록
				<c:if test="${null ne login.memberNo}">
					<!-- <button id='newBtn' style='float: right' onclick="register()">등록하기</button> -->
				</c:if>
			</div>

			<div class="card-body">
				<table id="datatablesSimple">
					<thead>
						<tr>
							<th>학번(아이디)</th>
							<th>이름</th>
							<th>연락처</th>
							<th>등급</th>
						</tr>
					</thead>
					<c:forEach items="${list}" var="memberVO" varStatus="var">

						<tr>
							<td>${memberVO.memberNo}</td>
							<td><a
								href='/member/readPage?memberNo=${memberVO.memberNo}'>
									${memberVO.memberName} </a></td>

							<td>${memberVO.memberPhone}</td>
							<td>${memberVO.memberClass}</td>

						</tr>

					</c:forEach>

				</table>
			</div>






			<script>
				var result = '${msg}';

				if (result == 'SUCCESS') {
					alert("수정되었습니다.");
				}
				
				if (result == 'REMOVE') {
					alert("회원 탈퇴 되었습니다.");
				}
			</script>

			<script>
				$(document).ready(
						function() {

							$('#searchBtn').on(
									"click",
									function(event) {

										self.location = "list"
												+ '${pageMaker.makeQuery(1)}'
												+ "&searchType="
												+ $("select option:selected")
														.val() + "&keyword="
												+ $('#keywordInput').val();

									});

							$('#newBtn').on("click", function(evt) {

								self.location = "register";

							});

						});
			</script>
		</div>
	</div>
	</main>

	<%@include file="../include/footer.jsp"%>