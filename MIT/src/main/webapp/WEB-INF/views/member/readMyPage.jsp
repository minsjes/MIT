<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../include/header.jsp"%>

<div id="layoutSidenav_content">
	<main>
	<div class="row">

		<div class="col-md-12">

			<div class="container-fluid px-4">
				<div class="box-header">
					<h2 class="mt-4" style='text-align: center; margin-bottom: 30px;'>내
						정보</h2>
				</div>


				<form role="form" action="readMyPage" method="post">

					<input type='hidden' name='memberNo' value="${memberVO.memberNo}">

				</form>

				<div class="card mb-4">
					<div class="card-header">
						<i class="fas fa-user fa-fw"></i> 내 정보 상세보기
					</div>

					<div class="card-body"
						style="padding-right: 350px; padding-left: 350px;">
						<div class="form-group">
							<label for="exampleInputEmail1">학번(아이디)</label>
							<div class="input-group mb-3">
								<span class="input-group-text" id="basic-addon1"><i
									class="far fa-user"></i></span> <input type="text"
									class="form-control" value="${memberVO.memberNo}"
									readonly="readonly">
							</div>
						</div>

						<div class="form-group">

							<label for="exampleInputEmail1">이름</label>
							<div class="input-group mb-3">
								<span class="input-group-text" id="basic-addon1"><i
									class="far fa-smile"></i></span> <input type="text"
									class="form-control" value="${memberVO.memberName}"
									readonly="readonly">
							</div>
						</div>

						<div class="form-group">

							<label for="exampleInputEmail1">전화번호</label>
							<div class="input-group mb-3">
								<span class="input-group-text" id="basic-addon1"><i
									class="fas fa-mobile-alt"></i></span> <input type="text"
									class="form-control" value="${memberVO.memberPhone}"
									readonly="readonly">
							</div>
						</div>

						<div class="form-group">

							<label for="exampleInputEmail1">회원유형</label>
							<div class="input-group mb-3">
								<span class="input-group-text" id="basic-addon1"> <i
									class="far fa-star"></i>
								</span>
								<c:if test="${1 eq memberVO.memberClass}">
									<input type="text" class="form-control" value="재학생"
										readonly="readonly">
								</c:if>
								<c:if test="${2 eq memberVO.memberClass}">
									<input type="text" class="form-control" value="졸업생"
										readonly="readonly">
								</c:if>
								<c:if test="${3 eq memberVO.memberClass}">
									<input type="text" class="form-control" value="교수"
										readonly="readonly">
								</c:if>
								<c:if test="${4 eq memberVO.memberClass}">
									<input type="text" class="form-control" value="일반인"
										readonly="readonly">
								</c:if>
								<c:if test="${9 eq memberVO.memberClass}">
									<input type="text" class="form-control" value="관리자"
										readonly="readonly">
								</c:if>
							</div>
						</div>
					</div>


					<div class="box-footer"
						style="float: right; margin: 50px auto 50px;">
						<button type="button" class="btn btn-outline-primary">수정</button>
						<button type="button" class="btn btn-outline-dark">메인으로</button>
					</div>
				</div>

				<%--<div class="row">
					<div class="col-6 col-12-small">
						<div class="card mb-4">
							<div class="card-header">
								<a href="/notice/list"
									style="text-decoration: none; color: black;"> <i
									class="bi bi-pencil-square"></i> 등록한 게시글
								</a>
							</div>
							<div class="card-body">
								<div class="dataTable-container">
									<c:if test="${empty list}">
										<table id="datatablesSimple" class="dataTable-table">
											<thead>
												<tr>
													<th style="text-align: center;">등록한 게시글이 없습니다.</th>
												</tr>
											</thead>
										</table>
									</c:if>
									<c:if test="${!empty list}">
										<table id="datatablesSimple" class="dataTable-table">
											<thead>
												<tr>
													<th style="width: 10px">NO</th>
													<th>유형</th>
													<th>제목</th>
													<th>작성일</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${list}" var="noticeVO" varStatus="status">
													<tr>
														<td>${noticeVO.rnum}</td>
														<td><a
															href='/notice/read?noticeNo=${noticeVO.noticeNo}'>${noticeVO.noticeTitle}</a></td>
														<td>${noticeVO.memberName}</td>
														<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
																value="${noticeVO.noticeDate}" /></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</c:if>
								</div>
							</div>

						</div>
					</div>
					<%-- <div class="col-6 col-12-small">
						<div class="card mb-4">
							<div class="card-header">
								<a href="/notice/list"
									style="text-decoration: none; color: black;"> <i
									class="bi bi-pencil-square"></i> 등록한 댓글
								</a>
							</div>
							<div class="card-body">
								<div class="dataTable-container">
									<c:if test="${empty list}">
										<table id="datatablesSimple" class="dataTable-table">
											<thead>
												<tr>
													<th style="text-align: center;">등록한 댓글이 없습니다.</th>
												</tr>
											</thead>
										</table>
									</c:if>
									<c:if test="${!empty list}">
										<table id="datatablesSimple" class="dataTable-table">
											<thead>
												<tr>
													<th style="width: 10px">NO</th>
													<th>유형</th>
													<th>제목</th>
													<th>작성일</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${list}" var="noticeVO" varStatus="status">
													<tr>
														<td>${noticeVO.rnum}</td>
														<td><a
															href='/notice/read?noticeNo=${noticeVO.noticeNo}'>${noticeVO.noticeTitle}</a></td>
														<td>${noticeVO.memberName}</td>
														<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
																value="${noticeVO.noticeDate}" /></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</c:if>
								</div>
							</div>
						</div>
					</div> 
				</div>--%>

</main>

<script>
	var result = '${msg}';

	if (result != '') {
		alert(result);
	}
</script>

<script>
	$(document).ready(function() {

		var formObj = $("form[role='form']");

		console.log(formObj);

		$(".btn-outline-primary").on("click", function() {
			formObj.attr("action", "/member/modifyMyPage");
			formObj.attr("method", "get");
			formObj.submit();
		});

		$(".btn-outline-dark").on("click", function() {
			formObj.attr("method", "get");
			formObj.attr("action", "/");
			formObj.submit();
		});

	});
</script>

<%@include file="../include/footer.jsp"%>