<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@include file="../include/header.jsp"%>

<div id="layoutSidenav_content">
	<main>
		<div class="container-fluid px-4">
			<div id="img" style="text-align: center;">
				<img class="fit-picture" src="/resources/dist/img/MIT.png"
					style="height: 500px; width: auto;">
					
				<div class="container-fluid px-4">
					<h1 class="mt-4" style='text-align: center; margin-bottom: 30px;'>동아리
						소개</h1>
					<hr />
					"2020년에 창설된 MIT동아리 입니다."
					<hr />
					저희 동아리는 코딩에 어려운 학생들을 돕는 동아리입니다.
				</div>

				<div class="container-fluid px-4">
					<h1 class="mt-4" style='text-align: center; margin-bottom: 30px;'>연표</h1>
					<c:if test="${login.memberNo == 12345678}">
						<button class="btn btn-outline-dark btn-sm" id="newBtn"
							style="float: right; padding: 0 auto 0 auto;">동아리 소개 작성</button>
					</c:if>
					<div style="margin:auto;">
					<table>
					<colgroup>
					  <col width="20%" />
					  <col width="50%" />
					  <col width="15%" />
					  <col width="15%" />
					</colgroup>
					<c:forEach items="${list}" var="historyVO" varStatus="status">
						<tr>
							<td><a href='/history/read?historyNo=${historyVO.historyNo}'>${historyVO.historyContent}</a></td>
							<td>${historyVO.memberName}</td>
							<td>${historyVO.historyDate}</td>
							<!-- <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
									value="${historyVO.historyDate}" /></td> -->
						</tr>
					</c:forEach>
				 </table>
				   </div>
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