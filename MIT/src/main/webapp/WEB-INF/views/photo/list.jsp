<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../include/header.jsp"%>

<style>
.search-box {
	padding: 0.375rem 0.75rem;
	font-size: 1rem;
	font-weight: 400;
	line-height: 1.5;
	color: #212529;
	background-color: #fff;
	background-clip: padding-box;
	border: 1px solid #ced4da;
	-webkit-appearance: none;
	-moz-appearance: none;
	appearance: none;
	border-radius: 0.25rem;
	transition: border-color 0.15s;
}

.search-btn {
	margin-bottom: 4px;
	line-height: 1.5;
}
</style>

<div id="layoutSidenav_content">
	<main>
		<div class="container-fluid px-4">
			<h1 class="mt-4" style='text-align: center; margin-bottom: 30px;'>포토
				갤러리</h1>
			<div class="card mb-4">
				<div class="card-header">
					<span style="vertical-align: middle;"> <i
						class="bi bi-image"></i></i> 포토 갤러리 목록
					</span>
					<c:if test="${null ne login.memberNo}">
						<button class="btn btn-outline-dark btn-sm" id="newBtn"
							style="float: right; padding: 0 auto 0 auto;">새 게시글 작성</button>
					</c:if>
				</div>
				<div class="card-body">
					<div class="row">
						<div class="col-xl-6 col-md-6">
							<label> <select name="searchType"
								class="dataTable-selector">
									<option value="none"
										<c:out value="${cri.searchType == null?'selected':''}"/>>
										---</option>
									<option value="t"
										<c:out value="${cri.searchType eq 't'?'selected':''}"/>>제목</option>
									<option value="c"
										<c:out value="${cri.searchType eq 'c'?'selected':''}"/>>내용</option>
									<option value="n"
										<c:out value="${cri.searchType eq 'n'?'selected':''}"/>>학번(아이디)</option>
									<option value="tc"
										<c:out value="${cri.searchType eq 'tc'?'selected':''}"/>>
										제목 또는 내용</option>
									<option value="cn"
										<c:out value="${cri.searchType eq 'cn'?'selected':''}"/>>
										내용 또는 학번(아이디)</option>
									<option value="tcn"
										<c:out value="${cri.searchType eq 'tcn'?'selected':''}"/>>
										제목 또는 내용 또는 학번(아이디)</option>
							</select></label>
						</div>
						<div class="col-xl-6 col-md-6" align="right">
							<input class="search-box" placeholder="Search..." type="text"
								name='keyword' id="keywordInput">
							<button class="btn btn-outline-dark btn-md search-btn"
								id='searchBtn'>검색</button>
						</div>
						<!-- <div class="col-xl-2 col-md-6">
					<button class="btn btn-outline-dark btn-md" id='searchBtn'>검색</button>
				</div> -->
					</div>
				</div>



				<div class="row">
					<c:forEach items="${list}" var="photoVO" varStatus="status">
						<div class="col-xl-4 col-md-6">
							<div class="card mb-4">
								<div class="card-header">
									<i class="bi bi-image"></i> <a
										href='/photo/read?photoNo=${photoVO.photoNo}'>
										${photoVO.photoTitle}</a>
								</div>
								<div class="card-body">
									<img class="img-fluid"
										src="/displayFile?fileName=${photoVO.photoImage}" alt=""
										width="100%" height="40">
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<div class="card-body">
					<div class="dataTable-bottom">
						<nav class="dataTable-pagination">
							<ul class="dataTable-pagination-list">
								<c:if test="${pageMaker.prev}">
									<li><a
										href="list${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
								</c:if>

								<c:forEach begin="${pageMaker.startPage }"
									end="${pageMaker.endPage }" var="idx">
									<li
										<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
										<a href="list${pageMaker.makeSearch(idx)}" data-page="${idx}">${idx}</a>
									</li>
								</c:forEach>

								<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
									<li><a
										href="list${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
								</c:if>
							</ul>
						</nav>
					</div>
				</div>
			</div>
	</main>

	<!-- /.box-footer-->
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

	<script>
		$(document).ready(
				function() {

					$('#searchBtn').on(
							"click",
							function(event) {

								self.location = "list"
										+ '${pageMaker.makeQuery(1)}'
										+ "&searchType="
										+ $("select option:selected").val()
										+ "&keyword="
										+ $('#keywordInput').val();

							});

					$('#newBtn').on("click", function(evt) {

						self.location = "register";

					});

				});
	</script>

	<%@include file="../include/footer.jsp"%>